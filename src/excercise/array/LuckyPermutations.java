// You are given an array arr[ ] of integers having N elements and a non-weighted undirected graph having N nodes and M edges.
// The details of each edge in the graph is given to you in the form of list of list. Your task is to find the number of lucky
// permutations of the given array.

// source:- https://practice.geeksforgeeks.org/problems/e9e2da3de3eb35679ca7e17b752ae877635f1a26/1

package excercise.array;

public class LuckyPermutations {
    public static void main(String[] args) {
        int N = 3;
        int M = 2;
        int[] arr = {1, 2, 3};
        int[][] graph = {{3, 1}, {1, 2}};

        LuckyPermutationsSolution obj = new LuckyPermutationsSolution();

        System.out.println(obj.luckyPermutations(N,M,arr,graph));
    }

}

class LuckyPermutationsSolution {
    long luckyPermutations(int N, int M, int arr[], int[][] graph) {
        // Code here
        int[][] adj = new int[N + 1][N + 1];

        for(int[] e : graph){
            adj[e[0]][e[1]]++;
            adj[e[1]][e[0]]++;
        }

        long[][] dp = new long[N][(1 << N)];

        for(int i=0; i<N; i++){
            dp[i][(1 << i)]++;
        }

        for(int i=1; i < (1 << N); i++){
            for(int j=0; j<N; j++){

                if(((i >> j) & 1) != 0 ){

                    for(int k=0; k<N; k++){

                        if(k != j && arr[k] != arr[j] && ((i >> k) & 1) != 0 && adj[arr[j]][arr[k]] == 1){
                            dp[j][i] += dp[k][(i ^ (1 << j))];
                        }

                    }

                }

            }
        }

        long counter = 0l;

        for(int i=0; i<N; i++){
            counter += dp[i][(1 << N) - 1];
        }

        return counter;
    }
}