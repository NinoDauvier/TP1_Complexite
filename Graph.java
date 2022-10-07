import java.util.ArrayList;
import java.util.Arrays;

class Graph{
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int nbEdges;
    public Graph(int n){
        vertexList = new ArrayList<>();
        edges = new int[n][n];
        nbEdges = 0;
    }
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        nbEdges++;
    }
    public int getNbVertex(){
        return vertexList.size();
    }
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    public void showGraph(){
        for(int[] link: edges){
            System.err.println(Arrays.toString(link));
        }
    }

}