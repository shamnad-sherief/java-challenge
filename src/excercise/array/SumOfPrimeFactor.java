//Find the sum of all the numbers between the range l and r. Here each number is represented by the sum of its prime factors.
//Note : For example, 6 is represented by 5 because 6 has two prime factors 2 and 3 and 2 + 3 = 5.

//source:- https://practice.geeksforgeeks.org/problems/modified-numbers-and-queries0904/1

package excercise.array;

import java.util.HashSet;

public class SumOfPrimeFactor {
    public static void main(String[] args) {
        int l= 1;
        int r= 6;

        SumOfPrimeFactorSolution1 s1 = new SumOfPrimeFactorSolution1();
//      SumOfPrimeFactorSolution2 s2 = new SumOfPrimeFactorSolution2();

        System.out.println(s1.sumOfAll(l,r));
//      System.out.println(s2.sumOfAll(l,r));
    }
}

class SumOfPrimeFactorSolution1 {
    static int[] sieveOfEratosthenes(int N) {
        int b[]=new int[N+1];
        for(int i=2;i<=N;i++) {
            if(b[i]==0) {
                b[i]=i;
                for(int j=i*i;j<=N;j+=i) {
                    if(b[j]==0)
                        b[j]=i;
                }
            }
        }
        b[1]=1;
        return b;
        // code here
    }
    static int lpf(int a[],int n) {
        int x=0;
        if(n==1)
            return 1;
        HashSet<Integer> b=new HashSet<>();
        while(n!=1) {
            int i=a[n];
            n/=i;
            if(b.add(i))
                x+=i;
        }
        return x;
    }
    public int sumOfAll(int l, int r) {
        int a[]=new int[r+1];
        a=sieveOfEratosthenes(r);
        int sum=0;
        for(int i=l;i<=r;i++) {
            sum+=lpf(a,i);
        }
        return sum;
    }
}

class SumOfPrimeFactorSolution2{
    int quary[];
    void pre() {
        quary=new int[10001];
        for(int i=0 ; i<10001 ; i++)
            quary[i] = 0 ;

        quary[1] = 1 ;

        for(int i=2 ; 2*i<10001 ; i++) {
            if( quary[i] == 0 ) {
                for(int j=2*i ; j<10001 ; j+=i)
                    quary[j] += i ;
            }
        }

        quary[2] = 2 ;

        for(int i=3 ; i<10001 ; i+=2 ) {
            if( quary[i] == 0 )
                quary[i] = i ;
        }

        for(int i=2 ; i<10001 ; i++)
            quary[i] += quary[i-1] ;

    }
    public int sumOfAll(int l, int r)
    {
        // code here
        pre();
        return quary[r]-quary[l-1];
    }
}