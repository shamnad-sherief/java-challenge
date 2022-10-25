// Given a Bucket having a capacity of N litres and the task is to determine that by how many ways you can fill it
// using two bottles of capacity of 1 Litre and 2 Litre only. Find the answer modulo 108.

// source:- https://practice.geeksforgeeks.org/problems/filling-bucket0529/1

package excercise.basics;

public class FillingBucket {
    public static void main(String[] args) {

        int N = 3;

        FillingBucketSolution s1 = new FillingBucketSolution();

        System.out.println(s1.fillingBucket(N));
    }
}


class FillingBucketSolution {
    static int fillingBucket(int N) {

        int MOD = 100000000;     // Storing the value of MOD

        int[] fib = new int[N+1];
        fib[0] = fib[1] = 1;      // First two terms of the series are 1.
        for(int i=2; i<=N; i++)
            fib[i] = (fib[i-1]+fib[i-2]) % MOD;

        return fib[N];
    }
};