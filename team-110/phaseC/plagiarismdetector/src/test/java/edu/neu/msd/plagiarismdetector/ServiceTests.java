package edu.neu.msd.plagiarismdetector;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import edu.neu.msd.plagiarismdetector.model.ReportDetails;
import edu.neu.msd.plagiarismdetector.model.User;
import edu.neu.msd.plagiarismdetector.service.ReportService;
import edu.neu.msd.plagiarismdetector.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Random;

import org.springframework.test.context.ContextConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={PlagiarismdetectorApplication.class})

public class ServiceTests {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReportService reportService;
	
	
    @Test
    public void testStatus200Endpoints() throws Exception {
    	
    	this.mockMvc = webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
        
        mockMvc.perform(get("/registration"))
        .andExpect(status().isOk());
        
        mockMvc.perform(get(""))
        .andExpect(status().isOk());
        
        mockMvc.perform(get("/"))
        .andExpect(status().isOk());
        
        mockMvc.perform(get("/welcome"))
        .andExpect(status().isOk());
        
        mockMvc.perform(get("/result"))
        .andExpect(status().isOk());
        
        mockMvc.perform(get("/repodisp"))
        .andExpect(status().isOk());
        
        mockMvc.perform(get("/reportoverview"))
        .andExpect(status().isOk());
        
        mockMvc.perform(get("/statistics"))
        .andExpect(status().isOk());
       
    }
    
    @Test
    public void testUserService() {
    	Random rand = new Random();
    	String name = "test"+rand.nextInt();
    	User u = new User();
		u.setUsername(name);
		u.setPassword("123");
		userService.save(u);
		
		assertEquals(name, userService.findByUsername(name).getUsername());
		
    }
    
    @Test
    public void testReportService() {
    	
    	Random rand = new Random();
    	ReportDetails rep = new ReportDetails();
    	long val = rand.nextLong();
    	String file1 = "/tmp/hmw1/test"+val+".py";
    	String file2 = "/tmp/hmk2/test2"+val+".py";
		rep.setId(val);
		rep.setFilename1(file1);
		rep.setFilename2(file2);
		
		rep.setStrategy1("LCS");
		rep.setStrategy2("EDIT_DISTANCE");
		rep.setStrategy3("COSINE");
		
		rep.setScore1("0.7");
		rep.setScore2("0.3");
		rep.setScore3("1.0");
		rep.setTotalScore("0.5");
		
		rep.setplagiarismLevel("mediumPlagiarised");
		rep.setrunDate("04/07/2018");
		rep.setfile1Substring("int x=0");
		rep.setfile2Substring("int x=0;");
		
		reportService.save(rep);
		
		assertEquals("04/07/2018",reportService.findReportDetails(file1, file2).getrunDate());
		
		assertTrue(1<=reportService.getStatistics().size());
		
		
    }
    
    
    
    
    
    
    
}
