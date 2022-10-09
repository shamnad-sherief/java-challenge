// Given a string S consisting of only lowercase characters. Find the lexicographically smallest string
// after removing exactly k characters from the string. But you have to correct the value of k, i.e.,
// if the length of the string is a power of 2, reduce k by half, else multiply k by 2. You can remove any k character.
// NOTE: If it is not possible to remove k (the value of k after correction) characters or if the resulting string is empty return -1.
//
// source:- https://practice.geeksforgeeks.org/problems/mila-and-strings0435/1

package excercise.stack;

import java.util.Stack;

public class LexicographicallySmaller {

    public static void main(String[] args) {

        String S = "fooland";
        int k = 2;

        LexicographicallySmallerSolution s1 = new LexicographicallySmallerSolution();

        System.out.println(s1.lexicographicallySmallest(S,k));

    }
}

class LexicographicallySmallerSolution{
    static String lexicographicallySmallest(String S, int k) {

        int n = S.length();
        // check power of 2
        if(powerfunction(n))
            k = k/2;
        else
            k = 2*k;
        if(k>=n) return "-1";
        StringBuilder s = new StringBuilder();
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<S.length(); i++){
            while(!st.isEmpty() && k > 0 && S.charAt(i) < st.peek()){
                st.pop();
                k--;
            }
            st.push(S.charAt(i));
        }
        while(k>0 && !st.empty()){
            st.pop();
            k--;
        }
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        s.reverse();
        return s.toString();

    }
    public static boolean powerfunction(int k){
        if(k!=0 && (k&(k-1)) == 0)
            return true;
        return false;
    }
}
