package edu.neu.msd.plagiarismdetector.githandler;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

//import edu.neu.msd.plagiarismdetector.controller.UserController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.util.FileUtils;
/**
 * class to clone repository 
 * @author VAIBHAV
 *
 */
public class CloneRemoteRepository {
	private List<File> fileList = new ArrayList<>();
	Map<String,String> repoMap = new HashMap<>();
	private static final Logger logger = Logger.getLogger(CloneRemoteRepository.class);
	
	public CloneRemoteRepository(Map<String,String> repoMap)
	{
		this.repoMap=repoMap;
	}
	
	/**
	 * to clone all repo
	 * @return fileList containing cloned repo
	 */
    public List<File> cloneAllRepo()
    {
    	try
    	{
    	for (Iterator<Entry<String, String>> iterator = repoMap.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, String> m = iterator.next();
			cloneGit(m.getKey(),m.getValue());
		}
    	return fileList;
    	}
    	catch(Exception e)
    	{
    		logger.log(Level.ERROR,"Unable to clone..Returning empty file list");
    		return fileList;
    	}
    }
    
    /**
     * clone repo
     * @param repoName
     * @param repoURL
     * @throws IOException
     * @throws GitAPIException
     */
    public void cloneGit(String repoName,String repoURL) {
    	// prepare a new folder for the cloned repository
    	try
    	{
        File localPath = File.createTempFile(repoName,"");
        if(localPath.exists())
        {
        	FileUtils.delete(localPath,1);
        
        }
        // then clone
        Git git=Git.cloneRepository()
                .setURI(repoURL)
                .setDirectory(localPath)
                .call();
	    fileList.add(localPath);  
	    git.close();       	  
        
    }
    catch(Exception e)
    {
    	logger.log(Level.ERROR,"Unable to clone");
    }
    
    }
}