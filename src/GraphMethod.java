import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.*;

public class GraphMethod {

    public static boolean isVoidZone(GraphInterface graph, ArrayList<Integer> list){

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
        ArrayList<Integer> list = new ArrayList<>();
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
        List<Integer> candidate = new ArrayList<>();
        for (int i = 0; i < graph.getNbVertices(); i++) {
            candidate.add(i);
        }
        return maxRecursive(new ArrayList<>(), candidate, new ArrayList<>(), graph);
    }

    private static List<Integer> maxRecursive(List<Integer> selected,List<Integer> candidate,List<Integer> treated, GraphInterface graph){
        if (candidate.isEmpty() && treated.isEmpty()){
            return selected;
        }

        List<Integer> maxZone = new ArrayList<>();
//        System.out.println(selected+""+ candidate+""+ treated);
        for (int i: candidate){
            List<Integer> potentialVerticies = graph.getNotNeighbor(i);
            List<Integer> newCandidate = intersection(candidate, potentialVerticies);
            List<Integer> newTreated = intersection(treated, potentialVerticies);
            List<Integer> newSelected = new ArrayList<>(selected);
            newSelected.add(i);
            System.out.println(selected+""+i);


            List<Integer> newZone = maxRecursive(newSelected, newCandidate, newTreated, graph);
            if(newZone.size() > maxZone.size()){
                maxZone = newZone;
            }
            System.out.println(newZone);
        }
        return maxZone;
    }

    private static List<Integer> intersection(List<Integer> l1, List<Integer> l2) {
        ListIterator<Integer> it1 = l1.listIterator();
        ListIterator<Integer> it2 = l2.listIterator();
        List<Integer> intersect = new ArrayList<>();
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
//        System.out.println(l1+""+ l2+""+ intersect);
        return intersect;
    }

    public static List<Integer> decentVoidZone(GraphInterface graph){
        VertexDegree[] vertices = new VertexDegree[graph.getNbVertices()];
        for (int i = 0; i < graph.getNbVertices(); i++) {
            vertices[i] = new VertexDegree(i, graph.getNeighbor(i).size());
        }
        Arrays.sort(vertices);

        ArrayList<Integer> list = new ArrayList<>();
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
