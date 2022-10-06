import java.io.IOException;

public class MainGraph {

    public static void main(String[] args) throws IOException {
        GraphInterface graph = new AdjacencyGraph("C:\\Users\\DELL\\Desktop\\TD programation\\TP1_Complexité\\src\\GraphAdjacencyExample");
//        System.out.println(GraphMethod.isVoidZone(graph, new ArrayList<>(Arrays.asList(0, 1, 4))));
//        System.out.println(GraphMethod.isVoidZone(graph, new ArrayList<>(Arrays.asList(0, 1, 3))));
//        System.out.println(GraphMethod.voidZoneMaximal(graph));
//        System.out.println(GraphMethod.voidZoneMaximum(graph));
        System.out.println(GraphMethod.decentVoidZone(graph));

    }
}
