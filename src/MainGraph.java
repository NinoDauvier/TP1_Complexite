import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class MainGraph {

    public static void main(String[] args) throws IOException {
        GraphInterface graph = new GraphMatrix("C:\\Users\\DELL\\Desktop\\TD programation\\TP1_Complexité\\src\\GraphAdjacencyExample");
        System.out.println(GraphMethod.isVoidZone(graph, new LinkedList<>(Arrays.asList(0, 1, 4))));
        System.out.println(GraphMethod.isVoidZone(graph, new LinkedList<>(Arrays.asList(0, 1, 3))));
        System.out.println(GraphMethod.voidZoneMaximal(graph));
        System.out.println(GraphMethod.voidZoneMaximum(graph));
        System.out.println(GraphMethod.decentVoidZone(graph));

        GraphInterface graphList = new GraphList("C:\\Users\\DELL\\Desktop\\TD programation\\TP1_Complexité\\src\\GraphAdjacencyExample");
        System.out.println(GraphMethod.isVoidZone(graph, new LinkedList<>(Arrays.asList(0, 1, 4))));
        System.out.println(GraphMethod.isVoidZone(graph, new LinkedList<>(Arrays.asList(0, 1, 3))));
        System.out.println(GraphMethod.voidZoneMaximal(graph));
        System.out.println(GraphMethod.voidZoneMaximum(graph));
        System.out.println(GraphMethod.decentVoidZone(graph));
    }
}
