
package csci323Project;

import java.util.Random;

public class tester {
    public static void main(String[] args) {
        int[] n_values = {10, 100, 1000, 10000, 1000000, 10000000};
        Random rand = new Random();

        for (int n : n_values) {
            DisjointSetForest<Integer> dsForest = new DisjointSetForest<>();
            long startTimeForest = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                dsForest.makeSet(i);
            }

            for (int i = 0; i < n; i++) {
                int a = rand.nextInt(n);
                int b = rand.nextInt(n);

                if (!dsForest.findSet(a).equals(dsForest.findSet(b))) {
                    dsForest.union(a, b);
                }
            }

            long endTimeForest = System.currentTimeMillis();
            System.out.print("Time for DisjointSetForest with n = " + n + ": " + (endTimeForest - startTimeForest) + "ms");

            DisjointSetLinkedList dsLinkedList = new DisjointSetLinkedList();
            long startTimeLinkedList = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                dsLinkedList.makeSet(i);
            }

            for (int i = 0; i < n; i++) {
                int a = rand.nextInt(n);
                int b = rand.nextInt(n);

                if (dsLinkedList.findSet(a) != dsLinkedList.findSet(b)) {
                    dsLinkedList.union(a, b);
                }
            }

            long endTimeLinkedList = System.currentTimeMillis();
            System.out.println("         Time for DisjointSetLinkedList with n = " + n + ": " + (endTimeLinkedList - startTimeLinkedList) + "ms");
        }
    }
}
