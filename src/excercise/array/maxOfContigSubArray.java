//find the maximum value for each and every contiguous sub-list of size K.
//Input:
//        N = 5, K = 3
//        arr[] = 1 2 3 1 4
//        Output:
//        3 3 4
//        Explanation:
//        1st contiguous subarray = {1 2 3} Max = 3
//        2nd contiguous subarray = {2 3 1} Max = 3
//        3rd contiguous subarray = {3 1 4} Max = 4

// source :- https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1


package excercise.array;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class maxOfContigSubArray {
    public static void main(String[] args) {

        int[] arr={1,2,3,1,4};
        int k = 3;
        int n= arr.length;;

        maxOfContigSubArraySolution2 s2= new maxOfContigSubArraySolution2();
        System.out.println(s2.max_of_subarrays(arr,n,k));

    }
}

class maxOfContigSubArraySolution1{
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {

        ArrayList<Integer> list = new ArrayList<>();   //initialize ArrayList

        for(int i=0;i<=arr.length-k;i++){               // for a array of size N and subarray of size K
            int max=-1;
            for(int j=i; j<(i+k);j++){                  // compare elements in the subarray
                if(arr[j]>max){
                    max=arr[j];                         // store max values
                }
            }
            list.add(max);                              // add max value to list


        }

        return list;
    }
}

class maxOfContigSubArraySolution2 {    //Time Complexit >
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Declaring and Initializing an ArrayList of base size 0
        ArrayList<Integer> res = new ArrayList<Integer>(0);

        // Declaring and Initializing an ArrayDeque
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        // Creating a StringBuilder variable sb
        StringBuilder sb = new StringBuilder();

        int i = 0;

        // adding only the maximum element index in the range
        // 0 to k-1 and polling the remaining elements index
        for (i = 0; i < k; i++) {
            while (dq.isEmpty() == false && arr[i] >= arr[dq.peekLast()])
                dq.pollLast();

            dq.add(i);
        }

        // adding only the maximum element index in the range
        // interval k and polling the remaining elements index
        for (; i < n; i++) {
            // adding the maximum in interval k
            // to the ArrayList
            res.add(arr[dq.peek()]);

            while (dq.isEmpty() == false && (dq.peekFirst() <= i - k))
                dq.pollFirst();

            while (dq.isEmpty() == false && (arr[i] >= arr[dq.peekLast()]))
                dq.pollLast();

            dq.add(i);
        }

        // adding the last element of the
        // ArrayDeque to the ArrayList
        res.add(arr[dq.peek()]);
        dq.pollFirst();

        // returning the ArrayList of maximum elements
        // in subArrays of size k
        return res;
    }
}