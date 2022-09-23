//Two players, Player 1 and Player 2, are given an integer N to play a game.
// The rules of the game are as follows :
//1. In one turn, a player can swap any 2 bits of N in its binary representation to make a new N.
//2. In one turn, a player has to make a number strictly less than N.
//3. Player 1 always takes first turn.
//4. If a player cannot make a move, he loses.
//Assume that both the players play optimally.

//source:-https://practice.geeksforgeeks.org/problems/the-bit-game2313/1


package excercise.basics;

public class BitGame {
    public static void main(String[] args) {
        BitGameSolution s1 = new BitGameSolution();

        int N = 1;
        System.out.println(s1.swapBitGame(N));
    }
}

class BitGameSolution {
    public static int swapBitGame(long N) {
        // code here
        long xo=0;
        long o=0;
        while(N>0){
            if(N%2!=0 && o>0){
                xo^=o;
            }
            if(N%2==0){
                o++;
            }
            N/=2;
        }
        if(xo!=0)
            return 1;
        else
            return 2;
    }
}