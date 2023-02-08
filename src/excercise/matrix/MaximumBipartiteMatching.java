// There are M job applicants and N jobs.  Each applicant has a subset of jobs that he/she is interested in.
// Each job opening can only accept one applicant and a job applicant can be appointed for only one job.
// Given a matrix G with M rows and N columns where G(i,j) denotes ith applicant is interested in the jth job.
// Find the maximum number of applicants who can get the job.

// source:- https://practice.geeksforgeeks.org/problems/9a88fe7ada1c49c2b3da7a67b43875e4a76aface/1

package excercise.matrix;

import java.util.Arrays;

public class MaximumBipartiteMatching {
    public static void main(String[] args) {
        int M = 3;
        int N = 5;
        int[][] G = {{1,1,0,1,1},{0,1,0,0,1},
                {1,1,0,1,1}};

        MaximumBipartiteMatchingSolution obj = new MaximumBipartiteMatchingSolution();

        System.out.println(obj.maximumMatch(G));
    }
}



class MaximumBipartiteMatchingSolution {
    // m: number of rows in graph G
    // n: number of columns in graph G
    // match[i]: store the match of column i
    // visited[i]: store if the column i has been visited in the current DFS
    // count: store the number of matches

    public int maximumMatch(int[][] G) {
        int m = G.length;
        int n = G[0].length;

        int[] match = new int[n];
        Arrays.fill(match, -1); // initialize all columns with no match

        boolean[] visited = new boolean[n]; // initialize all columns as unvisited

        int count = 0;

        for (int i = 0; i < m; i++) {
            Arrays.fill(visited, false); // reset all columns as unvisited before starting a new DFS
            if (dfs(G, i, visited, match)) {
                count++;
            }
        }

        return count;
    }

    private boolean dfs(int[][] G, int i, boolean[] visited, int[] match) {
        for (int j = 0; j < G[0].length; j++) {
            if (G[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                if (match[j] == -1 || dfs(G, match[j], visited, match)) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }
}