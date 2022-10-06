import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class GraphMatrix implements GraphInterface {
    boolean[][] adjacencyMatrix;
    int nbVertices;

    public GraphMatrix(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();
        nbVertices = Integer.parseInt(line);
        adjacencyMatrix = new boolean[nbVertices][nbVertices];
        for (boolean[] bool: adjacencyMatrix)
            Arrays.fill(bool, false);

        line = br.readLine();
        String[] words;
        while (!Objects.equals(line, "") && line != null) {
            words = line.split(" ");
            adjacencyMatrix[Integer.parseInt(words[0])][Integer.parseInt(words[1])] = true;
            adjacencyMatrix[Integer.parseInt(words[1])][Integer.parseInt(words[0])] = true;
            line = br.readLine();
        }
    }

    public boolean get(int i, int j) {
        return adjacencyMatrix[i][j];
    }

    public LinkedList<Integer> getNeighbor(int i) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int j = 0; j < adjacencyMatrix.length; j++) {
            if (adjacencyMatrix[i][j]){
                list.add(i);
            }
        }
        return list;
    }

    public LinkedList<Integer> getNotNeighbor(int i) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int j = 0; j < adjacencyMatrix.length; j++) {
            if (!adjacencyMatrix[i][j] && i!=j){
                list.add(j);
            }
        }
        return list;
    }

    public int getNbVertices() {
        return nbVertices;
    }
}
