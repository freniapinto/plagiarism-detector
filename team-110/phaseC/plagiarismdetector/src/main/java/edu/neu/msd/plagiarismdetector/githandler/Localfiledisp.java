package edu.neu.msd.plagiarismdetector.githandler;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
/**
 * to display cloned repository to user
 * @author VAIBHAV
 *
 */
public class Localfiledisp {
	private List<File> fileList = new ArrayList<>();
	private List<File> fList = new ArrayList<>();
	private List<String> dispClient = new ArrayList<>();
	private List<String> folderfilterlist = new ArrayList<>();
	private static final Logger logger = Logger.getLogger(Localfiledisp.class);

	public Localfiledisp(List<File> fList)
	{
		this.fList= fList;
	}
	
	/*
	 * get cloned repository in local directory
	 */
	public List<File> getLocalFile()
	{
		try
		{
		for(File file:fList)
		{
			dispfile(file);			
		}
		return fileList;
		}
		catch(Exception e)
		{
			logger.log(Level.INFO,"Unable to fetch cloned files");
			return fileList;
		}
	}
	
	public List<String> getFolderfilter()
	{
		return folderfilterlist;
	}
	
	//public List<String> getClientDisp()
	/**
	 * @param File
	 * to append the first folder inside all repositories
	 */
	public void dispfile(File f)
	{
		String s;
		String[] directories = f.list(new FilenameFilter() {
			  public boolean accept(File current, String name) {
			    return new File(current, name).isDirectory();
			  }
			});
		for (String folder:directories)
		{
			if(!folder.equals(".git"))
			{
			folderfilterlist.add(folder);
			s= f.toString()+"/"+folder;
			fileList.add(new File(s));	
			}	
		}
	}
	
	// what to display on screen
	/**
	 * to display directory to client
	 * @param finalFlist
	 * @return
	 */
	public List<String> clientDisp(List<File> finalFlist)
	{
		String parentDir;
		String childDir;
		String clientPath;
		for(File file:finalFlist)
		{			
			parentDir=file.getParentFile().getName();
			childDir= file.getName();
			clientPath=parentDir+"/"+childDir;
			
			dispClient.add(clientPath);				
		}
		return dispClient;
	}

}
