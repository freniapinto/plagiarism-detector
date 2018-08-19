package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import edu.neu.msd.plagiarismdetector.model.HWfilter;
import edu.neu.msd.plagiarismdetector.model.Report;
import edu.neu.msd.plagiarismdetector.model.ReportDetails;
import edu.neu.msd.plagiarismdetector.model.Strategyfilter;
import edu.neu.msd.plagiarismdetector.utilities.Constants;

public class ModelTests {
	
	@Test
	public void testStrategyFilter() {
		
		Strategyfilter filter = new Strategyfilter();
		filter.setStrategy("LCS");
		
		assertEquals("LCS", filter.getStrategy());
		
	}
	
	@Test
	public void testHWFilter() {
		
		HWfilter hw = new HWfilter();
		hw.setHWfilter("HMK1");
		
		assertEquals("HMK1", hw.getHWfilter());
	}
	
	@Test
	public void testReportModel() throws IOException{
		Report rep = new Report();
		File f1 = new ClassPathResource("newTest.py").getFile();
		File f2 = new ClassPathResource("test123.py").getFile();
		rep.setF1(f1);
		rep.setF2(f2);
		
		
		Map<Constants.COMPARISON_STRATEGIES, Float> comparisonResults= new HashMap<>();
		comparisonResults.put(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS, (float) 0.7);
		comparisonResults.put(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE, (float) 0.3);
		comparisonResults.put(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY, (float) 0.2);
		rep.setComparisonResults(comparisonResults);
		
		rep.setTotalScore(0.5f);
		rep.setPlagiarismLevel("mediumPlagiarised");
		
		rep.setFile1HighlightedCode("if(__main__) == 0");
		rep.setFile2HighlightedCode("if(__main__) == 0; int x=0;");
		
		assertEquals(f1,rep.getF1());
		assertEquals(f2, rep.getF2());
		
		assertEquals(comparisonResults, rep.getComparisonResults());
		assertEquals(0.5f, rep.getTotalScore(), 0.1);
		
		assertEquals("mediumPlagiarised", rep.getPlagiarismLevel());
		
		assertEquals("if(__main__) == 0", rep.getFile1HighlightedCode());
		assertEquals("if(__main__) == 0; int x=0;", rep.getFile2HighlightedCode());
	}
	
	@Test
	public void testReportModelConstructor() throws IOException{
		File f1 = new ClassPathResource("newTest.py").getFile();
		File f2 = new ClassPathResource("test123.py").getFile();		
		
		Map<Constants.COMPARISON_STRATEGIES, Float> comparisonResults= new HashMap<>();
		comparisonResults.put(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS, (float) 0.7);
		comparisonResults.put(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE, (float) 0.3);
		comparisonResults.put(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY, (float) 0.2);
		
		Report rep = new Report(f1, f2, comparisonResults, 0.5f);
		
		assertEquals(f1,rep.getF1());
		assertEquals(f2, rep.getF2());
		
		assertEquals(comparisonResults, rep.getComparisonResults());
		assertEquals(0.5f, rep.getTotalScore(), 0.1);
		
	}
	
	@Test
	public void testReportDetails() {
		ReportDetails rep = new ReportDetails();
		rep.setId((long) 1234);
		rep.setFilename1("/tmp/hmw1/test.py");
		rep.setFilename2("/tmp/hmk2/test2.py");
		
		rep.setStrategy1("LCS");
		rep.setStrategy2("EDIT_DISTANCE");
		rep.setStrategy3("COSINE");
		
		rep.setScore1("0.7");
		rep.setScore2("0.3");
		rep.setScore3("1.0");
		rep.setTotalScore("0.5");
		
		rep.setplagiarismLevel("mediumPlagiarised");
		rep.setrunDate("04/07/2018");
		rep.setfile1Substring("int x=0");
		rep.setfile2Substring("int x=0;");
		
		assertEquals((long) 1234,rep.getId(), 1);
		assertEquals("/tmp/hmw1/test.py", rep.getFilename1());
		assertEquals("/tmp/hmk2/test2.py", rep.getFilename2());
		
		assertEquals("LCS", rep.getStrategy1());
		assertEquals("EDIT_DISTANCE", rep.getStrategy2());
		assertEquals("COSINE", rep.getStrategy3());
		
		assertEquals("0.7", rep.getScore1());
		assertEquals("0.3", rep.getScore2());
		assertEquals("1.0", rep.getScore3());
		assertEquals("0.5", rep.getTotalScore());
		
		assertEquals("mediumPlagiarised", rep.getplagiarismLevel());
		assertEquals("04/07/2018", rep.getrunDate());
		assertEquals("int x=0", rep.getfile1Substring());
		assertEquals("int x=0;", rep.getfile2Substring());
		
		
		
	}
	
	
	

}
