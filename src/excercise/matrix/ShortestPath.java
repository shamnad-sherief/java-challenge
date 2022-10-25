// Given a n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between
// a given source cell to a destination cell. The path can only be created out of a cell if its value is 1. If the path
// is not possible between source cell and destination cell, then return -1.

// source:- https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1

package excercise.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    public static void main(String[] args) {
        int grid[][] = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};
        int [] source = {0, 1};
        int [] destination  = {2, 2};

        ShortestPathSolution s1 = new ShortestPathSolution();

        System.out.println(s1.shortestPath(grid,source,destination));
    }
}



class ShortestPathSolution {

    boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();

        q.add(source);
        dist[source[0]][source[1]] = 0;
        while (!q.isEmpty()) {
            int[] currentCell = q.poll();

            int currentX = currentCell[0];
            int currentY = currentCell[1];
            if (currentCell[0] == destination[0] &&
                    currentCell[1] == destination[1]) {
                return dist[currentX][currentY];
            }
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if (isValid(nextX, nextY, n, m) && grid[nextX][nextY]==1 &&
                        dist[nextX][nextY] == Integer.MAX_VALUE) {
                    q.add(new int[]{nextX, nextY});
                    dist[nextX][nextY] = dist[currentX][currentY] + 1;
                }
            }
        }

        return -1;
    }
}