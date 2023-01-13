// Given an array arr[ ] of N elements, your task is to find the minimum number of increment operations required to make all the
// elements of the array unique. ie- no value in the array should occur more than once. In an operation a value can be incremented by 1 only.

// source:- https://practice.geeksforgeeks.org/problems/6e63df6d2ebdf6408a9b364128bb1123b5b13450/1

package excercise.array;

import java.util.Arrays;

public class UniqueElementArray {
    public static void main(String[] args) {

        int N = 3;
        int[] arr = {1, 2, 2};

        UniqueElementArraySolution obj = new UniqueElementArraySolution();

        System.out.println(obj.minIncrements(arr, N));
    }
}

class UniqueElementArraySolution {
    public long minIncrements(int[] arr, int N) {

        Arrays.sort(arr);
        int count = 0;

        for(int i=1;i<N;i++){
            if(arr[i] == arr[i-1]){
                count+=1;
                arr[i]+=1;
            }

            else if(arr[i] < arr[i-1]){
                int temp = arr[i-1]+1;
                count+= (temp - arr[i]);
                arr[i] = temp;
            }
        }
        return count;
    }
}