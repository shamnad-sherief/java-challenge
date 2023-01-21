// Given two integers A and B, the task is to find an integer X such that (X XOR A) is minimum possible and the
// count of set bit in X is equal to the count of set bits in B.

// source:- https://practice.geeksforgeeks.org/problems/1fc4278adf2a36780f637c7b4cd06391dd1487e4/1

package excercise.basics;

public class MinimumXORInteger {
    public static void main(String[] args) {

        int a = 3;
        int b = 5;

        MinimumXORIntegerSolution obj = new MinimumXORIntegerSolution();

        System.out.println(obj.minVal(a,b));
    }
}


class MinimumXORIntegerSolution {

    public static int minVal(int a, int b) {

        int bcb = Integer.bitCount(b); // bit count of b
        int bca = Integer.bitCount(a); // bit count of a
        if(bca==bcb)
        {
            return a;
        }
        while(bca<bcb)
        {
            a = a|(a+1); // increment the value of a
            bca++;
        }
        while(bca>bcb)
        {
            a = a & (a-1);
            bca--;
        }
        return a;

    }
}