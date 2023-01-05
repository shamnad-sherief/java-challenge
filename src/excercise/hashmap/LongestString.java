// Given an array of strings arr[]. You have to find the longest string which is lexicographically smallest
// and also all of its prefix strings are already present in the array.

// source:- https://practice.geeksforgeeks.org/problems/8d157f11af5416087251513cfc38ffc4d23be308/1


package excercise.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestString {
    public static String longestString(int N, String[] H) {

        Set<String> set = new HashSet<String>();

        for (String s : H) {
            set.add(s);
        }

        String ans = "";

        for(String s : H) {

            for (int i = 0; i < s.length(); i++){

                if (!set.contains(s.substring(0, i + 1))) {
                    break;
                }

                if (i == s.length() - 1) {
                    ans = check(s, ans);
                }
            }
        }
        return ans;
    }

    private static String check(String s1, String s2) {

        if (s1.length() > s2.length())  return s1;

        else if (s2.length() > s1.length()) return s2;

        if (s1.compareTo(s2) < 0)   return s1;

        else return s2;


    }

    public static void main(String[] args) {

        int N = 4;
        String[] H = {"ab", "a", "abc", "abd"};

        LongestString obj = new LongestString();

        System.out.println(obj.longestString(N,H));
    }
}
