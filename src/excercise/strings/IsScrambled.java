// Given two strings S1 and S2 of equal length, the task is to determine if S2 is a scrambled form of S1.

// source:- https://practice.geeksforgeeks.org/problems/scrambled-string/1

package excercise.strings;

import java.util.HashMap;

public class IsScrambled {
    public static void main(String[] args) {

        String S1="coder";
        String S2="ocder";

        IsScrambledSolution obj = new IsScrambledSolution();

        System.out.println(obj.isScramble(S1,S2));

    }
}


class IsScrambledSolution {
    static HashMap<String,Boolean> map=new HashMap<>();
    static boolean isScramble(String s1,String s2)
    {

        if(s1.equals(s2))
        {
            return true;
        }
        String key=s1+"_"+s2;
        if(map.containsKey(key))
        {
            return map.get(key);
        }
        boolean flag=false;
        int n=s1.length();
        for(int i=1;i<n;i++)
        {
            boolean swap=(isScramble(s1.substring(0, i),s2.substring(n - i,n)) && isScramble(s1.substring(i, n),s2.substring(0, n-i)));
            boolean noswap=(isScramble(s1.substring(0, i),s2.substring(0, i))  && isScramble(s1.substring(i, n),s2.substring(i, n)));
            if(noswap||swap)
            {
                flag=true;
                break;
            }
        }
        map.put(key,flag);
        return flag;
    }
}


