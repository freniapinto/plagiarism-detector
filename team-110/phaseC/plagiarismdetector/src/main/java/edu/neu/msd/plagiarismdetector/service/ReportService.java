package edu.neu.msd.plagiarismdetector.service;

import java.util.List;

import edu.neu.msd.plagiarismdetector.model.ReportDetails;

public interface ReportService {

	public void save(ReportDetails report);
	
	public ReportDetails findReportDetails(String file1, String file2);
	
	public List<ReportDetails> getStatistics();
	
}
