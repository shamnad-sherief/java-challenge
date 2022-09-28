//Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

//source:- https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1

package excercise.array;

import java.util.Arrays;



public class Sort01and2s {
    public static void main(String[] args) {


        int[] a = {0, 2, 0, 1, 2, 1};
        int n = a.length;

        Sort01and2sSolution s1 = new Sort01and2sSolution();
        s1.sort012(a,n);

        System.out.println(Arrays.toString(a));

    }
}

class Sort01and2sSolution {
    public static void sort012(int a[], int n){

        int low = 0, high = n-1, mid = 0;

        while(mid <= high){

            if(a[mid]==0) {

                int temp=a[low];
                a[low]=a[mid];
                a[mid]=temp;
                low++;
                mid++;
            }

            else if(a[mid]==1) {
                mid++;
            }
            else {
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }
    }
}

