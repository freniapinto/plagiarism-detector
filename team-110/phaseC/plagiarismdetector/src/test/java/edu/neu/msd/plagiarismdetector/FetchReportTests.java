package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.neu.msd.plagiarismdetector.model.FetchReport;

public class FetchReportTests {

	@Test
	public void testFetchReports() {
		FetchReport fetch = new FetchReport();
		fetch.setFile1("abc");
		fetch.setFile2("xyz");
		
		assertEquals("abc", fetch.getFile1());
		assertEquals("xyz", fetch.getFile2());
		
	}

}
