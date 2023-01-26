// Given a string S consisting of only uppercase and lowercase characters. The task is to sort uppercase and lowercase letters
// separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase
// character after being sorted and vice versa.

// source:- https://practice.geeksforgeeks.org/problems/case-specific-sorting-of-strings4845/1

package excercise.strings;

import java.util.Arrays;

public class CaseSort {
    public static void main(String[] args) {

        String S = "defRTSersUXI";

        CaseSortSolution obj = new CaseSortSolution();

        System.out.println(obj.caseSort(S));
    }
}

class CaseSortSolution {
    public static String caseSort(String str){

        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        int up=0,lo=0;

        while(lo<ch.length) {
            if(ch[lo]>='a') break;
            lo++;
        }

        char[] ans = new char[ch.length];

        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)>='a') {
                ans[i]=ch[lo++];
            } else {
                ans[i]=ch[up++];
            }
        }
        return new String(ans);
    }
}
