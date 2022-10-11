// An encoded string (s) is given, the task is to decode it. The encoding pattern is that the occurance of the string
// is given at the starting of the string and each string is enclosed by square brackets.

// source:- https://practice.geeksforgeeks.org/problems/decode-the-string2444/1

package excercise.stack;

import java.util.Stack;

public class StringDecode {
    public static void main(String[] args) {

        String s = "3[b2[ca]]";

        StringDecodeSolution s1 = new StringDecodeSolution();

        System.out.println(s1.decodedString(s));

    }
}


class StringDecodeSolution{
    static String decodedString(String s){

         Stack<Character> st = new Stack<>();
        int n = s.length();

        StringBuilder res = new StringBuilder("");

        for(int i = 0; i < n; i++){

            char c = s.charAt(i);

            if(c!=']'){

                st.push(c);

            }else{

                while(st.peek()!='['){

                    res.append(st.pop());

                }

                res.reverse();

                st.pop();

                StringBuilder rnum = new StringBuilder("");



                while(!st.empty() && st.peek() >= '0' && st.peek() <= '9'){

                    rnum.append(st.pop());

                }

                rnum.reverse();

                String sr = res.toString();

                for(int k = 0; k < Integer.parseInt(rnum.toString())-1; k++){

                    res.append(sr);

                }

                for(int k = 0; k < res.length(); k++){

                    st.push(res.charAt(k));
                }

                res = new StringBuilder("");

            }

        }

        res = new StringBuilder("");
        while(!st.empty()){
            res.append(st.pop());

        }


        return res.reverse().toString();
    }
}