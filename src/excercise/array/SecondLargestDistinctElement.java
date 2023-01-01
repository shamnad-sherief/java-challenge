// Given an array Arr of size N, print second largest distinct element from an array.

// source:- https://practice.geeksforgeeks.org/problems/second-largest3735/1?page=1

package excercise.array;

public class SecondLargestDistinctElement {

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {12, 35, 1, 10, 34, 1};

        SecondLargestDistinctElement obj = new SecondLargestDistinctElement();

        System.out.println(obj.print2largest(arr,n));
    }

    int print2largest(int arr[], int n) {
        // code here
        int i, first, second;

        // There should be at least two elements
        if (n < 2) {
            return -1;
        }

        first = second = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {

            // If current element is greater
            // than first then update both
            // first and second
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }

            // If arr[i] is in between first
            // and second then update second
            else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        if (second == Integer.MIN_VALUE)
            return -1;
        else
            return second;
    }
}
