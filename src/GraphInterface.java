import java.util.LinkedList;

public interface GraphInterface {
    boolean get(int i, int j);
    LinkedList<Integer> getNeighbor(int i);
    LinkedList<Integer> getNotNeighbor(int i);
    int getNbVertices();
}
