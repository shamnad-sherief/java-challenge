package excercise.array;

public class MaxOfArrayRotate {
    public static void main(String[] args) {
        int[] arr={5,4,3,6,1};
        int[] temp= new int[arr.length];

        int max = 0;

        for(int i=0; i< arr.length;i++){
            int last= arr[0];
            for(int j=0; j< arr.length-1;j++){
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = last;
            int sum = 0;
            for (int m=0;m< arr.length;m++) {
                System.out.print(arr[m] + " ");
                sum=sum+(m*arr[m]);
            }
            System.out.println(" "+sum);

//            for(int k=0;k< arr.length;k++){
//                sum=sum+(k*arr[k]);
//            }
            if (max<sum){
                max = sum;
                for (int l=0;l< arr.length;l++){
                    temp[l] = arr[l];
                }
            }
        }
        for (int m=0;m< arr.length;m++) {
            System.out.print(temp[m] + " ");
        }

        System.out.println("\n"+max);

    }
}
