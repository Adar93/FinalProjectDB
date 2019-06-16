package flow.bgu.ac.il;

import DBManager.DBManager;
import il.ac.bgu.cs.bp.bpjs.execution.BProgramRunner;
import il.ac.bgu.cs.bp.bpjs.model.BProgram;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class SimilaritiesServlet extends HttpServlet {

	final static Logger LOG = LoggerFactory.getLogger(SimilaritiesServlet.class);
	private DBManager BLM;

	public SimilaritiesServlet(DBManager blm){
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
        String ids = IOUtils.toString(br);
        String objIDs = BLM.getObjIDByViewPointID(ids);

        response.setContentType("text/plain");
        response.getWriter().println(objIDs);
        response.setStatus(HttpServletResponse.SC_OK);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String ans = BLM.getAllViewPoints();
		response.setContentType("text/plain");
		response.getWriter().println(ans);
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
