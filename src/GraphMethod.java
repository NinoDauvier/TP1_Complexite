import java.util.List;
import java.util.ListIterator;
import java.util.*;

public class GraphMethod {

    public static boolean isVoidZone(GraphInterface graph, LinkedList<Integer> list){

        for(ListIterator<Integer> outer = list.listIterator(); outer.hasNext() ; ) {
            int i = outer.next();

            for (ListIterator<Integer> inner = list.listIterator(outer.nextIndex()); inner.hasNext(); ) {
                if (graph.get(i, inner.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> voidZoneMaximal(GraphInterface graph){
        LinkedList<Integer> list = new LinkedList<>();
        boolean toAdd;
        for (int i = 0; i < graph.getNbVertices(); i++) {
            toAdd = true;
            for (int j: list) {
                if (graph.get(i, j)){
                    toAdd = false;
                }
            }
            if(toAdd){
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> voidZoneMaximum(GraphInterface graph){
        LinkedList<Integer> candidate = new LinkedList<>();
        for (int i = 0; i < graph.getNbVertices(); i++) {
            candidate.add(i);
        }
        return maxRecursive(new LinkedList<>(), candidate, new LinkedList<>(), graph, 0);
    }

    private static LinkedList<Integer> maxRecursive(LinkedList<Integer> selected,LinkedList<Integer> candidate,LinkedList<Integer> treated, GraphInterface graph, int currentmax){
        if (candidate.isEmpty()){
            return selected;
        }
        if (selected.size() + candidate.size() <= currentmax){
            return new LinkedList<>();
        }

        LinkedList<Integer> maxZone = new LinkedList<>();
        int i;
        while (!candidate.isEmpty()){
            i = candidate.remove();
            LinkedList<Integer> potentialVerticies = graph.getNotNeighbor(i);
            LinkedList<Integer> newCandidate = intersection(candidate, potentialVerticies);
            LinkedList<Integer> newTreated = intersection(treated, potentialVerticies);
            LinkedList<Integer> newSelected = new LinkedList<>(selected);
            newSelected.add(i);
            treated.add(i);

            LinkedList<Integer> newZone = maxRecursive(newSelected, newCandidate, newTreated, graph, currentmax);
            if(newZone.size() > maxZone.size()){
                currentmax = newZone.size();
                maxZone = newZone;
            }
        }
        return maxZone;
    }

    private static LinkedList<Integer> intersection(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        ListIterator<Integer> it1 = l1.listIterator();
        ListIterator<Integer> it2 = l2.listIterator();
        LinkedList<Integer> intersect = new LinkedList<>();
        int n1;
        int n2;

        while(it1.hasNext() && it2.hasNext()) {
            n1 = it1.next();
            n2 = it2.next();
            if (n1 == n2) {
                intersect.add(n1);
            } else if (n1 < n2) {
                it2.previous();
            } else {
                it1.previous();
            }

        }
        return intersect;
    }

    public static List<Integer> decentVoidZone(GraphInterface graph){
        VertexDegree[] vertices = new VertexDegree[graph.getNbVertices()];
        for (int i = 0; i < graph.getNbVertices(); i++) {
            vertices[i] = new VertexDegree(i, graph.getNeighbor(i).size());
        }
        Arrays.sort(vertices);

        LinkedList<Integer> list = new LinkedList<>();
        boolean toAdd;
        for (int i = 0; i < graph.getNbVertices(); i++) {
            toAdd = true;
            for (int j: list) {
                if (graph.get(vertices[i].getVertex(), j)){
                    toAdd = false;
                }
            }
            if(toAdd){
                list.add(vertices[i].getVertex());
            }
        }
        Collections.sort(list);
        return list;

    }
}
