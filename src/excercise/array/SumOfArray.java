// Given an integer array arr of size n, you need to sum the elements of arr.

// source:- https://practice.geeksforgeeks.org/problems/sum-of-array-elements2502/1?page=1

package excercise.array;

public class SumOfArray {
    public static void main(String[] args) {

        int n = 4;
        int[] arr = {1,4,3,7};

        System.out.println(sumElement(arr,n));

    }

    public static int sumElement(int arr[], int n)
    {

        int sum = 0;  // initialize sum as zero

        for(int i = 0; i < n; i++){
            sum = sum + arr[i];    // adding each element to sum
        }

        return sum;
    }
}
