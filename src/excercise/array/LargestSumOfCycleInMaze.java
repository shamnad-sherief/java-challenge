// Given a maze with N cells. Each cell may have multiple entry points but not more than one exit(i.e entry/exit points
// are unidirectional doors like valves). You are given an array Edge[] of N integers, where Edge[i] contains the cell number
// that can be reached from of cell i in one step. Edge[i] is -1 if the ith cell doesn't have an exit. The task is to find the
// largest sum of a cycle in the maze(Sum of a cycle is the sum of the cell indexes of all cells present in that cycle).

// source:- https://practice.geeksforgeeks.org/problems/51afa710a708c0681748445b509696dd588d5c40/1

package excercise.array;

import java.util.HashSet;

public class LargestSumOfCycleInMaze {
    public static void main(String[] args) {
        int n = 4;
        int[] edge = {1, 2, 0, -1};

        LargestSumOfCycleInMazeSolution obj = new LargestSumOfCycleInMazeSolution();

        // Call the method to get the largest sum of a cycle in the maze
        System.out.println(obj.largesSumCycle(n,edge));
    }
}

// Class containing the solution to find the largest sum of a cycle in the maze
class LargestSumOfCycleInMazeSolution{
    public long largesSumCycle(int n, int edge[]){
        // A boolean array to keep track of visited nodes
        boolean[] visited = new boolean[n];
        long ans = -1;

        // Loop through all nodes
        for(int i = 0; i < n; ++i){
            // Skip if node is already visited or has no edge or the destination node is already visited
            if(visited[i] || edge[i]==-1 || visited[edge[i]]) continue;

            int src = i;
            long temp = 0;
            HashSet<Integer> set = new HashSet<>();
            // Traverse through the cycle
            while(visited[src]!=true){
                visited[src] = true;
                set.add(src);
                src = edge[src];
                if(src==-1) break;
            }
            // If there is no cycle, continue
            if(src == -1 || !set.contains(src)) continue;
            int idx = src;

            // Sum up all values in the cycle
            do{
                temp += edge[idx];
                idx = edge[idx];
            }while(idx!=src);
            // Update the answer with the maximum cycle sum
            ans = Math.max(temp, ans);
        }

        // Return the answer
        return ans;
    }
}
