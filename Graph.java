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

    public Graph deleteVertex(String v1) {
        int x = vertexList.indexOf(v1);
        int nbVertex = vertexList.size();
        if(!vertexList.contains(v1)){
            System.out.println("This vertex does not exist!");
        }
        for(int i = x;i<nbVertex-1;++i){
            edges[i] = edges[i+1];
        }
        for(int i = x;i<nbVertex-1;++i){
            for(int j = 0;j<nbVertex;++j){
                edges[i][j] = edges[i+1][j];
            }
        }
        for(int i = 0;i<nbVertex;++i){
            for(int j = x;j<nbVertex-1;++j){
                edges[i][j] = edges[i][j+1];
            }
        }
        --nbVertex;
        vertexList.remove(v1);
        Graph g1 = new Graph(nbVertex);
        g1.vertexList = vertexList;
        for(int i = 0;i<nbVertex;i++){
            for(int j= 0 ;j<nbVertex;j++){
                g1.edges[i][j] = edges[i][j];
            }
        }
        return g1;
    }
    public void showGraph(){
        for(int[] link: edges){
            System.err.println(Arrays.toString(link));
        }
    }
}
    public void showGraph(){
        for(int[] link: edges){
            System.err.println(Arrays.toString(link));
        }
    }

}
