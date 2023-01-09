// Samwell laid out N bowls in a straight line and put a few marbles randomly in each bowl, ith bowl has A[i] marbles.
// A bowl can never have more than 9 marbles at a time. A bowl can have zero marbles. Now Samwells friend adds one more marble
// to the last bowl, after this addition all the bowls must still be aligned with the rules mentioned above. Adding a marble follows the same rules as of addition with carryover.
// You are given the initial list of the number of marbles in each bowl find the position of the bowl which was last modified. It is guaranteed that there is at least one bowl which has at least one space left.

// source:- https://practice.geeksforgeeks.org/problems/33af95e5935f1f2a0c3f5083c4b9d0db68e97bd4/1

package excercise.array;

public class LastModifiedBowl {
    public static void main(String[] args) {

        int N = 4;
        int[] A = {3, 1, 4, 5};

        LastModifiedBowlSolution obj = new LastModifiedBowlSolution();
        System.out.println(obj.solve(N,A));
    }
}


class LastModifiedBowlSolution{
    int solve(int N, int[] A) {
        for(int i = A.length-1; i > -1; i--)
        {
            if(A[i] >= 9)
            {
                continue;
            }
            else
            {
                return i+1;
            }
        }
        return -1;
    }
}
