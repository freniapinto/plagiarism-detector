package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import edu.neu.msd.plagiarismdetector.model.Report;
import edu.neu.msd.plagiarismdetector.utilities.Constants;

/**
 * 
 * Added test cases for comparison strategy min modification
 * 
 * @author vaibhavshukla
 *
 */
public class PGRunnerTests {

	@Test
	public void compareTreeforPythonFilesSimilar() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("newTest.py").getFile();
		List<File> files = new ArrayList<>();
		files.add(python3File1);
		files.add(python3File2);
		List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies = new ArrayList<>();
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		PGRunner pgRunner = new PGRunner(files, mComparisonStrategies);
		List<Report> mResults = pgRunner.run();
		
		float minDiff = mResults.get(0).getTotalScore();

		assertEquals(66.864f, minDiff, 0.01);
	}

	@Test
	public void compareTreeforPythonFilesSame() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("test123.py").getFile();
		List<File> files = new ArrayList<>();
		files.add(python3File1);
		files.add(python3File2);
		List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies = new ArrayList<>();
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		PGRunner pgRunner = new PGRunner(files, mComparisonStrategies);
		List<Report> mResults = pgRunner.run();
		float minDiff = mResults.get(0).getTotalScore();
		
		assertEquals(100.0f, minDiff, 0.01);
	}

	@Test
	public void compareTreeforPythonFilesDifferent() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("k-means.py").getFile();
		List<File> files = new ArrayList<>();
		files.add(python3File1);
		files.add(python3File2);
		List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies = new ArrayList<>();
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		PGRunner pgRunner = new PGRunner(files, mComparisonStrategies);
		List<Report> mResults = pgRunner.run();
		float minDiff = mResults.get(0).getTotalScore();

		assertEquals(0.0f, minDiff, 0.01);
	}

	@Test
	public void compareSimilarFilesEditDistance() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("newTest.py").getFile();
		List<File> files = new ArrayList<>();
		files.add(python3File1);
		files.add(python3File2);
		List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies = new ArrayList<>();
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		PGRunner pgRunner = new PGRunner(files, mComparisonStrategies);
		List<Report> mResults = pgRunner.run();
		float minDiff = mResults.get(0).getTotalScore();

		assertEquals(66.86f, minDiff, 0.01);
	}

	@Test
	public void compareSameFilesEditDistance() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("test123.py").getFile();
		List<File> files = new ArrayList<>();
		files.add(python3File1);
		files.add(python3File2);
		List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies = new ArrayList<>();
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		PGRunner pgRunner = new PGRunner(files, mComparisonStrategies);
		List<Report> mResults = pgRunner.run();
		float minDiff = mResults.get(0).getTotalScore();

		assertEquals(100.0f, minDiff, 0.01);
	}

	@Test
	public void compareDifferentFilesEditDistance() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("k-means.py").getFile();
		List<File> files = new ArrayList<>();
		files.add(python3File1);
		files.add(python3File2);
		List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies = new ArrayList<>();
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		PGRunner pgRunner = new PGRunner(files, mComparisonStrategies);
		List<Report> mResults = pgRunner.run();
		float minDiff = mResults.get(0).getTotalScore();

		assertEquals(0.0f, minDiff, 0.01);
	}

	@Test
	public void compare3FileSubmissions() throws IOException {

		File python3File1 = new ClassPathResource("test123.py").getFile();
		File python3File2 = new ClassPathResource("k-means.py").getFile();
		File python3File3 = new ClassPathResource("newTest.py").getFile();
		List<File> files = new ArrayList<>();
		files.add(python3File1);
		files.add(python3File2);
		files.add(python3File3);
		List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies = new ArrayList<>();
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
		mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		PGRunner pgRunner = new PGRunner(files, mComparisonStrategies);
		List<Report> mResults = pgRunner.run();
		float minDiff = mResults.get(0).getTotalScore();
		
		assertEquals(0.0f, minDiff, 0.01);
	}
}