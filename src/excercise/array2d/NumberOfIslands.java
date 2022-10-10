//You are given a n,m which means the row and column of the 2D matrix and an array of  size k denoting
// the number of operations. Matrix elements is 0 if there is water or 1 if there is land.
// Originally,the 2D matrix is all 0 which means there is no land in the matrix.
// The array has k operator and each operator has two integer A[i][0], A[i][1] means that you can change the
// cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island are there in the matrix after each operator.
// You need to return an array of size k.
//  Note : An island means group of 1s such that they share a common side.
//
// source :-https://practice.geeksforgeeks.org/problems/number-of-islands/1

package excercise.array2d;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {
    public static void main(String[] args) {

        int n = 4;
        int m = 5;
        int k = 4;

        int[][] a = {{1,1},{0,1},{3,3},{3,4}};

        NumberOfIslandsSolution s1 = new NumberOfIslandsSolution();

        System.out.println(s1.numOfIslands(n,m,a));

    }

}

class NumberOfIslandsSolution {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int [][]  arr = new int[rows+1][cols+1];
        int k=1;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i < operators.length; i++)
        {
            int cnt=0;
            arr[operators[i][0]][operators[i][1]]=k;
            for(int p = 0; p < rows; p++)
            {
                for(int q = 0; q < cols ; q++)
                {
                    if(arr[p][q] == k)
                    {
                        Helper(arr, p ,q, rows, cols,k);
                        cnt++;
                    }
                }
            }
            ans.add(cnt);
            k++;
        }
        return ans;
    }
    public void Helper(int [][] arr, int i, int j, int n, int m, int k)
    {
        if(i>=0 && j>=0 && i < n && j < m && arr[i][j]==k)
        {
            arr[i][j]+=1;
            Helper(arr, i, j+1,n,m, k);
            Helper(arr, i+1, j, n, m, k);
            Helper(arr, i-1, j, n,m,k);
            Helper(arr, i, j-1, n, m, k);
        }
    }

}