// Given an array Arr of N positive integers. Your task is to find the elements whose value is equal to that of its index value

// source:- https://practice.geeksforgeeks.org/problems/value-equal-to-index-value1330/1?page=1

package excercise.array;

import java.util.ArrayList;

public class ValueEqualToIndex {

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {15, 2, 45, 12, 7};

        ValueEqualToIndex obj = new ValueEqualToIndex();

        System.out.println(obj.valueEqualToIndex(arr,n));
    }

        ArrayList<Integer> valueEqualToIndex(int arr[], int n) {

            ArrayList<Integer> list = new ArrayList<Integer>();

            for(int i = 0; i < n; i++){
                if(arr[i] == i+1){
                    int index = i+1;
                    list.add(index);
                }
            }

            return list;
        }

    }

