// Our geek loves to play with strings, Currently, he is trying to reduce the size of a string by recursively removing
// all the consecutive duplicate pairs. In other words, He can apply the below operations any number of times.
// Remove all the consecutive duplicate pairs and concatenate the remaining string to replace the original string.
// Your task is to find the string with minimum length after applying the above operations.

// source:- https://practice.geeksforgeeks.org/problems/466faca80c3e86f13880710491c634d26abd44a7/1

package excercise.stack;

import java.util.Stack;

public class RemovePairs {
    public static void main(String[] args) {

        String s = "aaabbaaccd";

        RemovePairsSolution obj = new RemovePairsSolution();

        System.out.println(obj.removePair(s));
    }
}


class RemovePairsSolution {
    public static String removePair(String s) {

        Stack<Character> stk = new Stack<>();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(stk.isEmpty() || ch != stk.peek()){
                stk.push(ch);
            }else{
                stk.pop();
            }
        }

        StringBuilder str = new StringBuilder();
        while(!stk.isEmpty()){
            char c = stk.pop();
            str.append(c);
        }
        String a = str.reverse().toString();

        if(a.length() == 0) return "-1";
        else return a;

    }
}
