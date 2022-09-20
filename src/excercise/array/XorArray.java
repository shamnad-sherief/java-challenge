//You are given an array arr[], you have to re-construct an array arr[].
//The values in arr[] are obtained by doing Xor of consecutive elements in the array.
//arr[0]=arr[0]^arr[1];


package excercise.array;

import java.util.Arrays;

public class XorArray {


    public static void main(String[] args) {

            int[] arr={2,3,4,7,5,8};
            // Complete the function
            for(int d=0;d < arr.length-1;d++) {
                arr[d] = arr[d]^arr[d+1];
            }
        System.out.println(Arrays.toString(arr));

    }
}
