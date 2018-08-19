package edu.neu.msd.plagiarismDetector;

import java.util.List;

public class Submission {
	List<File> f;
	String studentName;
	String hmkType;
	
	
	public List<File> getF() {
		return f;
	}
	public void setF(List<File> f) {
		this.f = f;
	}
	
	public String getHmkType() {
		return hmkType;
	}
	public void setHmkType(String hmkType) {
		this.hmkType = hmkType;
	}
	

}
