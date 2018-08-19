package edu.neu.msd.plagiarismdetector.githandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 * class to filter the repositories based on homework
 * @author VAIBHAV
 *
 */
public class Subdirfilter {
	
	private List<File> fileList = new ArrayList<>();
	private List<File> filterList = new ArrayList<>();
	private String filterVal;
	
	List<String> dispClient = new ArrayList<>();
	
	public Subdirfilter(List<File> fileList, String filterVal)
	{
		this.fileList=fileList;
		this.filterVal=filterVal;
	}
	/**
	 * to display repositories that match filter value
	 * @return
	 */
	public List<File> dispfilefilter()
	{
		for(File file:fileList)
		{
			if(file.getName().equalsIgnoreCase(filterVal))
			{
				filterList.add(file);
			}
		}
		return filterList;		
	}
	
	/**
	 * to display the filtered repositories to client
	 * @return list of filtered repositories
	 */
	public List<String> clientDisp()
	{
	    String parentDir;
	    String childDir;
		 String clientPath;
		for(File file:filterList)
		{
			parentDir=file.getParentFile().getName();
			childDir= file.getName();
			clientPath=parentDir+"/"+childDir;
			
			dispClient.add(clientPath);
		}
		return dispClient;
	}

}
