//There are given N ropes of different lengths, we need to connect these ropes into one rope.
// The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.
// Given N size array arr[] contains the lengths of the ropes.

//source:- https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

package excercise.queue;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        long[] arr={4, 3, 2, 6};
        int n= arr.length;

        MinimumCostOfRopesSolution s1 = new MinimumCostOfRopesSolution();

        System.out.println(s1.minCost(arr,n));

    }
}


class MinimumCostOfRopesSolution {

    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n)
    {
        //implementing MinHeap using priority queue.
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) pq.add(arr[i]);
        Long cost = new Long("0");

        //using a loop while there is more than one element in priority queue.
        while (pq.size() != 1)
        {
            //storing the first and second numbers from priority queue.
            long x = pq.poll();
            long y = pq.poll();

            //adding their sum in result.
            cost += (x + y);

            //pushing the sum of first and second numbers in priority queue.
            pq.add(x + y);
        }
        //returning the result.
        return cost;
    }
}