// Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

// source:- https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

package excercise.array;

import java.util.ArrayList;

public class MaxOfContigSubArray {
    public static void main(String[] args) {
        int N = 9;
        int K = 3;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};

        MaxOfContigSubArraySolution s1 = new MaxOfContigSubArraySolution();

        System.out.println(s1.max_of_subarrays(arr,N,K));
    }
}


class MaxOfContigSubArraySolution {

    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i <= arr.length-k; i++){
            int count = 0;
            int max = Integer.MIN_VALUE;

            for(int j = i; count < k; j++){
                if(arr[j] > max){
                    max = arr[j];
                }

                count++;
            }
            list.add(max);
        }

        return list;
    }
}