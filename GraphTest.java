import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphTest {

    public boolean testZoneVide(Graph g1,Graph g2){

        return true;
    }

//    public Graph maximaleZV(Graph graph){
//
//    }
//
//    public Graph maximumZVC(Graph graph){
//
//    }
//
//    public Graph maximumZVI(Graph graph){
//
//    }

    public static Graph inputGraph() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int n = scanner.nextInt();

        ArrayList<String> vertices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter a vertex: " + i);
            vertices.add(scanner.next());
        }

        Graph graph = new Graph(n);
        for (String vertices1 : vertices) {
            graph.insertVertex(vertices1);
        }

        while (true) {
            System.out.println("Enter two vertices with one edge or 'Q' to quit");
            String v1 = scanner.next();
            if(!vertices.contains(v1)){
                System.out.println("Input error, game over");
                break;
            }
            String v2 = scanner.next();
            if (vertices.contains(v1) && vertices.contains(v2)) {
                graph.insertEdge(vertices.indexOf(v1), vertices.indexOf(v2), 1);
            }
        }
        return graph;
    }
    public static void main(String[] args) {

        Graph g1 = inputGraph();;

        g1.showGraph();
    }
}
