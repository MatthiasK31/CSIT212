package FinalProject;

class MatthiasKimFinalProject {
    public static void main(String[] args) {
        final int max = Integer.MAX_VALUE / 2;
        int n = 5;
        //int A [][] = {{0,3,max,5}, {2,0,max,4}, {max,1,0,max}, {max,max,2,0}};

        int A[][] = {
                {0, 3, 8, max, -4},
                {max, 0, max, 1, 7},
                {max, 4, 0, max, max},
                {2, max, -5, 0, max},
                {max, max, max, 6, 0}
        };


        FloydWarshall g = new FloydWarshall(n, A);
        int[][] Test = g.fw();
        for (int i = 0; i < Test.length; i++) {
            for (int j = 0; j < Test[i].length; j++) {
                System.out.print(Test[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class FloydWarshall {
    int n;
    int[][] A;

    FloydWarshall(int _n, int[][] _A) {
        this.n = _n;
        this.A = _A;
    }

    public int[][] fw() {
        int n = A.length; // number of vertices
        int max = Integer.MAX_VALUE;
        int array[][][] = new int[n + 1][A.length][A[0].length];
        for (int i = 1; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                for (int k = 0; k < array[i][j].length; k++)
                    array[i][j][k] = max;
        array[0] = A;
        for (int k = 1; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    // if either of the weights is infinity,
                    // distance from i to j is automatically returned
                    array[k][i][j] = Math.min(array[k - 1][i][j], array[k - 1][i][k] + array[k - 1][k][j]);
                    //System.out.println(array[k][i][j]);
                }
        return array[n - 1];
    }

}
