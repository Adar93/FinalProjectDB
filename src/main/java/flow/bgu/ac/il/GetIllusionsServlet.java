package flow.bgu.ac.il;

import DAL.DAL_Interface;
import DAL.DAL_InterfaceImpl;
import il.ac.bgu.cs.bp.bpjs.execution.BProgramRunner;
import il.ac.bgu.cs.bp.bpjs.model.BProgram;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class GetIllusionsServlet extends HttpServlet {

	final static Logger LOG = LoggerFactory.getLogger(GetIllusionsServlet.class);
	private DAL_Interface DAI = DAL_InterfaceImpl.getInstance();
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
			throws ServletException, IOException {

		BufferedReader br = request.getReader();
		String ids = IOUtils.toString(br);
		String files = DAI.get3DbyIDs(ids);

		response.setContentType("text/plain");
		response.getWriter().println(files);
		response.setStatus(HttpServletResponse.SC_OK);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/xml;charset=UTF-8");
		//response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		//response.setHeader("Cache-control", "private, no-cache, no-store");
		//response.setHeader("Expires", "0");

	}

}
