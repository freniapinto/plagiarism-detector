package edu.neu.msd.plagiarismdetector.ast.comprison;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.msd.plagiarismdetector.ast.ParserFacade;

public class FetchCommonSubString {
	
	private static final Logger logger = Logger.getLogger(FetchCommonSubString.class);
	
	
	private FetchCommonSubString()
	{
		
	}

	/**
	 * Method to retrive the file
	 * @param f1
	 * @param f2
	 * @return
	 */
	  public static List<String> getHighLightedFiles(File f1, File f2)
	  {
		  List<String> mHighLightedFiles = new ArrayList<>();
		  ParserFacade pF = new ParserFacade();
			String file1ASTResp = "";
			String file2ASTResp = "";
			String finalString = "";
				try {
					file1ASTResp = pF.parseFileString(f1);
					file2ASTResp = pF.parseFileString(f2);
					finalString = longestSubstring(file1ASTResp, file2ASTResp);
				} catch (IOException e) {
					logger.log(Level.ERROR,"Unable read file and fetch string");
				}
				mHighLightedFiles.add(higlightString(file1ASTResp,finalString));
				
				mHighLightedFiles.add(higlightString(file2ASTResp,finalString));
			return mHighLightedFiles;	
	  }
	  
	  
	  
	  public static String higlightString(String mainString, String subString)
	  {
		 
		  int startCounter = mainString.toLowerCase().trim().indexOf(subString.toLowerCase().trim());
		  
		  int endCounter = startCounter+subString.toLowerCase().trim().length();
		  if (startCounter>=endCounter || startCounter<0 || endCounter<0)
			  return mainString;
		 StringBuilder strBuilder = new StringBuilder();
		 strBuilder.append(mainString.substring(0, startCounter));
		 strBuilder.append("//");
		 strBuilder.append(mainString.substring(startCounter,endCounter-1));
		 strBuilder.append("//");
		 strBuilder.append(mainString.substring(endCounter-1,mainString.length()-1));
		
		 return attachDelimiteratEndOfLine(strBuilder.toString());
	  }
	
	  public static String attachDelimiteratEndOfLine(String str)
	  {
		  String[] lines = str.split(System.getProperty("line.separator"));  
		  for(int i =0;i<lines.length ; i++)
		  {
			   
			  if(lines[i].contains("//"))
			  {
				  
				lines[i]+="//"+"<br>";
				if(StringUtils.countMatches(lines[i], "//")>1)
					continue;
				while(true)
				{
					i++;
					if(lines[i].contains("//"))
					{
						lines[i]="//"+lines[i]+"<br>";
						break;
					}
					else
					lines[i] = "//"+lines[i+1]+"//" +"<br>";
				}
				  
			  }
			  
			lines[i]+="<br>";
		  }
		  String s = "";
		 for(String l : lines)
		 {
			 s+=l;
		 }
		 return s;
	  }
	  
	  /**
	   * 
	   * @param str1
	   * @param str2 
	   * @return
	   */
	  public static String longestSubstring(String str1, String str2) {

		  StringBuilder sb = new StringBuilder();
		  if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty())
		    return "";

		  // ignore case
		  str1 = str1.toLowerCase();
		  str2 = str2.toLowerCase();

		  // java initializes them already with 0
		  int[][] num = new int[str1.length()][str2.length()];
		  int maxlen = 0;
		  int lastSubsBegin = 0;

		  for (int i = 0; i < str1.length(); i++) {
		  for (int j = 0; j < str2.length(); j++) {
		    if (str1.charAt(i) == str2.charAt(j)) {
		      if ((i == 0) || (j == 0))
		         num[i][j] = 1;
		      else
		         num[i][j] = 1 + num[i - 1][j - 1];

		      if (num[i][j] > maxlen) {
		        maxlen = num[i][j];
		        // generate substring from str1 => i
		        int thisSubsBegin = i - num[i][j] + 1;
		        if (lastSubsBegin == thisSubsBegin) {
		           //if the current LCS is the same as the last time this block ran
		           sb.append(str1.charAt(i));
		        } else {
		           //this block resets the string builder if a different LCS is found
		           lastSubsBegin = thisSubsBegin;
		           sb = new StringBuilder();
		           sb.append(str1.substring(lastSubsBegin, i + 1));
		        }
		     }
		  }
		  }}

		  return sb.toString();
		  }
}
