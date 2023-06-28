
package csci323Project;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetForest<E> implements DisjointSet<E> {
    
    private final Map<E, Node> forest = new HashMap<>();

    private class Node {
        E data;
        Node parent;
        int rank;

        Node(E data) {
            this.data = data;
            this.parent = this;
            this.rank = 0;
        }
    }

    @Override
    public void makeSet(E set) {
        forest.put(set, new Node(set));
        
    }

    @Override
    public void union(E set1, E set2) {
        Node node1 = forest.get(set1);
        Node node2 = forest.get(set2);
        link(root(node1), root(node2));
        
    }
    
     private void link(Node node1, Node node2) {
            if (node1.rank > node2.rank) {
                node2.parent = node1;
            } else {
                node1.parent = node2;
                if (node1.rank == node2.rank) {
                    node2.rank++;
                }
            }
        }

    @Override
    public E findSet(E set) {
        return root(forest.get(set)).data;
    }
    
    private Node root(Node node) {
        if (node != node.parent) {
            node.parent = root(node.parent);
        }
        return node.parent;
    }

}

