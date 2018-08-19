package edu.neu.msd.plagiarismdetector.githandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class Getpyfiles {

	List<File> inList = new ArrayList<>();
	List<File> finalList = new ArrayList<>();
	List<File> temp = new ArrayList<>();
	private static final String FILETYPE = ".py";
	private static final Logger logger = Logger.getLogger(Getpyfiles.class);

	public Getpyfiles(List<File> lf) {
		this.inList = lf;
	}

	/**
	 * to iterate through a list of files and return a file list of .py files
	 */
	public List<File> pyfilter() {
		try {
			for (File file : inList) {
				findFiles(file);
				srctest(temp);
			}

		} catch (Exception e) {
			logger.log(Level.ERROR, "No file with given extension found");
		}


		return new ArrayList<>(new HashSet<>(finalList));
	}

	/**
	 * to filter out .py files
	 * 
	 * @param root
	 */
	public void findFiles(File root) {
		File[] files = root.listFiles();
		try {
			for (File file : files) {


				if (file.isFile() && file.getName().endsWith(FILETYPE)) {
					finalList.add(file);
				} else if (file.isDirectory() && !file.getParentFile().getName().equals(".git")) {
					temp.add(file);

				}
			}
		} catch (Exception e) {
			logger.log(Level.ERROR, "No file with given extension found");
		}
	}

	/**
	 * to get matching files of same student but different folders like src/test
	 * 
	 * @param f
	 * @throws IOException
	 */

	public void srctest(List<File> f) {

		for (int i = 0; i < temp.size() - 1; i++)
			for (int k = i + 1; k < temp.size(); k++) {

				if (temp.get(i).getParentFile().getParentFile().getName()
						.equals(temp.get(k).getParentFile().getParentFile().getName()))
					if (temp.get(i).getParentFile().getName().equals(temp.get(k).getParentFile().getName())) {

						interfile(temp.get(i), temp.get(k));
					}
			}
	}

	/**
	 * get .py files from src/test folders
	 * 
	 * @param f1
	 * @param f2
	 */
	public void interfile(File f1, File f2) {

		File[] file1 = f1.listFiles();

		File[] file2 = f2.listFiles();
		File m1 = f1;
		File m2 = f2;
		for (File file : file1) {

			if (file.isFile() && file.getName().endsWith(".py")) {
				m1 = file;
			}

			else if (file.isDirectory()) {
				temp.add(file);
			}
		}
		for (File filee : file2) {

			if (filee.isFile() && filee.getName().endsWith(".py")) {
				m2 = filee;
			}

			else if (filee.isDirectory()) {
				temp.add(filee);
			}
		}
		mergefile(m1, m2);

	}

	/**
	 * to merge .py files of src and test folders
	 * 
	 * @param m1
	 * @param m2
	 */
	public void mergefile(File m1, File m2) {
		try {

			File m3 = new File(m1.getParentFile().getParentFile() + "/merge.py");
			PrintWriter pw = new PrintWriter(m3);

			// BufferedReader object for file1.txt
			BufferedReader br = new BufferedReader(new FileReader(m1));

			String line = "#" + m1.getName() + "\n" + br.readLine();

			// loop to copy each line of
			// file1.txt to file3.txt
			while (line != null) {
				pw.println(line);
				line = br.readLine();
			}

			br = new BufferedReader(new FileReader(m2));

			line = "\n\n#" + m2.getName() + "\n" + br.readLine();

			// loop to copy each line of
			// file2.txt to file3.txt
			while (line != null) {
				pw.println(line);
				line = br.readLine();
			}

			pw.flush();

			// closing resources
			br.close();
			pw.close();

			finalList.add(m3);
		} catch (Exception e) {
			logger.log(Level.ERROR,"Unable to merge");
		}
	}
}