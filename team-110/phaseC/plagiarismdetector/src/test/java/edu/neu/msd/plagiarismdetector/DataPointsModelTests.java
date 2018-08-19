package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.neu.msd.plagiarismdetector.model.DataPointsModel;

public class DataPointsModelTests {

	@Test
	public void testDataModelX() {
		DataPointsModel data = new DataPointsModel();
		data.setX(25);
		assertEquals(25, data.getX());
		
		data.setX(10);
		assertEquals(10, data.getX());
	}
	
	@Test
	public void testDataModely() {
		DataPointsModel data = new DataPointsModel();
		data.setY(20);
		assertEquals(20, data.getY());
		
		data.setY(37);
		assertEquals(37, data.getY());
		
	}
	
	@Test
	public void testModelXandY() {
		DataPointsModel data = new DataPointsModel();
		data.setX(10);
		data.setY(60);
		assertEquals(10, data.getX());
		assertEquals(60, data.getY());
	}
	
	
	

}
