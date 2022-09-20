package excercise.array;

//Given an array of integers arr[] of size N and an integer,
//the task is to rotate the array elements to the left by d positions.

public class ArrayRotate {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6};
        int[] temp = new int[6];

        int k = 0;
        int d =2;
        int n= 6;

        for (int i = d; i < n; i++) {
            temp[k] = arr[i];
            k++;
        }

        for (int i = 0; i < d; i++) {
            temp[k] = arr[i];
            k++;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }

        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }


    }
}
