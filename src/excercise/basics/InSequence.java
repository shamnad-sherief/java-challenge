// Given three integers  'A' denoting the first term of an arithmetic sequence , 'C' denoting the common difference of an arithmetic sequence and an integer 'B'.
// you need to tell whether 'B' exists in the arithmetic sequence or not. Return 1 if B is present in the sequence. Otherwise, returns 0.

// source:- https://practice.geeksforgeeks.org/problems/arithmetic-number2815/1

package excercise.basics;

public class InSequence {
    public static void main(String[] args) {

        int A = -2;
        int B = -9;
        int C = -7;

        InSequenceSolution obj = new InSequenceSolution();

        System.out.println(obj.inSequence(A,B,C));
    }
}

class InSequenceSolution {

    static int inSequence(int A, int B, int C){
        // Check if C is zero
        if (C == 0) {
            // If C is zero, return 1 if A is equal to B, 0 otherwise
            return A == B ? 1 : 0;
        }
        // Calculate the number of iterations required to reach B
        int numIterations = (B-A)/C;
        // Check if the result is negative or if A + numIterations * C is not equal to B
        if (numIterations < 0 || A + numIterations * C != B) {
            // If the result is negative or A + numIterations * C is not equal to B, return 0
            return 0;
        }
        // If none of the above conditions are met, return 1
        return 1;
    }
}
