package DBManager;

import DAL.DAL_Interface;
import DAL.DAL_InterfaceImpl;
import Graph.*;
import Graph.Pair;
import Shapes.SVGParser;
import Shapes.Shape;

import java.util.List;
import java.util.Set;

public class DBManagerImple implements DBManager {
    private static DBManager single_instance = null;
    DAL_Interface dal = DAL_InterfaceImpl.getInstance();

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

    public boolean SaveToDB(String xml){
        Pair<List<Shape>,List<Shape>> shapes = SVGParser.fileToShapes(xml);
        List<Shape> s1 = shapes.getFirst();
        List<Shape> s2 = shapes.getSecond();
        Graph g1 = CheckingAlgorithm.createGraph(s1);
        Graph g2 = CheckingAlgorithm.createGraph(s2);
        Pair<Set<List<Edge>>,Set<List<Edge>>> p = CheckingAlgorithm.checkAlgorithem(g1, g2);
        Set<List<Edge>> m1 = p.getFirst();
        Set<List<Edge>> m2 = p.getSecond();
        String D3 = "blablabla";
        String email = "adarne@post.bgu.ac.il";
        dal.Connect();
        //dal.InsertViewPoints(D3, xml, s1, s2, g1, g2, m1, m2, email);

        return true;
    }
}
