// Given an array of integers of size n and an integer k, find all the pairs in the array whose absolute difference is divisible by k.

// source:- https://practice.geeksforgeeks.org/problems/e0059183c88ab680b2f73f7d809fb8056fe9dc43/1

package excercise.hashmap;

import java.util.HashMap;

public class CountPairDivisbleByDifference {
    public static void main(String[] args) {

        int n = 3;
        int arr[] = {3, 7, 11};
        int k = 4;

        CountPairDivisbleByDifferenceSolution obj = new CountPairDivisbleByDifferenceSolution();

        System.out.println(obj.countPairs(n, arr, k));

    }
}

class CountPairDivisbleByDifferenceSolution {
    static long countPairs(int n, int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int count = 0;

        for(int i=0; i< n; i++){

            int a = arr[i]%k;

            if(map.containsKey(a)){

                count += map.get(a);

            }

            map.put(a,map.getOrDefault(a, 0)+1);

        }

        return count;
    }
}


