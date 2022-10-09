// This program takes N as input paramater and returns Nth term.
// The Nth term is the difference of N and the closest prime number to N.

// source:- https://practice.geeksforgeeks.org/problems/help-ishaan5837/1

package excercise.basics;

import java.util.Arrays;

public class NthTermNearestPrimeDiff {
    public static void main(String[] args) {
        int N = 25;

        NthTermNearestPrimeDiffSolution1 s1 = new NthTermNearestPrimeDiffSolution1();

        System.out.println(s1.NthTerm(N));
    }

}


class NthTermNearestPrimeDiffSolution1 {
    public boolean isPrime(int n){
        if(n<2)return false;
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public int NthTerm(int N)
    {
        // code here
        if(isPrime(N))return 0;
        int i = 0;
        while(i < N){
            if(isPrime(N-i) || isPrime(N+i)){
                break;
            }
            i++;
        }
        return i;
    }
}

class NthTermNearestPrimeDiffSolution2 {
    public int NthTerm(int N) {
        // code here
        int res = 0;
        boolean[] isPrime = new boolean[N*2];

        Arrays.fill(isPrime, true);
        if (N == 1) return 1;
        for(int i = 2; i*i < N*2; i++){

            if(isPrime[i]==true) {


                for (int j = i * i; j < N * 2; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        boolean bool=false;

        int k =1;
        while(!bool){
            if (isPrime[N]==true){
                res = 0;
                bool = true;
            }

            else if (isPrime[N-k]==true){
                res = k;
                bool = true;
            }

            else if (isPrime[N+k]==true){
                res = k;
                bool = true;
            }

            k++;
        }

        return res;

    }
}


