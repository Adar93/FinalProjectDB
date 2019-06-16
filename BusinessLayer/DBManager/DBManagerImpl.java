package DBManager;

import DAL.DAL_Interface;
import DAL.DAL_InterfaceImpl;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;

public class DBManagerImpl implements DBManager {
    private DAL_Interface dal = new DAL_InterfaceImpl();
    private Gson gson = new Gson();

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

    @Override
    public String getAllIDs() {
        return dal.getAllIDs();
    }

    @Override
    public String get3DbyIDs(String IDs) {
        return dal.get3DbyIDs(IDs);
    }

    @Override
    public String getXML(String ID) {
        return dal.getXML(ID);
    }

    @Override
    public String getAllViewPoints() {
        return dal.getAllViewPoints();
    }

    @Override
    public String getObjIDByViewPointID(String vpID) {
        return dal.getObjIDByViewPointID(vpID);
    }
}
