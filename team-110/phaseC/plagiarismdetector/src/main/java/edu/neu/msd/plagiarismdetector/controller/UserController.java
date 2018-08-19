package edu.neu.msd.plagiarismdetector.controller;

import edu.neu.msd.plagiarismdetector.PGRunner;
import edu.neu.msd.plagiarismdetector.githandler.CloneRemoteRepository;
import edu.neu.msd.plagiarismdetector.githandler.Getpyfiles;
import edu.neu.msd.plagiarismdetector.githandler.GitRepo;
import edu.neu.msd.plagiarismdetector.githandler.Localfiledisp;
import edu.neu.msd.plagiarismdetector.githandler.Subdirfilter;
import edu.neu.msd.plagiarismdetector.githandler.GitFactory;
import edu.neu.msd.plagiarismdetector.model.DataPointsModel;
import edu.neu.msd.plagiarismdetector.model.FetchReport;
import edu.neu.msd.plagiarismdetector.model.Gitlink;
import edu.neu.msd.plagiarismdetector.model.HWfilter;
import edu.neu.msd.plagiarismdetector.model.Report;

import edu.neu.msd.plagiarismdetector.model.Strategyfilter;

import edu.neu.msd.plagiarismdetector.model.ReportDetails;

import edu.neu.msd.plagiarismdetector.model.User;
import edu.neu.msd.plagiarismdetector.service.EmailService;
import edu.neu.msd.plagiarismdetector.service.ReportService;
import edu.neu.msd.plagiarismdetector.service.UserService;
import edu.neu.msd.plagiarismdetector.utilities.Constants;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

/**
 * UserController class includes REST endpoints for the login services
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private ReportService report;

	@Autowired
	private EmailService email;

	private static final String ERROR = "error";
	private static final String MESSAGE = "message";
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	private List<File> exploredFileList;
	private String logoutMsg = "You have been logged out successfully.";

	private List<String> mComparisonOutput = new ArrayList<>();

	private Map<String, String> highplag = new HashMap<>();
	private Map<String, String> medplag = new HashMap<>();
	private Map<String, String> lowplag = new HashMap<>();

	private Map<String, Integer> mLegends = new HashMap<>();

	private List<Constants.COMPARISON_STRATEGIES> mComparisonStrategies = new ArrayList<>();

	/**
	 * for registering a new user
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	/**
	 * redirect to login after successful login
	 * 
	 * @param userForm
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}

		if (userService.findByUsername(userForm.getUsername()) != null) {
			model.addAttribute(ERROR, "Username already exists");
			return "registration";

		}
		userService.save(userForm);
		logger.log(Level.INFO, "Successfully registered new User");
		return "redirect:/welcome";
	}

	/**
	 * login to get username and password
	 * 
	 * @param model
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute(ERROR, "Your username and password is invalid.");
			email.sendMessage(Constants.EMAIL_ADDRESS, "Invalid username and password", "Unauthorized access");

		}
		if (logout != null)

			model.addAttribute(MESSAGE, logoutMsg);

		return "login";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String loginpost(ModelMap modelMap, Model model) {

		return "/welcome";

	}

	/**
	 * redirection to welcome page
	 * 
	 * @param model
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model, String error, String logout) {
		model.addAttribute("gitlink", new Gitlink());
		if (error != null)
			model.addAttribute(ERROR, "Your username and password is invalid.");
		if (logout != null)

			model.addAttribute(MESSAGE, logoutMsg);

		return "welcome";
	}

	/**
	 * getting git link and cloning repo
	 * 
	 * @param gitlink
	 * @param modelMap
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.POST)
	public String getGitlink(@RequestParam("gitlink") String gitlink, ModelMap modelMap, Model model) {

		List<String> clientDispList;
    	List<String> folderfilterlist;
    	List<File> fileList;
    	Map<String,String> repo;

		modelMap.put("gitlink", gitlink);
		GitFactory gf = new GitFactory();
		GitRepo gr = gf.makeGitRepo(gitlink);
		repo = gr.repoDetails();
		if (repo.equals(Collections.emptyMap())) {
			model.addAttribute(ERROR, "Invalid git link");
			return "welcome";
		}
		CloneRemoteRepository cr = gf.makeCloneRepo(repo);
		fileList = cr.cloneAllRepo();
		Localfiledisp ld = gf.makeLocalFiledisp(fileList);
		exploredFileList = new ArrayList<>(ld.getLocalFile());
		clientDispList = ld.clientDisp(exploredFileList);

		folderfilterlist = ld.getFolderfilter();
    	Set<String> hs = new HashSet<>();
    	hs.addAll(folderfilterlist);
    	folderfilterlist.clear();
    	folderfilterlist.addAll(hs);
		model.addAttribute("clientDispList", clientDispList);
    	model.addAttribute("folderfilterlist",folderfilterlist);

		return "result";

	}

	/**
	 * display cloned repo
	 * 
	 * @param model
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String result(Model model, String error, String logout) {

		model.addAttribute("hWfilter", new HWfilter());
		if (logout != null)
			model.addAttribute(MESSAGE, logoutMsg);


		return "result";
	}

	/**
	 * Post filter-Repo on screen
	 * 
	 * @param HWfilter
	 * @param modelMap
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "result", method = RequestMethod.POST)

	public String getFilter(@ModelAttribute("HWfilter") HWfilter hWfilter, ModelMap modelMap, Model model) {
		List<String> clientFilterList;
		model.addAttribute("HWfilter",hWfilter.getHWfilter());
		modelMap.put("HWfilter", hWfilter.getHWfilter());
		String filterVal = hWfilter.getHWfilter();

		GitFactory gf = new GitFactory();
		Subdirfilter sf = gf.makeSubdirfilter(exploredFileList, filterVal);
		exploredFileList = new ArrayList<>(sf.dispfilefilter());
		clientFilterList = sf.clientDisp();
		model.addAttribute("clientFilterList", clientFilterList);
		return "repodisp";

	}

	/**
	 * display the filter folders within the repo
	 * 
	 * @param model
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/repodisp", method = RequestMethod.GET)
	public String runget(Model model, String error, String logout) {
		model.addAttribute("strategy", new Strategyfilter());
		if (logout != null)

			model.addAttribute(MESSAGE, logoutMsg);


		return "repodisp";
	}

	/**
	 * function to run the detector on the filtered repos
	 * 
	 * @param Strategyfilter
	 * @param modelMap
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/repodisp", method = RequestMethod.POST)
	public String runpost(@ModelAttribute("strategy") Strategyfilter Strategyfilter, ModelMap modelMap, Model model) {
		modelMap.put("strategy", Strategyfilter.getStrategy());
		String filterVal = Strategyfilter.getStrategy();
		Getpyfiles gp = new Getpyfiles(exploredFileList);
		addStrategies(filterVal);

		PGRunner pgRunner = new PGRunner(gp.pyfilter(), mComparisonStrategies);
		List<Report> mComparisonReports = pgRunner.run();
		for (Report each : mComparisonReports) {
			ReportDetails rd = new ReportDetails();
			rd.setFilename1(each.getF1().toString());
			rd.setFilename2(each.getF2().toString());
			rd.setTotalScore(Float.toString(each.getTotalScore()));
			rd.setplagiarismLevel(each.getPlagiarismLevel());
			rd.setfile1Substring(each.getFile1HighlightedCode());
			rd.setfile2Substring(each.getFile2HighlightedCode());

			rd.setStrategy1("STRATEGY_EDIT_DISTANCE");
			try {
				rd.setScore1(Float.toString(
						each.getComparisonResults().get(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE)));
			} catch (Exception e) {
				rd.setScore1("");
			}
			rd.setStrategy2("STRATEGY_LCS");
			try {
				rd.setScore2(
						Float.toString(each.getComparisonResults().get(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS)));
			} catch (Exception e) {
				rd.setScore2("");
			}
			rd.setStrategy3("STRATEGY_COSINE_SIMILARITY");
			try {
				rd.setScore3(Float.toString(
						each.getComparisonResults().get(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY)));
			} catch (Exception e) {
				rd.setScore3("");
			}

			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

			rd.setrunDate(dateFormat.format(date));


			report.save(rd);

		}
		getDisplayComparisonList(mComparisonReports);
		model.addAttribute("mComparisonOutput", mComparisonOutput);
		model.addAttribute("highplag", highplag);
		model.addAttribute("medplag", medplag);
		model.addAttribute("lowplag", lowplag);
		return "reportoverview";

	}

	/**
	 * function to display the report
	 * 
	 * @param model
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/reportoverview", method = RequestMethod.GET)
	public String report(Model model, String error, String logout) {
		model.addAttribute("strategy", new Strategyfilter());
		if (logout != null)

			model.addAttribute(MESSAGE, logoutMsg);


		return "reportoverview";
	}

	/**
	 * function to display the plagiarism results overview
	 * 
	 * @param modelMap
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/reportoverview", method = RequestMethod.POST)
	public String reportpost(ModelMap modelMap, Model model) {
		model.addAttribute("mComparisonOutput", mComparisonOutput);
		model.addAttribute("highplag", highplag);
		model.addAttribute("medplag", medplag);
		model.addAttribute("lowplag", lowplag);
		return "report";

	}

	/**
	 * function to display stats of the runs 
	 * 
	 * @param model
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public String getStatisticsPage(Model model, String error, String logout) {
		model.addAttribute("strategy", new Strategyfilter());
		if (logout != null)

			model.addAttribute(MESSAGE, logoutMsg);


		return "statistics";
	}

	/**
	 * function to retrieve the statistics of the runs
	 * 
	 * @param modelMap
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/statistics", method = RequestMethod.POST)
	public String statisticsPost(ModelMap modelMap, Model model) {

		Map<String, Integer> mUserStats;
		Gson gsonObj = new Gson();
		mUserStats = getDateCount();
		List<DataPointsModel> mStats = new ArrayList<>();
		int counter = 1;
		for (String s : mUserStats.keySet()) {
			DataPointsModel dp = new DataPointsModel();
			dp.setX(counter);
			dp.setY((int) mUserStats.get(s));
			mStats.add(dp);
			mLegends.put(s, counter);
			counter++;

		}

		model.addAttribute("mUserStats", gsonObj.toJson(mStats));
		model.addAttribute("mLegends", mLegends);
		return "stats";

	}

	/**
	 * function to show matched lines
	 * 
	 * @param file1
	 * @param file2
	 * @param model
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String detailreport(@RequestParam("file1") String file1, @RequestParam("file2") String file2, Model model,
			String error, String logout) {
		FetchReport fr = new FetchReport();
		model.addAttribute("file1", fr);
		model.addAttribute("file2", fr);
		if (logout != null)

			model.addAttribute(MESSAGE, logoutMsg);


		return "report";
	}

	/**
	 * function to retrieve matched lines of code from the two files
	 * 
	 * @param FetchReport
	 * @param FetchReport2
	 * @param modelMap
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/report", method = RequestMethod.POST)

	public String detailreportpost(@ModelAttribute("file1") FetchReport fetchReport,
			@ModelAttribute("file2") FetchReport fetchReport2, ModelMap modelMap, Model model) {
		Map<String, String> commonSub = new HashMap<>();
		modelMap.put("file1", fetchReport.getFile1());
		modelMap.put("file2", fetchReport2.getFile2());

		commonSub.clear();

		String file1 = fetchReport.getFile1();

		String file2 = fetchReport2.getFile2();
		ReportDetails r = report.findReportDetails("%" + file1 + "%", "%" + file2 + "%");

		commonSub.put(r.getfile1Substring(), r.getfile2Substring());

		String lcs = r.getScore2() + "%";
		String cosine = r.getScore3() + "%";
		String edit = r.getScore1() + "%";
		String total = r.getTotalScore() + "%";
		model.addAttribute("lcs", lcs);
		model.addAttribute("cosine", cosine);
		model.addAttribute("edit", edit);
		model.addAttribute("total", total);
		model.addAttribute("commonSub", commonSub);
		return "detailreport";
	}

	/**
	 * The function is used to store each files, plagiarised lines of code
	 * @param mReports
	 */

	public void getDisplayComparisonList(List<Report> mReports) {

		for (Report individualResult : mReports) {
			if (individualResult.getPlagiarismLevel().equals("highlyPlagiarised")) {
				String key = individualResult.getF1().getParentFile().getParentFile().getName() + "/"
						+ individualResult.getF1().getParentFile().getName() + "/" + individualResult.getF1().getName();
				String val = individualResult.getF2().getParentFile().getParentFile().getName() + "/"
						+ individualResult.getF2().getParentFile().getName() + "/" + individualResult.getF2().getName();
				highplag.put(key, val);
			} else if (individualResult.getPlagiarismLevel().equals("mediumPlagiarised")) {
				String key = individualResult.getF1().getParentFile().getParentFile().getName() + "/"
						+ individualResult.getF1().getParentFile().getName() + "/" + individualResult.getF1().getName();
				String val = individualResult.getF2().getParentFile().getParentFile().getName() + "/"
						+ individualResult.getF2().getParentFile().getName() + "/" + individualResult.getF2().getName();
				medplag.put(key, val);
			} else {
				String key = individualResult.getF1().getParentFile().getParentFile().getName() + "/"
						+ individualResult.getF1().getParentFile().getName() + "/" + individualResult.getF1().getName();
				String val = individualResult.getF2().getParentFile().getParentFile().getName() + "/"
						+ individualResult.getF2().getParentFile().getName() + "/" + individualResult.getF2().getName();
				lowplag.put(key, val);
			}
			StringBuilder comparisonOutput = new StringBuilder();
			comparisonOutput.append(individualResult.getF1().getName() + " - " + individualResult.getF2().getName());
			comparisonOutput.append(" | ");
			comparisonOutput.append(individualResult.getPlagiarismLevel());
			comparisonOutput.append(" | ");
			comparisonOutput.append("Weighted Similar Percent Score: " + individualResult.getTotalScore());
			comparisonOutput.append("\nPlagiarised Code: \n");
			mComparisonOutput.add(comparisonOutput.toString());
		}

	}

	/**
	 * Function to add Strategy if selected
	 * @param filterVal
	 */
	public void addStrategies(String filterVal) {
		if (filterVal.equals("LCS"))
			mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
		else if (filterVal.equals("Cosine"))
			mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		else if (filterVal.equals("Edit"))
			mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);
		else {
			mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_EDIT_DISTANCE);
			mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_LCS);
			mComparisonStrategies.add(Constants.COMPARISON_STRATEGIES.STRATEGY_COSINE_SIMILARITY);
		}

	}

	/**
	 * function to get the date and the number of times the detector is run
	 * @return Map containing date and score
	 */
	public Map<String, Integer> getDateCount() {
		Map<String, Integer> dateVal = new HashMap<>();
		List<ReportDetails> reports = report.getStatistics();
		for (ReportDetails each : reports) {
			String key = each.getrunDate();
			if (dateVal.containsKey(key)) {
				int temp = dateVal.get(key);
				dateVal.put(key, temp + 1);
			} else
				dateVal.put(key, 1);
		}


		return dateVal;

	}
}
