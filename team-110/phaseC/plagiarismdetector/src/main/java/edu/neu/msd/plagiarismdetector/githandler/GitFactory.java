package edu.neu.msd.plagiarismdetector.githandler;

import java.io.File;
import java.util.List;
import java.util.Map;
/**
 * factory class for git handler
 * @author VAIBHAV
 *
 */
public class GitFactory {
	
	/**
	 * to create an object for GitRepo class
	 * @param userName
	 * @return
	 */
	public GitRepo makeGitRepo(String userName)
	{
		return new GitRepo(userName);
	}
	
	/**
	 * to create an object for CloneRemoteRepository
	 * @param repoMap
	 * @return
	 */
	public CloneRemoteRepository makeCloneRepo(Map<String,String> repoMap)
	{
		return new CloneRemoteRepository(repoMap);
	}
	
	/**
	 * to create an object for Localfiledisp
	 * @param fList
	 * @return
	 */
	public Localfiledisp makeLocalFiledisp(List<File> fList)
	{
		return new Localfiledisp(fList);
	}
	
	/**
	 * to create an object for Subdirfilter
	 * @param fileList
	 * @param filterVal
	 * @return
	 */
	public Subdirfilter makeSubdirfilter(List<File> fileList, String filterVal)
	{
		return new Subdirfilter(fileList,filterVal);
	}
	

}
