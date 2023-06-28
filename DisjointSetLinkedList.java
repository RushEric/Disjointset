
package csci323Project;

import java.util.*;

public class DisjointSetLinkedList {
    private final Map<Integer, Node> linkedlist = new HashMap<>();

    private class Node {
        int value; 
        Node next; 
        Node representative; 
        Node head;
        Node tail;
        int size; 

        Node(int value){
            this.value = value;
            this.next = null;
            this.representative = this;
            this.head = this;
            this.tail = this;
            this.size = 1;
        }
    }
    
    public void makeSet(int value) {
        Node newSet = new Node(value);
        linkedlist.put(value, newSet);    
    }
    
    public void union(int set1, int set2) {
        Node node1 = findNode(set1);
        Node node2 = findNode(set2); 
        
        if (node1 == node2)
            return;
        
        if (node1.size >= node2.size) {
            node2.representative = node1;
            node1.size += node2.size;
            node1.tail.next = node2.head;
            node1.tail = node2.tail;
        } else {
            node1.representative = node2;
            node2.size += node1.size;
            node2.tail.next = node1.head;
            node2.tail = node1.tail;
        }
    }
    
    public int findSet(int value) {
        Node node = linkedlist.get(value);
        
        if (node != null && node.representative != null)
            return node.representative.value;
        
        return -1;
    }
    
    private Node findNode(int value) {
        Node node = linkedlist.get(value);
        
        if (node != null)
            return node.representative;
        
        return null;
    }
}
