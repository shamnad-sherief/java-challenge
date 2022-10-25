//The task is to count all the possible paths from top left to bottom right of a m X n matrix with the constraints
// that from each cell you can either move only to right or down.

// source:- https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right3011/1

package excercise.matrix;

public class PathCount {
    public static void main(String[] args) {

        int m = 2;
        int n = 4;

        PathCountSolution s1 = new PathCountSolution();
        System.out.println(s1.numberOfPaths(m,n));
    }

}


class PathCountSolution {
    long numberOfPaths(int m, int n) {

        long count[][]=new long[m][n];


        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        for (int j = 0; j < n; j++)
            count[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                count[i][j] = (count[i-1][j]%1000000007 + count[i][j-1]%1000000007)%1000000007;

        }
        return count[m-1][n-1]%1000000007;
    }


}

