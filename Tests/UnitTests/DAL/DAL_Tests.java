package DAL;

import DBManager.*;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import org.junit.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DAL_Tests {
    private DBManager blm = new DBManagerImpl();
    private static DAL_Interface dal = new DAL_InterfaceImpl();
    private Gson gson = new Gson();

    @BeforeClass
    public static void InsertObjectTest() {
        BasicDBObject[] document = new BasicDBObject[4];
        document[0] = new BasicDBObject();
        document[0].put("ObjectId", "VPTest1");
        document[0].put("Circles", 3);
        document[0].put("Lines", 3);

        document[1] = new BasicDBObject();
        document[1].put("ObjectId", "VPTest2");
        document[1].put("Circles", 3);
        document[1].put("Lines", 3);

        document[2] = new BasicDBObject();
        document[2].put("ObjectId", "ObjectTest");
        document[2].put("SVG", "svg");
        document[2].put("XML", "xml");
        document[2].put("3D", "3D");
        document[2].put("ViewPointID1", "VPTest1");
        document[2].put("ViewPointID2", "VPTest2");
        document[2].put("Email", "email");

        boolean ans = dal.InsertObject(document);
        assertTrue(ans);
    }

    @Test
    public void getMyObjectsTest() {
        String ans = dal.getMyObjects("email");
        List<String> allIDs = gson.fromJson(ans,List.class);
        assertEquals("ObjectTest", allIDs.get(0));
    }

    @Test
    public void getAllIDsTest() {
        String ans = blm.getAllIDs();
        List<String> allIDs = gson.fromJson(ans,List.class);
        assertEquals(dal.CountObject(), allIDs.size());
    }

    @Test
    public void get3DbyIDsTest() {
        List<String> allIDs = new LinkedList<>();
        allIDs.add("ObjectTest");
        String ids = gson.toJson(allIDs);
        String ans = blm.get3DbyIDs(ids);
        List<String> files = gson.fromJson(ans,List.class);
        assertEquals("3D", files.get(0));
    }

    @Test
    public void getXMLTest() {
        String xml = blm.getXML("ObjectTest");
        assertEquals("xml", xml);
    }

    @Test
    public void getAllViewPointsTest() {
        String ans = blm.getAllViewPoints();
        List<String> allIDs = gson.fromJson(ans,List.class);
        assertEquals(dal.CountVPs(), allIDs.size());
    }

    @Test
    public void getObjIDByViewPointID1Test() {
        List<String> allIDs = new LinkedList<>();
        allIDs.add("VPTest1");
        String ids = gson.toJson(allIDs);
        String ans = blm.getObjIDByViewPointID(ids);
        List<String> files = gson.fromJson(ans,List.class);
        assertEquals("ObjectTest", files.get(0));
    }

    @Test
    public void getObjIDByViewPointID2Test() {
        List<String> allIDs = new LinkedList<>();
        allIDs.add("VPTest2");
        String ids = gson.toJson(allIDs);
        String ans = blm.getObjIDByViewPointID(ids);
        List<String> files = gson.fromJson(ans,List.class);
        assertEquals("ObjectTest", files.get(0));
    }

    @AfterClass
    public static void DeleteTest() {
        boolean ans = dal.DeleteObject("ObjectTest");
        assertTrue(ans);
    }

}