// A Hamiltonian path, is a path in an undirected graph that visits each vertex exactly once.
// Given an undirected graph, the task is to check if a Hamiltonian path is present in it or not.

// source:- https://practice.geeksforgeeks.org/problems/hamiltonian-path2522/1

package excercise.graph;

import java.util.ArrayList;

public class CheckHamiltonianPath {
    public static void main(String[] args) {

        int N = 4;
        int M = 4;

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<>();

        ArrayList<Integer> e = new ArrayList<>();
        e.add(1);
        e.add(2);
        Edges.add(e);

        e = new ArrayList<>();
        e.add(2);
        e.add(3);
        Edges.add(e);

        e = new ArrayList<>();
        e.add(3);
        e.add(4);
        Edges.add(e);

        e = new ArrayList<>();
        e.add(2);
        e.add(4);
        Edges.add(e);

        CheckHamiltonianPathSolution s1 = new CheckHamiltonianPathSolution();

        System.out.println(s1.check(N,M,Edges));
    }
}


class CheckHamiltonianPathSolution {
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i<=N ; i++)
            adj.add(new ArrayList<Integer>());
        // Preparing Adj matric || Adding Neighbor
        for(int i=0; i<M ; i++)
        {
            adj.get(Edges.get(i).get(0)).add(Edges.get(i).get(1));
            adj.get(Edges.get(i).get(1)).add(Edges.get(i).get(0));
        }

        boolean visited[] = new boolean[N+1];
        for(int i = 1 ; i<=N ; i++)
        {
            if(!visited[i])
                if(dfs(N , adj , visited ,i , 1)) return true;
        }
        return false;

    }
    // DFS
    boolean dfs(int N ,ArrayList<ArrayList<Integer>> adj ,boolean[] visited ,int source ,int count)
    {
        if(count==N)return true;
        visited[source] = true;
        for(int i : adj.get(source))
        {
            if(visited[i]==false && dfs(N,adj,visited,i,count+1))
                return true;
        }
        visited[source] = false;
        return false;
    }

}
