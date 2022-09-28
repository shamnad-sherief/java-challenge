//Geek is playing an array game. He is weak in the concepts of arrays.
// Geek is given two arrays arr[ ] and brr[ ] of the same size n.
// The array arr[ ] will be said to fit in array brr[ ] if by arranging the elements of both arrays,
// there exists a solution such that i'th element of arr[ ] is less than or equal to i'th element of brr[ ],
// for each i, 0 <= i < n. Help Geek find if the given array arr[ ] will fit in array brr[ ] or not.

// source:- https://practice.geeksforgeeks.org/problems/fitting-the-array1514/1

package excercise.array;

import java.util.Arrays;

public class FitAnArray {
    public static void main(String[] args) {

        int[] arr = {7, 5, 3, 2};
        int[] brr = {5, 4, 8, 7};
        int n = 4;

        FitAnArraySolution s1 = new FitAnArraySolution();
        System.out.println(s1.isFit(arr,brr,n));
    }
}

class FitAnArraySolution{

    public static boolean isFit (int arr[], int brr[], int n) {

        boolean bool=true;
        Arrays.sort(arr);
        Arrays.sort(brr);

        for(int i=0;i<n;i++){

            if(arr[i]>brr[i]){

                bool=false;
                break;
            }
        }

        return bool;
    }

}

