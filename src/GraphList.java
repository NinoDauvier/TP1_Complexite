import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GraphList  implements GraphInterface {
    LinkedList[] adjacencyList;
    int nbVertices;

    public GraphList(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();
        nbVertices = Integer.parseInt(line);
        adjacencyList = new LinkedList[nbVertices];
        for (int i = 0; i < nbVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        line = br.readLine();
        String[] words;
        while (!Objects.equals(line, "") && line != null) {
            words = line.split(" ");
            adjacencyList[Integer.parseInt(words[0])].add(Integer.parseInt(words[1]));
            adjacencyList[Integer.parseInt(words[1])].add(Integer.parseInt(words[0]));
            line = br.readLine();
        }
    }

    public boolean get(int i, int j) {
        return adjacencyList[i].contains(j);
    }

    public LinkedList<Integer> getNeighbor(int i) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int j = 0; j < adjacencyList.length; j++) {
            if (adjacencyList[i].contains(j)){
                list.add(i);
            }
        }
        return list;
    }

    public LinkedList<Integer> getNotNeighbor(int i) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int j = 0; j < adjacencyList.length; j++) {
            if (!adjacencyList[i].contains(j) && i!=j){
                list.add(j);
            }
        }
        return list;
    }

    public int getNbVertices() {
        return nbVertices;
    }
}

