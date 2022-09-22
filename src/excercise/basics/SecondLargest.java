//Given an array Arr of size N, print second largest element from an array.
//
// Input:
// N = 6
// Arr[] = {12, 35, 1, 10, 34, 1}
// Output: 34

//source :- https://practice.geeksforgeeks.org/problems/second-largest3735/1

package excercise.basics;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr ={12,35,1,10,34,1};
        int n = arr.length;;


    }
}
class SecondLargestSolution{
    int print2largest(int arr[], int n) {


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
                first = arr[i];
                second = first;

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
};
    }
}