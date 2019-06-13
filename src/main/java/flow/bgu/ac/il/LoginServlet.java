package flow.bgu.ac.il;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


import DBManager.IdTokenVerifierAndParser;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.apache.commons.io.IOUtils;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        try {
            BufferedReader br = req.getReader();
            String idToken = IOUtils.toString(br);

            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}