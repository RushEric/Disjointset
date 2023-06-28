package csci323Project;

public interface DisjointSet<E> {
    
    void makeSet(E set);
    void union(E set1, E set2);
    E findSet(E set);
}
