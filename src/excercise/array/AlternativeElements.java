// You are given an array A of size N. You need to print elements of A in alternate order (starting from index 0).

// source:- https://practice.geeksforgeeks.org/problems/print-alternate-elements-of-an-array/1

package excercise.array;

public class AlternativeElements {
    public static void main(String[] args) {

        int n = 4;
        int[] arr = {1, 2, 3, 4};

        AlternativeElementsSolution obj = new AlternativeElementsSolution();

        obj.print(arr,n);

    }
}

class AlternativeElementsSolution{

    public static void print(int arr[], int n)
    {
        for(int i = 0; i < n; i+=2){    // increment i=i+2
            System.out.print(arr[i]+" ");
        }
    }

}