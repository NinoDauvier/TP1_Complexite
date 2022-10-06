import java.util.ArrayList;

public interface GraphInterface {
    boolean get(int i, int j);
    ArrayList<Integer> getNeighbor(int i);
    ArrayList<Integer> getNotNeighbor(int i);
    int getNbVertices();
}
