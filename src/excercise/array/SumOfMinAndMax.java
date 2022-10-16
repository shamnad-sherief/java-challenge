//Given an array A of size N of integers. Your task is to find the sum of minimum and maximum element in the array.

// source:- https://practice.geeksforgeeks.org/problems/max-min/1

package excercise.array;

public class SumOfMinAndMax {
    public static void main(String[] args) {

        SumOfMinAndMaxSolution s1 = new SumOfMinAndMaxSolution();
        int N = 5;
        int[] A = {-2, 1, -4, 5, 3};
        System.out.println(s1.findSum(A,N));
    }
}

class SumOfMinAndMaxSolution {

    public static int findSum(int A[],int N) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (N==1){
            return A[0];

        }

        else{
            for(int i = 0; i < N; i++){
                if(A[i] < min){
                    min = A[i];
                }

                if(A[i] > max){
                    max = A[i];
                }
            }

            return min+max;
        }

    }
}

