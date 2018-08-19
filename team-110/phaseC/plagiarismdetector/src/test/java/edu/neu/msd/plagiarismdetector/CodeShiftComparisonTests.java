package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import edu.neu.msd.plagiarismdetector.ast.comprison.CodeShiftComparison;

public class CodeShiftComparisonTests {

	@Test
	public void testFileParse() throws IOException {
		File file1 = new ClassPathResource("newTest.py").getFile();
		File file2 = new ClassPathResource("test123.py").getFile();
		CodeShiftComparison c = new CodeShiftComparison();
		float score = c.compare(file1, file2);
		assertEquals(21.1,score,0.1);
	}
	
	@Test
	public void testSameFileParse1() throws IOException {
		File file1 = new ClassPathResource("test123.py").getFile();
		File file2 = new ClassPathResource("test123.py").getFile();
		CodeShiftComparison c = new CodeShiftComparison();
		float score = c.compare(file1, file2);
		assertEquals(100.0,score, 0.1);
	}
	
	@Test
	public void testSameFileParse2() throws IOException {
		File file1 = new ClassPathResource("newTest.py").getFile();
		File file2 = new ClassPathResource("newTest.py").getFile();
		CodeShiftComparison c = new CodeShiftComparison();
		float score = c.compare(file1, file2);
		assertEquals(100.0,score, 0.1);
	}
	
	@Test
	public void testSameFileParse3() throws IOException {
		File file1 = new ClassPathResource("k-means.py").getFile();
		File file2 = new ClassPathResource("k-means.py").getFile();
		CodeShiftComparison c = new CodeShiftComparison();
		float score = c.compare(file1, file2);
		assertEquals(100.0,score, 0.1);
	}
	
	@Test
	public void testFileParse2() throws IOException {
		File file1 = new ClassPathResource("newTest.py").getFile();
		File file2 = new ClassPathResource("k-means.py").getFile();
		CodeShiftComparison c = new CodeShiftComparison();
		float score = c.compare(file1, file2);
		assertEquals(0.0,score, 0.1);
	}
	
	@Test
	public void testFileParse3() throws IOException {
		File file1 = new ClassPathResource("test123.py").getFile();
		File file2 = new ClassPathResource("k-means.py").getFile();
		CodeShiftComparison c = new CodeShiftComparison();
		float score = c.compare(file1, file2);
		assertEquals(0.0, score,0.1);
	}
	
	

}