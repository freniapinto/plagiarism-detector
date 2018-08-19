package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import edu.neu.msd.plagiarismdetector.ast.ParserFacade;
import edu.neu.msd.plagiarismdetector.ast.comprison.MinModificationComparison;
import edu.neu.msd.plagiarismdetector.ast.comprison.SimilarCodeComparison;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import edu.neu.msd.plagiarismdetector.ast.comprison.CodeShiftComparison;

/**
 * Test for plagiarism for 7 sets of projects
 */
public class PlagiarismTests {

    /**
     * Testing Project for plagiarism using Similar COde Comparison
     */
    @Test
    public void testSimilarityOfHomeworksSimilarCodeComp() throws IOException{
        File python3File1 = new ClassPathResource("homeworks/HW2/Student-1/mainAfterMerge.py").getFile();
        File python3File2 = new ClassPathResource("homeworks/HW2/Student-2/mainAfterMerge.py").getFile();
        SimilarCodeComparison sCode = new SimilarCodeComparison();
        float similarity = sCode.compare(python3File1, python3File2);
        assertEquals(0.0F, similarity,0.05f);
    }

    

    /**
     * Testing project with no plagiarism
     */
    @Test
    public void testNoPlagiarism() throws IOException {
        File python3File1 = new ClassPathResource("homeworks/HW7/Student-1/mainAfterMerge.py").getFile();
        File python3File2 = new ClassPathResource("homeworks/HW7/Student-2/mainAfterMerge.py").getFile();
        SimilarCodeComparison sCode = new SimilarCodeComparison();
        float similarity = sCode.compare(python3File1, python3File2);
        assertEquals(0.0F, similarity,0.05f);
    }


    /**
     * Test similarity of homeworks among one student using Similar Code Comparison
     */
    @Test
    public void testNoFiles() throws IOException {
        File python3File1 = new ClassPathResource("homeworks/HW5/Student-3/mainAfterMerge.py").getFile();
        File python3File2 = new ClassPathResource("").getFile();
        SimilarCodeComparison sCode = new SimilarCodeComparison();
        float similarity = sCode.compare(python3File1, python3File2);
        assertEquals(0.0F, similarity,0.05f);
    }

    /**
     * Testing Project for plagiarism using Code shift comparison
     */
    @Test
    public void testSimilarityOfHomeworksCodeShiftTwo() throws IOException{
        File file1 = new ClassPathResource("homeworks/HW6/Student-1/mainAfterMerge.py").getFile();
        File file2 = new ClassPathResource("homeworks/HW6/Student-4/mainAfterMerge.py").getFile();
        CodeShiftComparison c = new CodeShiftComparison();
        float score = c.compare(file1, file2);
        assertEquals(44.36, score,0.1);
    }

}