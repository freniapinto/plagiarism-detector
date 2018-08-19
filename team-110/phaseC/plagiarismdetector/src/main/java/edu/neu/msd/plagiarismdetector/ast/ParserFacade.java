package edu.neu.msd.plagiarismdetector.ast;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import edu.neu.msd.plagiarismdetector.utilities.Constants;
import pythonParser.Python3Lexer;
import pythonParser.Python3Parser;

/**
 * CLass that loads and creates a parser for the given python file
 * 
 * @author vaibhavshukla
 *
 */
public class ParserFacade {

	/**
	 * Method that reads the string from the file
	 * 
	 * @param file
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	private static String readFile(File file, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(file.toPath());
		return new String(encoded, encoding);
	}

	
	/**
	 * method to parse the given file and rturn the tree with values assigned to
	 * each node
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String parse(File file) throws IOException {
		String code = readFile(file, Charset.forName(Constants.ENCODING_TYPE));
		Python3Lexer lexer = new Python3Lexer(new ANTLRInputStream(code));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Python3Parser parser = new Python3Parser(tokens);
		return parser.single_input().toStringTree();
	}

	/**
	 * 
	 * Method to return the string form of the file
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String parseFileString(File file) throws IOException {
		return readFile(file, Charset.forName(Constants.ENCODING_TYPE));
	}
}
