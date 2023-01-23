// You are given an array, arr of length N, and also a single integer K . Your task is to split the array arr into K non-overlapping, non-empty subarrays.
// For each of the subarrays, you calculate the sum of the elements in it. Let us denote these sums as S1, S2, S3, ..., SK.
// Where Si denotes the sum of the elements in the ith subarray from left.

// source:- https://practice.geeksforgeeks.org/problems/2b70d42632a4e207569c6d2d777383e4603d6fe1/1

package excercise.array;

import java.util.ArrayList;
import java.util.Collections;

public class GCDofSumofSubArray {
    public static void main(String[] args) {

        int N = 5;
        int K = 4;
        int[] arr = {6, 7, 5, 27, 3};

        GCDofSumofSubArraySolution obj = new GCDofSumofSubArraySolution();

        System.out.println(obj.solve(N,K,arr));

    }
}


class GCDofSumofSubArraySolution {
    public static int solve(int N, int K, int[] arr) {
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        ArrayList<Integer> divisors=new ArrayList<>();
        for(int i=1;i*i<=sum;i++){
            if(sum%i==0){
                divisors.add(i);
                if(i!=sum/i)divisors.add(sum/i);
            }
        }
        Collections.sort(divisors,Collections.reverseOrder());
        for(int i=1;i<N;i++){
            arr[i]+=arr[i-1];
        }
        int ans=1;
        for(int i:divisors){
            int cnt=0;
            for(int j=0;j<N;j++){
                if(arr[j]%i==0){
                    cnt++;
                }
            }
            if(cnt>=K){
                ans=i;
                break;
            }
        }
        return ans;
    }
}