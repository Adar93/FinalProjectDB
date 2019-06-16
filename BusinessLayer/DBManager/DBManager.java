package DBManager;

public interface DBManager {
    boolean SaveToDB(String xml);
    String getMyObjects(String idToken);
    String getAllIDs();
    String get3DbyIDs(String IDs);
    String getXML(String ID);
    String getAllViewPoints();
    String getObjIDByViewPointID(String vpID);
}
