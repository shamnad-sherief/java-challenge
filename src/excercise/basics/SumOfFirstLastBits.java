// Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits.

// source:- https://practice.geeksforgeeks.org/problems/count-even-length1907/1

package excercise.basics;
import java.util.Scanner;

public class SumOfFirstLastBits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter binary sequence length: ");
        int n = input.nextInt();


        SumOfFirstLastBits obj = new SumOfFirstLastBits();
        System.out.println(obj.SumOfFirstLastBitsSolution(n));
    }


        static long mod=1000000007;
        public int  SumOfFirstLastBitsSolution(int n)
        {
            if(n==1)
                return 2;
            long val=2;
            for(long i=1;i<n;i+=1)
            {
                val=(val%mod*((2*i)%mod+1)%mod*2)%mod;
                long x=modpwr(i+1,mod-2);
                val=(val*x)%mod;
            }
            return (int)val;
        }
        public static long modpwr(long m,long n)
        {
            long res=1;
            m=m%mod;
            if(m==0)
                return 0;
            while(n>0)
            {
                if((n&1)!=0)
                {
                    res=(res*m)%mod;
                }
                n=n>>1;
                m=(m*m)%mod;
            }
            return res;
        }
}





