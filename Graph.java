import java.text.NumberFormat.Style;
import java.util.ArrayList;

class Graph {
    class Edge {
        int src,dest;
    }
    int vertices, edges;
    Edge[] edge;

     Graph(int vertices, int edges)
    {
        this.vertices = vertices;
        this.edges = edges;
        edge = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            edge[i] = new Edge();
        }
    }
    public static void main(String[] args)
    {
        int i, j;
        int numberOfVertices = 6;
        int numberOfEdges = 7;
        int[][] adjacency_matrix
            = new int[numberOfVertices][numberOfVertices];
        
        ArrayList Sous_Ensemble= new ArrayList<>();
        Graph g
            = new Graph(numberOfVertices, numberOfEdges);
  
        g.edge[0].src = 1;
        g.edge[0].dest = 2;
  
        g.edge[1].src = 1;
        g.edge[1].dest = 5;
  
        g.edge[2].src = 2;
        g.edge[2].dest = 3;
  
        g.edge[3].src = 2;
        g.edge[3].dest = 5;
  
        g.edge[4].src = 3;
        g.edge[4].dest = 4;
  
        g.edge[5].src = 4;
        g.edge[5].dest = 6;

        g.edge[6].src = 5;
        g.edge[6].dest = 4;
  
        // Adjacency Matrix
        for (i = 0; i < numberOfEdges; i++) {
            for (j = 0; j < numberOfEdges; j++) {
                adjacency_matrix[g.edge[i].src-1][g.edge[i].dest-1]= 1;
                adjacency_matrix[g.edge[i].dest-1][g.edge[i].src-1]= 1;
            }
        }
        System.out.println("Adjacency matrix : ");
       
        for (i = 0; i <adjacency_matrix.length; i++) {
            for (j = 0; j <adjacency_matrix.length;j++) {
                
                System.out.print(adjacency_matrix[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("\n");
       
        Sous_Ensemble.add(1);
        Sous_Ensemble.add(2);
        Sous_Ensemble.add(3);
        System.out.println("Sous Ensemble Adjacency matrix : ");
        for(i=0;i<Sous_Ensemble.size();i++)
        {
            System.out.print(Sous_Ensemble.get(i)
                                 + " ");
        }
        
        if(ZoneVide(Sous_Ensemble,adjacency_matrix))
        {
            System.out.print("\nCe Sous ensemble est une zone vide de G");
        }
        else{
            System.out.print("\nCe Sous ensemble n'est pas une zone vide de G");
        }
        System.out.println("\n");
        ZoneVideMaximale(adjacency_matrix);
        

    }

    static boolean ZoneVide(ArrayList<Integer> se, int[][] m)
    {

        for(int x: se)
        {
            for(int y:se)
            {
                 if(m[x][y]==1) return false;
            }
           
        }
        return true;
    }
    
//    static void ZoneVideMaximale(int[][] G)
//    {
//        ArrayList res=new ArrayList<Integer>();
//        for(int i=0;i<G.length;i++)
//        {
//            for(int j=0;j<G.length;j++)
//            {
//                if(G[i][j]==0)
//                {
//                    res.add(i,j);
//                System.out.println("["+(i+1)+","+(j+1)+"]");
//                }
//            }
//        }
//
//    }
    
}

