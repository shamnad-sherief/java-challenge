// Given a binary matrix of dimensions  with R rows and C columns. Start from cell(0, 0), moving in the right direction.
// Perform the following operations:
// If the value of matrix[i][j] is 0, then traverse in the same direction and check the next value.
// If the value of matrix[i][j] is 1, then update matrix[i][j] to 0 and change the current direction clockwise.
// ie - up, right, down, or left directions change to right, down, left, and up respectively.
// Find the index of the cell where you will be forced to exit the matrix while performing the given traversal.

// source:- https://practice.geeksforgeeks.org/problems/2e068e2342b9c9f40cfda1ed8e8119542d748fd8/1

package excercise.matrix;

public class LastCellMatrix {
    public static void main(String[] args) {

        int[][] arr = {{0,1},
            {1,0}};
        int m = 2;
        int n = 2;

        LastCellMatrixSolution obj = new LastCellMatrixSolution();

        int[] p = obj.endPoints(arr,m,n);

        System.out.println(p[0]+ " " + p[1]);

    }
}

class LastCellMatrixSolution {

        static int [] endPoints(int [][]arr, int m, int n){
            int[] result = new int[2];
            int x = 0, y = 0;
            int direction = 0; // 0: right, 1: down, 2: left, 3: up
            while (x >= 0 && x < m && y >= 0 && y < n) {
                int oldX = x;
                int oldY = y;
                if (arr[x][y] == 1) {
                    arr[x][y] = 0;
                    direction = (direction + 1) % 4;
                }
                if (direction == 0) {
                    y++;
                } else if (direction == 1) {
                    x++;
                } else if (direction == 2) {
                    y--;
                } else {
                    x--;
                }
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    result[0] = oldX;
                    result[1] = oldY;
                    return result;
                }
            }
            result[0] = x;
            result[1] = y;
            return result;
        }

}
