//Given two strings of lowercase English letters,A  and B, perform the following operations:
//1. Sum the lengths of A and B.
//2. Determine if A is lexicographically larger than  B(i.e.: does B come before A in the dictionary?).
//3. Capitalize the first letter in  A and B  and print them on a single line, separated by a space.

// source :- https://www.hackerrank.com/challenges/java-strings-introduction/problem?isFullScreen=true

package excercise.strings;

import java.util.*;

public class TwoStringComparison {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string1: ");
        String A=sc.next();
        System.out.print("Enter string2: ");
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int length= A.length()+B.length();
        System.out.println(length);
        char A1= A.charAt(0);
        char B1= B.charAt(0);

        if(A1>B1){
            System.out.println("Yes");
        }
        else
            System.out.println("No");


        String Output="";
        Output+=Character.toUpperCase(A.charAt(0));
        for(int i=1;i<A.length();i++){
            Output+=A.charAt(i);
        }
        Output+=" ";


        Output+=Character.toUpperCase(B.charAt(0));
        for(int i=1;i<B.length();i++){
            Output+=B.charAt(i);
        }

        System.out.println(Output);
    }
}




