/*
Matthias Kim
HW9
5/8/23
 */

package HW9;
import java.util.*;

public class Graph2 {
    public int n; //number of vertice
    public int[][] A; //the adjacency matrix

    public static int max = Integer.MAX_VALUE;

    public Graph2() {
        n = 0;
        A = null;
    }

    public Graph2(int _n, int[][] _A) {
        this.n = _n;
        this.A = _A;
    }

    public int prim(int r) {
        //initialize arrays
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] inTree = new boolean[n];

        Arrays.fill(key, max);
        PriorityQueue<PrimNode> pq = new PriorityQueue<>();

        key[r] = 0;
        pq.offer(new PrimNode(r, key[r]));

        while (!pq.isEmpty()) {
            //find the vertex with the minimum key val
            PrimNode node = pq.poll();
            int u = node.id;
            inTree[u] = true;

            for (int i = 0; i < n; i++) { //update key vals and parent pointers of those not in MST
                if (A[u][i] != 0 && !inTree[i] && A[u][i] < key[i]) {
                    parent[i] = u;
                    key[i] = A[u][i];
                    pq.offer(new PrimNode(i, key[i]));
                }
            }
        }
        //sum all the key values
        int insideCount = 0;
        for (int i = 0; i < n; i++) {
            insideCount += key[i];
        }
        return insideCount;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        int n = 9;
        int A[][] = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Graph2 g = new Graph2(n, A);
        System.out.println(g.prim(0));
    }
}

class PrimNode implements Comparable<PrimNode> {
    public int id;
    public int key;

    public PrimNode(int id, int key) {
        this.id = id;
        this.key = key;
    }

    public int compareTo(PrimNode o) {
        return (this.key - o.key);
    }
}

