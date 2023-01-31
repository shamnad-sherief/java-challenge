// Given two strings A and B. Find minimum number of times A has to be repeated such that B is a Substring of it.
// If B can never be a substring then return -1.

// source:- https://practice.geeksforgeeks.org/problems/fda70097eb2895ecfff269849b6a8aace441947c/1

package excercise.strings;

public class MinRepeatToSubString {
    public static void main(String[] args) {

        String A = "abcd";
        String B = "cdabcdab";

        MinRepeatToSubStringSolution obj = new MinRepeatToSubStringSolution();

        System.out.println(obj.minRepeats(A,B));
    }
}

class MinRepeatToSubStringSolution {
    static int minRepeats(String A, String B) {

        int a = A.length(),b = B.length();
        int x = (a>=b)?1:b/a;               // no. of time A needs to be repeated
        String temp="";                     // create an empty string

        for(int i=0;i<=2*x;i++){
            temp+=A;
            if(i<x-1) continue;
            if(temp.contains(B)) return i+1;
        }
        return -1;
    }
}
