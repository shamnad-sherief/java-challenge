package excercise.matrix;

//You are given a matrix of dimension n*n. All the cells are initially, zero.
// You are given Q queries, which contains 4 integers a b c d where (a,b) is the TOP LEFT cell and
// (c,d) is the Bottom Right cell of a submatrix. Now, all the cells of this submatrix have to be
// incremented by one. After all the Q queries have been performed. Your task is to find the final resulting Matrix.
//   Note : Zero-Based Indexing is used for cells of the matrix.

// source:- https://practice.geeksforgeeks.org/problems/queries-on-a-matrix0443/1


public class QueriesOnMatrix {

    public static void main(String[] args) {


        int[][] Queries = {{4 ,0 ,5 ,3},
                {0, 0, 3, 4},
                {1, 2, 1, 2},
                {1 ,1, 2, 3},
                {0 ,0 ,3 ,1},
                {1, 0, 2, 4}};
        int n = Queries.length;

        QueriesOnMatrixSolution s1 = new QueriesOnMatrixSolution();
        int[][] ans=s1.solveQueries(n,Queries);
        for(int i=0;i< ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

    }

}


class QueriesOnMatrixSolution {
    public int[][] solveQueries(int n, int[][] Queries) {
        // Code here
        int[][] arr=new int[n][n];

        for(int[] q: Queries){

            for(int j=q[0];j<=q[2];j++){

                for(int k=q[1];k<=q[3];k++){

                    arr[j][k]++;

                }

            }

        }

        return arr;
    }
}