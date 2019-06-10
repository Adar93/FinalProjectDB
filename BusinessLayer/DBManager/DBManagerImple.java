package DBManager;

import DAL.DAL_Interface;
import DAL.DAL_InterfaceImpl;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;

public class DBManagerImple implements DBManager {
    private static DBManager single_instance = null;
    DAL_Interface dal = DAL_InterfaceImpl.getInstance();
    private Gson gson = new Gson();

    private DBManagerImple()
    {

    }

    public static DBManager getInstance()
    {
        if(single_instance  == null)
        {
            single_instance  = new DBManagerImple();
        }
        return single_instance ;
    }

    public boolean SaveToDB(String strDoc){
        BasicDBObject[] documentArr = gson.fromJson(strDoc, BasicDBObject[].class);
        String idToken = documentArr[3].get("id_token").toString();
        try {

            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String email = payLoad.getEmail();
            documentArr[2].put("Email", email);
            dal.InsertObject(documentArr);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public String getMyObjects(String idToken){
        try {
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String email = payLoad.getEmail();
            return dal.getMyObjects(email);
        } catch (Exception e) {
            return null;
        }

    }
}
