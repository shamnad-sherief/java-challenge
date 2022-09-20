package excercise.array;


public class ArrayRotateOneByOne {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};

        for(int i = 0; i< 2; i++) {
            int last = arr[0];
            for (int j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j+1];

            }
            arr[arr.length-1] = last;
        }

        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
