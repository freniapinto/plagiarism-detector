package edu.neu.msd.plagiarismdetector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.msd.plagiarismdetector.model.ReportDetails;
import edu.neu.msd.plagiarismdetector.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportRepository reportRepository;
	
	@Override
	public void save(ReportDetails report) {
		reportRepository.save(report);
		
	}

	@Override
	public ReportDetails findReportDetails(String file1, String file2) {
		return reportRepository.findReportDetails(file1, file2);
	}


	@Override
	public List<ReportDetails> getStatistics() {
		return reportRepository.getStatistics();
	}

	
	

}

