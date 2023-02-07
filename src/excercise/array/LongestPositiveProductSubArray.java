// Given an array arr[] consisting of n integers, find the length of the longest subarray with positive (non zero) product.

// source:- https://practice.geeksforgeeks.org/problems/4dfa8ba14d4c94f4d7637b6b5246782412f3aeb8/1

package excercise.array;

public class LongestPositiveProductSubArray {
    public static void main(String[] args) {

        int[] arr ={0, 1, -2, -3, -4};
        int n = 5;

        LongestPositiveProductSubArraySolution obj = new LongestPositiveProductSubArraySolution();

        System.out.println(obj.maxLength(arr,n));

    }
}


class LongestPositiveProductSubArraySolution {
    int maxLength(int arr[], int n) {
        // Initialize variables to keep track of the lengths
        // of the current subarrays with positive and negative elements
        int max = 0;
        int p1 = 0;
        int p2 = 0;

        // Loop through each element in the array
        for (int i = 0; i < n; i++) {
            // If the current element is 0, reset both counters
            if (arr[i] == 0) {
                p1 = 0;
                p2 = 0;
            } else {
                // If the current element is positive, increment p1
                if (p2 > 0) {
                    p2++;
                }
                p1++;
                // If the current element is negative, swap p1 and p2
                if (arr[i] < 0) {
                    int t = p1;
                    p1 = p2;
                    p2 = t;
                }
            }
            // Update the maximum length seen so far
            max = Math.max(max, p1);
        }
        // Return the maximum length
        return max;
    }
}
