// You are given N elements, you can remove any two elements from the list, note their sum, and add the sum to the list.
// Repeat these steps while there is more than a single element in the list. The task is to minimize the sum of these chosen sums.

// source:- https://practice.geeksforgeeks.org/problems/86e609332c9ef4f6b8aa79db11a6c0808c4a1bca/1

package excercise.queue;

import java.util.PriorityQueue;

public class MinimizeWithSum {

    public static void main(String[] args) {

        int N = 4;
        int[] arr = {1, 4, 7, 10};

        MinimizeWithSumSolution obj = new MinimizeWithSumSolution();

        System.out.println(obj.minimizeSum(N,arr));
    }
}

class MinimizeWithSumSolution {
    long minimizeSum(int N, int arr[]) {

        PriorityQueue<Long> q=new PriorityQueue<>();

        for(int i:arr){
            q.offer((long)i);
        }

        long sum=0,a=0,b=0;

        while( q.size() > 1){
            sum+=(a=q.poll())+(b=q.poll());
            q.offer(a+b);

         }
        return sum;
    }
}