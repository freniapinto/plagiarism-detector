package edu.neu.msd.plagiarismdetector.githandler;

import java.io.BufferedReader;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * class to get user name of git and get repository links
 * @author VAIBHAV
 *
 */
public class GitRepo {
	
	private Map<String,String> hm=new HashMap<>(); 
	private String userName;
	private static final Logger logger = Logger.getLogger(GitRepo.class);
	public GitRepo(String userName)
	{
		this.userName=userName;
	}
	
	/**
	 * to get user name and create URLConnection
	 * @param urlToRead
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	public static String getHTML(String urlToRead) {
		StringBuilder result = new StringBuilder();
		try {
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		return result.toString();
		}
		catch(IOException ie)
		{
			logger.log(Level.ERROR,"URL request for git repository failed");
			return "";
		}
	}

	/**
	 * Map of repository name and repository link
	 * @return
	 */
	public Map<String, String> repoDetails() {
		try
		{
			
		String placeHolder = "<user-name>";
		String url = "https://api.github.com/users/<user-name>/repos";
		String repos = getHTML(url.replace(placeHolder, userName));		
		JSONParser parser = new JSONParser();
		Object jsonObj = parser.parse(repos);		
		JSONArray gitRepos = (JSONArray) jsonObj;
		@SuppressWarnings("unchecked")
		Iterator<Object> it = gitRepos.iterator();
		while (it.hasNext()) {
			String json = it.next().toString();
			JSONObject gitRepo = (JSONObject) parser.parse(json);
			String cloneURL = (String) gitRepo.get("clone_url");
			String repoName = (String) gitRepo.get("name");
			hm.put(repoName, cloneURL);
		}
		return hm;
		}
		catch(Exception e)
		{
			return Collections.emptyMap();			
		}
	}

}
