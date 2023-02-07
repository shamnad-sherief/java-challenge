// Given an array Arr of size N containing positive integers. Find the maximum sum of a subsequence such that no two numbers
// in the sequence should be adjacent in the array.

// source:- https://practice.geeksforgeeks.org/problems/7a33c749a79327b2889d420dd80342fff33aac6d/1

package excercise.array;

public class MaxSumWithoutAdjacent {
    public static void main(String[] args) {

        int[] arr = {5, 5, 10, 100, 10, 5};
        int n = 6;

        MaxSumWithoutAdjacentSolution obj = new MaxSumWithoutAdjacentSolution();

        System.out.println(obj.findMaxSum(arr,n));

    }
}

class MaxSumWithoutAdjacentSolution {

    int findMaxSum(int arr[], int n) {

        if(n==1)
            return arr[0];

        if(n>2)
            arr[n-3]+=arr[n-1];

        for(int i=n-4;i>=0;i--)
        {

            arr[i]+=Math.max(arr[i+2],arr[i+3]);
        }

        return Math.max(arr[0],arr[1]);
    }
}
