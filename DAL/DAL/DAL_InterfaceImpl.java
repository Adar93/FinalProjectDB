package DAL;

import Graph.Edge;
import Graph.*;
import Shapes.Shape;
import com.google.gson.Gson;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.json.JSONObject;

import java.util.*;


public class DAL_InterfaceImpl implements DAL_Interface {
    private String connectionString = "mongodb://localhost:27017";
    private DB db;
    private MongoClient mongoClient;
    private DBCollection Objects;
    private DBCollection ViewPoints;
    private static DAL_Interface single_instance = null;
    private Gson gson = new Gson();

    private DAL_InterfaceImpl()
    {

    }

    public static DAL_Interface getInstance()
    {
        if(single_instance  == null)
        {
            single_instance  = new DAL_InterfaceImpl();
        }
        return single_instance ;
    }

    public boolean Connect(){
        try {
            //String connectionString = "mongodb://adar93:Adriel93%21@cluster0-shard-00-00-wy3je.gcp.mongodb.net:27017,cluster0-shard-00-01-wy3je.gcp.mongodb.net:27017,cluster0-shard-00-02-wy3je.gcp.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true";

            MongoClientURI uri = new MongoClientURI(connectionString);
            mongoClient = new MongoClient(uri);
            db = mongoClient.getDB("IllusionsDB");
            Objects = db.getCollection("Objects");
            ViewPoints = db.getCollection("ViewPoints");
            return true;
        }catch(Exception ie) {
            ie.printStackTrace();
        }
        return false;
    }

    public void disconnect() {
        mongoClient.close();
    }

    public String getAllViewPoints() { // return map of vp's id and vp's shapes
        this.Connect();

        List<String> allViewPoints = new LinkedList<String>();
        DBCursor cursor = ViewPoints.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            String myJson = new JSONObject()
                    .put("id",obj.get("ObjectId").toString() )
                    .put("circles", obj.get("Circles").toString())
                    .put("lines", obj.get("Lines").toString()).toString();

            allViewPoints.add(myJson);
            /*String objId = obj.get("ObjectId").toString();
            System.out.println(objId);
            Integer circles =  (int) (double) (Double) obj.get("Circles");
            Integer lines = (int) (double) (Double) obj.get("Lines");
            Pair<Integer, Integer> p = new Pair(circles,lines);
            allViewPoints.put(objId,p);*/
        }
        this.disconnect();
        return gson.toJson(allViewPoints);
    }



    public String getObjIDByViewPointID(String IDsList){
        this.Connect();
        List<String> vpIDs = gson.fromJson(IDsList, List.class);
        List<String> ObjIDs = new LinkedList<>();
        for (String vpID : vpIDs) {
            System.out.println("+++");
            System.out.println(vpID);
            BasicDBObject searchQuery = new BasicDBObject().append("ViewPointID1", vpID);
            DBCursor cursor = Objects.find(searchQuery);
            if (cursor.hasNext()) {
                while (cursor.hasNext()) {
                    DBObject obj = cursor.next();
                    String ObjID = obj.get("ObjectId").toString();
                    ObjIDs.add(ObjID);
                    //System.out.println(objId);
                }
            }
            else{
                searchQuery = new BasicDBObject().append("ViewPointID2", vpID);
                cursor = Objects.find(searchQuery);
                if (cursor.hasNext()) {
                    while (cursor.hasNext()) {
                        DBObject obj = cursor.next();
                        String ObjID = obj.get("ObjectId").toString();
                        ObjIDs.add(ObjID);
                    }
                }
            }
        }
        this.disconnect();
        return gson.toJson(ObjIDs);
    }

    public String getAllIDs(){
        this.Connect();
        List<String> allIDs = new LinkedList<>();
        DBCursor cursor = Objects.find();
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            String objId = obj.get("ObjectId").toString();
            allIDs.add(objId);
        }
        this.disconnect();
        return gson.toJson(allIDs);
    }

    public String get3DbyIDs(String IDs){
        this.Connect();
        List<String> IDsList = gson.fromJson(IDs, List.class);
        List<String> all3D = new LinkedList<>();
        for (String objId : IDsList) {
            System.out.println("+++");
            System.out.println(objId);
            BasicDBObject searchQuery = new BasicDBObject().append("ObjectId", objId);
            DBCursor cursor = Objects.find(searchQuery);
            if (cursor.hasNext()) {
                while (cursor.hasNext()) {
                    DBObject obj = cursor.next();
                    String file = obj.get("3D").toString();
                    all3D.add(file);
                    //System.out.println(objId);
                }
            }
        }
        this.disconnect();
        return gson.toJson(all3D);
    }

    public String getXML(String ID){
        this.Connect();
        String file = null;
        BasicDBObject searchQuery = new BasicDBObject().append("ObjectId", ID);
        DBCursor cursor = Objects.find(searchQuery);
        if (cursor.hasNext()) {
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                file = obj.get("XML").toString();
            }
        }
        this.disconnect();
        return file;
    }

    public boolean InsertObject(String strDoc){
        this.Connect();
        //System.out.println(strDoc);
        BasicDBObject[] documentArr = gson.fromJson(strDoc, BasicDBObject[].class);
        ViewPoints.insert(documentArr[0]);
        ViewPoints.insert(documentArr[1]);
        Objects.insert(documentArr[2]);
        this.disconnect();
        return true;
    }
}
