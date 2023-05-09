/*
Matthias Kim
HW8
4/21/23
 */

package HW8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public int n; //number of vertice
    public int[][] A; //the adjacency matrix
    private final int WHITE = 2;
    private final int GRAY = 3;
    private final int BLACK = 4;
    public Graph () {
        n = 0;
        A = null;
    }
    public Graph (int _n, int[][] _A) {
        this.n = _n;
        this.A = _A;
    }
    /*
    * Input: s denotes the index of the source node
    * Output: the array dist, where dist[i] is the distance between the i-th
    node to s
    */
    public int[] bfs (int s) {
        //initialize the arrays that hold the distances and colors
        int [] distances = new int[n];
        int [] colors = new int[n];

        Arrays.fill(distances, -1); //preset all distances to -1
        Arrays.fill(colors, WHITE); //preset all colors to white

        //create a queue
        Queue<Integer> queue = new LinkedList<Integer>();

        distances[s] = 0; //you know the distance from s to s is 0
        colors[s] = GRAY; //s is gray
        queue.offer(s); //insert to queue

        while(!queue.isEmpty()){
            int u = queue.poll(); //remove head
            for (int i = 0; i < n; i++) {
                if (A[u][i] == 1 && colors[i] == WHITE){ //if i is a neighbor of u and i is undiscovered
                    distances[i] = distances[u] + 1;
                    colors[i] = GRAY;
                    queue.offer(i);
                }
            }
            colors[u] = BLACK;
        }
        return distances; //return
    }
    public void print_array (int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(i + ": " + array[i]);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        int n = 8;
        int[][] A =
                {{0, 1, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 1, 1, 0},
                        {0, 0, 1, 0, 0, 0, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0, 1, 0},
                        {0, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 1, 0}};
        Graph g = new Graph(n, A);
        g.print_array(g.bfs(1));
    }
}