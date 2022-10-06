public class VertexDegree implements Comparable<VertexDegree>{
    int vertex;
    int degree;

    public VertexDegree(int vertex, int degree) {
        this.vertex = vertex;
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public int getVertex() {
        return vertex;
    }

    @Override
    public int compareTo(VertexDegree other) {
        return Double.compare(this.degree, other.degree);
    }
}
