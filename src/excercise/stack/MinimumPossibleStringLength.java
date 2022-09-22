package excercise.stack;

//a string Sof size Nconsisting of characters from '0'to '9'.
// minimise the length of the string such that each minimising operation, you can remove
// any two consecutive characters if they are of the form {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"}.
// Find the minimum possible length of the string after applying minimising operations.
//Input:
//        N = 5
//        S = "12213"
//        Output: 1
//        Explanation: Geek can get the string of
//        length 1 in two minimising operation,
//        In 1st operation Geek will remove "12"
//        from "12213" then Geek left with "213"
//        In 2nd operation Geek will remove "21"
//        from "213" then Geek left with "3"

// source:- https://practice.geeksforgeeks.org/problems/904237fa926d79126d42c437802b04287ea9d1c8/1


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MinimumPossibleStringLength {
    public static void main(String[] args) {
        String s = "12213";
        int n = s.length();

        MinimumPossibleStringLengthSolution s1 = new MinimumPossibleStringLengthSolution();
        System.out.println(s1.minLength(s,n));


    }

}
class MinimumPossibleStringLengthSolution {
    public int minLength(String s, int n)
    {
        Stack<Character> st = new Stack<>();
        ArrayList<String> list = new ArrayList<String>(
                Arrays.asList("12", "21", "34", "43", "56", "65", "78", "87", "09", "90")
        );

        // For every character of the string
        for (int i = 0; i < n; i++) {

            // If the stack is empty then push the
            // current character in the stack
            if (st.empty()) {
                st.push(s.charAt(i));
            }
            else {

                String temp = "";

                temp += st.peek();
                temp += s.charAt(i);

                int flag = 0;
                for(int j = 0; j < list.size(); j++)
                    if(list.get(j).equals(temp))
                        flag = 1;

                // If removable
                if(flag == 1){
                    st.pop();
                }
                // Else push the current element
                else {
                    st.push(s.charAt(i));
                }
            }
        }
        return st.size();
    }
}