package edu.neu.msd.plagiarismdetector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * PlagiarismdetectorApplication is the main class to initialize and run
 * SpringBoot Application for the Plagiarism Detector
 */
@SpringBootApplication
public class PlagiarismdetectorApplication  extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(PlagiarismdetectorApplication.class, args);
	}
}
