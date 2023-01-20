// Given a maze with N cells. Each cell may have multiple entry points but not more than one exit (i.e entry/exit points
// are unidirectional doors like valves). You are given an array Edge[] of N integers, where Edge[i] contains the cell index
// that can be reached from cell i in one step. Edge[i] is -1 if the ith cell doesn't have an exit. The task is to find the cell
// with maximum weight (The weight of a cell is the sum of cell indexes of all cells pointing to that cell). If there are multiple
// cells with the maximum weight return the cell with highest index.

// source:- https://practice.geeksforgeeks.org/problems/b64485d3994958cca8748991bb58668204b3e4c0/1

package excercise.array;

public class MaximumWeightNode {
    public static void main(String[] args) {

        int N = 4;
        int[] Edge = {2, 0, -1, 2};

        MaximumWeightNodeSolution obj = new MaximumWeightNodeSolution();

        System.out.println(obj.maxWeightCell(N,Edge));
    }
}


class MaximumWeightNodeSolution{
    public int maxWeightCell(int N, int Edge[]){
        int [] ans = new int[N];
        for(int i = 0; i < N; i++){
            if( Edge[i] != -1){
                ans[Edge[i]]+=i;
            }
        }
        int max = 0;
        int res = 0;
        for(int i = 0; i < N; i++){
            if(ans[i] > max){
                max = ans[i];
                res = i;
            }
        }
        return res;
    }
}