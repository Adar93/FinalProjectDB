package DAL;

import com.mongodb.BasicDBObject;

public interface DAL_Interface {
     boolean Connect();
     void disconnect();

     boolean InsertObject(BasicDBObject[] documentArr);
     boolean DeleteObject(String objID);
     String getMyObjects(String email);
     String getAllIDs();
     String get3DbyIDs(String IDs);
     String getXML(String ID);
     String getAllViewPoints();
     String getObjIDByViewPointID(String vpID);
     int CountObject();
     int CountVPs();
}
