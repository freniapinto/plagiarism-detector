package edu.neu.msd.plagiarismdetector.model;

import javax.persistence.*;

@Entity
@Table(name = "ReportDetails")
public class ReportDetails {
	
	private Long id;
	
	@Column(name="filename1")
	private String filename1;
	
	@Column(name="filename2")
	private String filename2;
	
	@Column(name="strategy1")
	private String strategy1;
	
	@Column(name="score1")
	private String score1;
	
	@Column(name="strategy2")
	private String strategy2;
	
	@Column(name="score2")
	private String score2;
	
	@Column(name="strategy3")
	private String strategy3;
	
	@Column(name="score3")
	private String score3;
	
	@Column(name="totalScore")
	private String totalScore;
	
	@Column(name="plagiarismLevel")
	private String plagiarismLevel;

	@Column(name ="file1Substring")
	private String file1Substring;
	
	@Column(name ="file2Substring")
	private String file2Substring;
	
	@Column(name="runDate")
	private String runDate;
	
	/**
     * @return id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
    	this.id =id;
    }
    
    public String getFilename1() {
    	return filename1;
    }
    
    public void setFilename1(String filename1) {
    	this.filename1 = filename1;
    }
    
    public String getFilename2() {
    	return filename2;
    }
    
    public void setFilename2(String filename2) {
    	this.filename2 = filename2;
    }
    
    
    public String getStrategy1() {
    	return strategy1;
    }
    
    public void setStrategy1(String strategy1) {
    	this.strategy1= strategy1;
    }
    
    public String getScore1() {
    	return score1;
    }
    
    public void setScore1(String score1) {
    	this.score1=score1;
    }
    
    public String getStrategy2() {
    	return strategy2;
    }
    
    public void setStrategy2(String strategy2) {
    	this.strategy2= strategy2;
    }
    
    public String getScore2() {
    	return score2;
    }
    
    public void setScore2(String score2) {
    	this.score2=score2;

    }
    
    public String getStrategy3() {
    	return strategy3;
    }
    
    public void setStrategy3(String strategy3) {
    	this.strategy3= strategy3;
    }
    
    public String getScore3() {
    	return score3;
    }
    
    public void setScore3(String score3) {
    	this.score3=score3;
    }
    
    
    public String getTotalScore() {
    	return totalScore;
    }
    
    public void setTotalScore(String totalScore) {
    	this.totalScore = totalScore;
    }
    
    public String getplagiarismLevel() {
    	return plagiarismLevel;
    }
    
    public void setplagiarismLevel(String plagiarismLevel) {
    	this.plagiarismLevel=plagiarismLevel;
    }
    
    public String getfile1Substring() {
     	return file1Substring;
       }
      
    public void setfile1Substring(String file1Substring) {
    	   	this.file1Substring=file1Substring;
    	   }
    
    public String getfile2Substring() {
     	return file2Substring;
       }
      
    public void setfile2Substring(String file2Substring) {
    	   	this.file2Substring=file2Substring;
    	   }

    
    public String getrunDate() {
    	return runDate;
    }
    
    public void setrunDate(String runDate) {
    	this.runDate=runDate;
    }
    
    
    
    

}
