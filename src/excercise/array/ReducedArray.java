// Given an array with N distinct elements, convert the given array to a reduced form where all elements are in range from 0 to N-1.
// The order of elements is same, i.e., 0 is placed in place of smallest element, 1 is placed for second smallest element, and N-1 is placed
// for the largest element.

// source:- https://practice.geeksforgeeks.org/problems/convert-an-array-to-reduced-form1101/1

package excercise.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReducedArray {

    public static void main(String[] args) {

        int n = 3;
        int[] arr = {10, 40, 20};

        ReducedArraySolution obj = new ReducedArraySolution();
        obj.convert(arr, n);

        for (int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

class ReducedArraySolution {
    void convert(int[] arr, int n) {

        Map<Integer, Integer> map = new HashMap<>();  // create a hashmap to store the index and value

        for (int i=0;i<n;i++) {
            map.put(arr[i],i);                   // store index and value
        }

        int [] b = new int[arr.length];

        for (int i=0;i<n;i++) {               // copy array arr to array b

            b[i] = arr[i];
        }

        Arrays.sort(b);

        for (int i=0;i<n;i++) {
            arr[map.get(b[i])] = i;             // update elements of arr

        }
    }
}