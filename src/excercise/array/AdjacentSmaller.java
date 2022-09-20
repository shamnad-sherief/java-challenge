//Given an integer array Arr of size N. For each element in the array,
//check whether the right adjacent element (on the next immediate position) of the array is smaller.
//If next element is smaller, update the current index to that element. If not, then  -1.


package excercise.array;

public class AdjacentSmaller {
    public static void main(String[] args) {

       int[] arr = {4,2,1,6,3};
       for(int i=0;i<arr.length-1;i++){
        if(arr[i]>arr[i+1])
            arr[i] = arr[i + 1];
        else
            arr[i] = -1;
    }
    arr[arr.length-1]=-1;
        for (int j : arr)
            System.out.print(" " + j);
}
}

