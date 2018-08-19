package edu.neu.msd.plagiarismdetector.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.neu.msd.plagiarismdetector.model.ReportDetails;

@Repository
public interface ReportRepository extends JpaRepository<ReportDetails, Long>{

	@Query("select r from ReportDetails r where r.filename1 LIKE :file1 and r.filename2 LIKE :file2 ")
	  ReportDetails findReportDetails(@Param("file1") String file1,
	                                 @Param("file2") String file2);
	
	
	@Query("select r from ReportDetails r")
	List<ReportDetails> getStatistics();
}
