// There is a row of N houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with
// a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. Find the minimum cost to paint all houses.
// The cost of painting each house in red, blue or green colour is given in the array r[], g[] and b[] respectively.

// source:- https://practice.geeksforgeeks.org/problems/844b4fdcd988ac5461324d62d43f7892749a113c/1

package excercise.matrix;

public class MinimumCostToPaint {
    public static void main(String[] args) {

        int N = 3;
        int[] r = {2, 1, 3};
        int[] g = {3, 2, 1};
        int[] b = {1, 3, 2};

        MinimumCostToPaintSolution obj = new MinimumCostToPaintSolution();

        System.out.println(obj.distinctColoring(N,r,g,b));
    }
}


class MinimumCostToPaintSolution{
    // Function to return the minimum cost of coloring the houses with 3 colors
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        // Initialize 2D dynamic programming array
        long dp[][]=new long[N][3];

        // First house can be colored with red, green, or blue with the corresponding cost
        dp[0][0]=r[0];
        dp[0][1]=g[0];
        dp[0][2]=b[0];

        // For each subsequent house, the cost of coloring it with a certain color is the cost of coloring
        // the previous house with the two remaining colors plus the cost of coloring the current house with that color
        for(int i=1;i<N;i++){
            dp[i][0]=r[i]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=g[i]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=b[i]+Math.min(dp[i-1][0],dp[i-1][1]);
        }

        // Return the minimum cost of coloring the last house among the three colors
        return Math.min( Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]);
    }
}