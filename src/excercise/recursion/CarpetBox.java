// There is a carpet of a size a*b [length * breadth]. You are given a box of size c*d. The task is, one has to fit the carpet in the box
// in a minimum number of moves.In one move, you can either decrease the length or the breadth of the carpet by half (floor value of its half).
// Note: One can even turn the carpet by 90 degrees any number of times, wont be counted as a move.

// source:- https://practice.geeksforgeeks.org/problems/230d87552a332a2970b2092451334a007f2b0eec/1

package excercise.recursion;

public class CarpetBox {
    public static void main(String[] args) {

        int A = 8;
        int B = 13;
        int C = 6;
        int D = 10;

        CarpetBoxSolution obj = new CarpetBoxSolution();

        System.out.println(obj.carpetBox(A, B, C, D));

    }
}


class CarpetBoxSolution {
    int carpetBox(int A, int B, int C, int D){
        if((A <= C && B <= D) || (B <= C && A <= D)) return 0;  // If either of these conditions are true, the function will return 0.
        if(A>C && A>D) return 1+carpetBox(A/2, B, C, D);
        if(B>C && B>D) return 1+carpetBox(A, B/2, C, D);

        return Math.min(1+carpetBox(A/2,B,C,D), 1+carpetBox(A,B/2,C,D));

    }
}