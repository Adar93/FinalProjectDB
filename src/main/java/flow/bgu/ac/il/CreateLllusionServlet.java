package flow.bgu.ac.il;

import DBManager.*;
import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import il.ac.bgu.cs.bp.bpjs.execution.BProgramRunner;

import il.ac.bgu.cs.bp.bpjs.model.BProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateLllusionServlet extends HttpServlet {

	final static Logger LOG = LoggerFactory.getLogger(GetObjectsServlet.class);
	private DBManager BLM;

	public CreateLllusionServlet(DBManager blm){
		this.BLM = blm;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1598336877581962216L;

	// A hack that only works if one program is running at a time!
	public static BProgram bprog;
	public static BProgramRunner rnr;

	private static Thread thread;

	/**
	 * Handles save request and prints XML.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		BufferedReader br = request.getReader();
		String info = IOUtils.toString(br);
		boolean ans = BLM.SaveToDB(info);
		if (ans){
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else
			response.setStatus(10);
	}

}
