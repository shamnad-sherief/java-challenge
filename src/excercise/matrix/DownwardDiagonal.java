// Give a N * N square matrix A, return all the elements of its anti-diagonals from top to bottom.

// source:- https://practice.geeksforgeeks.org/problems/print-diagonally4331/1

package excercise.matrix;

import java.util.ArrayList;

public class DownwardDiagonal {
    public static void main(String[] args) {
       int  N = 2;
       int[][] A = {{1, 2},
               {3, 4}};

       DownwardDiagonalSolution s1 = new DownwardDiagonalSolution();
        System.out.println(s1.downwardDiagonal(N,A));

    }
}


class DownwardDiagonalSolution{
    static ArrayList<Integer> downwardDiagonal(int N, int A[][])
    {
        ArrayList<Integer> ans=new ArrayList<>();

        // printing elements above and on
        // second diagonal
        for (int k = 0; k < N; k++) {

            // traversing downwards starting
            // from first row
            int row = 0, col = k;
            while (col >= 0) {
                ans.add(A[row][col]);
                row++;
                col--;
            }
        }

        // printing elements below second
        // diagonal
        for (int j = 1; j < N; j++) {

            // traversing downwards starting
            // from last column
            int col = N - 1, row = j;
            while (row < N) {
                ans.add(A[row][col]);
                row++;
                col--;
            }
        }

        return ans;

    }
}
