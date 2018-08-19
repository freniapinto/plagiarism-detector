package edu.neu.msd.plagiarismdetector.ast.comprison;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import edu.neu.msd.plagiarismdetector.ast.ParserFacade;

/**
 * Class CodeShiftComparison checks if position of functions
 * has been replaced
 * @author frenia
 *
 */
public class CodeShiftComparison implements FileComparable{

	private static final Logger logger = Logger.getLogger(CodeShiftComparison.class);
	private static final int counter =3;
	private static final int constant =100;
	/**
	 * The function compares two files based on 
	 * changing positions of the functions in the code
	 */
	@Override
	public float compare(File file1, File file2) {
		ParserFacade pf = new ParserFacade();
		float score =0f;
		if(file1.exists() && file2.exists()) {
			try {
			String contentsFile1 = pf.parseFileString(file1);
			String contentsFile2 = pf.parseFileString(file2);
			score = getScore(contentsFile1, contentsFile2);
			}
			catch(Exception e) {
				logger.log(Level.ERROR, "Issue while parsing the python files");
			}
		}
		
		return (score*constant);
	}
	
	/**
	 * Function to implement Cosine Similarity and return
	 * the similarity score
	 * @param c1
	 * @param c2
	 * @return float score
	 */
	private float getScore(String c1, String c2) {
		List<String> ngram1 = generateNGrams(c1);
		List<String> ngram2 = generateNGrams(c2);

		Map<String, Double> tf1 = getNgramCount(ngram1);
		Map<String, Double> tf2 = getNgramCount(ngram2);
		
        List<String> idf = new ArrayList<>(ngram1);
        idf.addAll(ngram2);
        
        Set<String> idfSet = new HashSet<>(idf);
        List<String> newIdf = new ArrayList<>(idfSet);
        
        Map<String, Double> idfmap = new HashMap<>();
        
        int occurences =0;
        for(String each: newIdf) {
        	if (tf1.containsKey(each) && tf2.containsKey(each)) {
        		occurences = 2;
        	}
        	else if (tf1.containsKey(each) || tf2.containsKey(each)) {
        		occurences = 1;
        	}
        	double freq =1.0;
        	try {
        		freq = 1+Math.log(2.0/occurences);
        	}
        	catch(Exception e) {
        		freq =1.0;
        	}
        	idfmap.put(each, freq);
        }
        
        Map<String, Double> scores1 = new HashMap<>();
        Map<String, Double> scores2 = new HashMap<>();
        
        double denom1 = 0.0;
        
        for (Map.Entry<String, Double> entry : tf1.entrySet()) {
        	double value = entry.getValue()*idfmap.get(entry.getKey());
        	scores1.put(entry.getKey(),value);
        	denom1= denom1+Math.pow(value,2);
        }
        
        double denom2 = 0.0;
        
        for (Map.Entry<String, Double> entry : tf2.entrySet()) {
        	double value = entry.getValue()*idfmap.get(entry.getKey());
        	scores2.put(entry.getKey(),value);
        	denom2= denom2+Math.pow(value,2);
        }
        
        double numerator = 0.0;
        double denominator = Math.sqrt(denom1) * Math.sqrt(denom2);
        
        List<String> list1 = new ArrayList<>(tf1.keySet());
        List<String> list2 = new ArrayList<>(tf2.keySet());
        list1.retainAll(list2);
        
        for (String each: list1) {
        	numerator= numerator+ (scores1.get(each) * scores2.get(each));
        }

        
        return (float) (numerator/denominator);
       
	}
	
	/**
	 * Function to calculate the frequency of the ngrams
	 * and normalize the scores
	 * @param str
	 * @return Map of ngram and count
	 */
	private Map<String,Double> getNgramCount(List<String> str){
		Map<String, Double> hp = new HashMap<>();
		
		for (String each: str) {
			if (hp.containsKey(each)) {
				hp.put(each, hp.get(each)+1.0);
			}
			else hp.put(each, 1.0);
		}
		double len =0;
		for (Map.Entry<String, Double> entry : hp.entrySet()) {
			len= len + entry.getValue();
		}
		if (len == 0.0) len=1.0;
		for (Map.Entry<String, Double> entry : hp.entrySet()) {
			hp.put(entry.getKey(), entry.getValue()/len);
			
		}
		return hp;
	}
	
	/**
	 * Functions that returns a list of Ngrams 
	 * for a given String
	 * @param s
	 * @return List of ngrams
	 */
	private List<String> generateNGrams(String s){
		String[] line = s.split("\\s+");
		List<String> ngram = new ArrayList<>();
		for (int i =0; i<line.length-counter; i++) {
			ngram.add(line[i]+" "+line[i+1]+" "+line[i+2]);
		}
		
		
		return ngram;
	}
	
	
	
	

}