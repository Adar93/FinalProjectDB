package DBManager;

public interface DBManager {
    boolean SaveToDB(String xml);
    String getMyObjects(String idToken);
}
