// Given a Matrix size N*N and an integer K. Initially, the matrix contains only 0. You are given K tasks and for each task, you are given two
// coordinates (r,c) [1 based index]. Where coordinates (r,c) denotes rth row and cth column of the given matrix.
// You have to perform each task sequentially in the given order. For each task, You have to put 1 in all rth row cells and all cth columns cells.
// After each task, You have to calculate the number of 0 present in the matrix and return it.

// source:- https://practice.geeksforgeeks.org/problems/90a81c305b1fe939b9230a67824749ceaa493eab/1

package excercise.matrix;

public class NoOfFreeCells {
    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        int[][] arr = {{2, 2},
                {2, 3},
                {3, 2}};

        NoOfFreeCellsSolution obj = new NoOfFreeCellsSolution();

        long[] res = obj.countZero(n,k,arr);

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]+" ");
        }

    }
}


class NoOfFreeCellsSolution {
    long[] countZero(int N, int K, int[][] arr){
        // Initialize the result array to store the number of free cells at each step
        long[] result = new long[K];

        // Initialize arrays to keep track of visited rows and columns
        boolean[] visitedRows = new boolean[N+1];
        boolean[] visitedColumns = new boolean[N+1];

        // Initialize the number of non-visited rows and columns
        long numberOfNonVisitedRow = N;
        long numberOfNonVisitedColumn = N;

        // Loop through each occupied cell
        for(int i = 0; i < K; i++){
            // If the current row is not visited, mark it as visited and decrement the number of non-visited rows
            if(!visitedRows[arr[i][0]]){
                visitedRows[arr[i][0]] = true;
                numberOfNonVisitedRow--;
            }
            // If the current column is not visited, mark it as visited and decrement the number of non-visited columns
            if(!visitedColumns[arr[i][1]]){
                visitedColumns[arr[i][1]] = true;
                numberOfNonVisitedColumn--;
            }
            // Calculate the number of free cells and store it in the result array
            result[i] = numberOfNonVisitedRow * numberOfNonVisitedColumn;
        }
        // Return the result array
        return result;
    }
}
