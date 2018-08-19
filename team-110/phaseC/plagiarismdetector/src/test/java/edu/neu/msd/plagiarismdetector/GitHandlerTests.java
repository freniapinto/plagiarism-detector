package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import edu.neu.msd.plagiarismdetector.githandler.CloneRemoteRepository;
import edu.neu.msd.plagiarismdetector.githandler.Getpyfiles;
import edu.neu.msd.plagiarismdetector.githandler.GitFactory;
import edu.neu.msd.plagiarismdetector.githandler.GitRepo;
import edu.neu.msd.plagiarismdetector.githandler.Localfiledisp;
import edu.neu.msd.plagiarismdetector.githandler.Subdirfilter;
/**
 * to test classes of githandler package which clones the git repos
 * @author VAIBHAV
 *
 */
public class GitHandlerTests {

	@Test
	public void testGitRepo() {
		GitFactory gf = new GitFactory();
		GitRepo gr = gf.makeGitRepo("preethi-anbunathan");
		Map<String,String> test=new HashMap<String,String>();
		test=gr.repoDetails();
		Map<String,String> comp=new HashMap<String,String>();
		comp.put("cs5200-spring2018-project-anbunathan_nagaraj", "https://github.com/preethi-anbunathan/cs5200-spring2018-project-anbunathan_nagaraj.git");
		comp.put("HW3JDBC", "https://github.com/preethi-anbunathan/HW3JDBC.git");
		comp.put("samplemsd", "https://github.com/preethi-anbunathan/samplemsd.git");
		assertEquals(comp,test);		
	}
	
	@Test
	public void testEmptyGitRepo() {
		GitFactory gf = new GitFactory();
		GitRepo gr = gf.makeGitRepo("");
		Map<String,String> test=new HashMap<String,String>();
		test=gr.repoDetails();
		Map<String,String> comp=new HashMap<String,String>();
		assertEquals(comp, test);		
	}
	
	@Test
	public void testCloneRepo()
	{
		GitFactory gf = new GitFactory();
		GitRepo gr = gf.makeGitRepo("cs5500");
		Map<String,String> test=new HashMap<String,String>();
		test=gr.repoDetails();
		CloneRemoteRepository cr = gf.makeCloneRepo(test);
		
		assertEquals(5,cr.cloneAllRepo().size());		
	}
	
	@Test
	public void testLocalfiledisp()
	{
		GitFactory gf = new GitFactory();
		GitRepo gr = gf.makeGitRepo("CS5500");
		Map<String,String> test=new HashMap<String,String>();
		test=gr.repoDetails();
		CloneRemoteRepository cr = gf.makeCloneRepo(test);
		List<File> fileList = new ArrayList<>();
		fileList = cr.cloneAllRepo();
		Localfiledisp lf = gf.makeLocalFiledisp(fileList);
		assertTrue(lf.getLocalFile().size()>1);
		assertTrue(lf.clientDisp(fileList).size()>1);		
	}
	
	@Test
	public void testSubdirfilter()
	{
		GitFactory gf = new GitFactory();
		GitRepo gr = gf.makeGitRepo("CS5500");
		Map<String,String> test=new HashMap<String,String>();
		test=gr.repoDetails();
		CloneRemoteRepository cr = gf.makeCloneRepo(test);
		List<File> fileList = new ArrayList<>();
		fileList = cr.cloneAllRepo();
		Subdirfilter sub = gf.makeSubdirfilter(fileList, "HMK1");
		List<String> ls = new ArrayList<String>();
		ls=sub.clientDisp();
		for(String s: ls)
		{
			assertTrue(s.contains("hmk1"));
		}
		
		
	}
	

	@Test
	public void testGetpyfiles()
	{
		GitFactory gf = new GitFactory();
		GitRepo gr = gf.makeGitRepo("CS5500");
		Map<String,String> test=new HashMap<String,String>();
		test=gr.repoDetails();
		CloneRemoteRepository cr = gf.makeCloneRepo(test);
		List<File> fileList = new ArrayList<>();
		
		fileList = cr.cloneAllRepo();
		Localfiledisp lf = new Localfiledisp(fileList);
		Getpyfiles gp = new Getpyfiles(lf.getLocalFile());
		
		assertTrue(gp.pyfilter().size()>1);
		
	}
	

}