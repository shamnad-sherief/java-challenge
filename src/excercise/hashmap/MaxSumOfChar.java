// Given a string w, integer array b,  character array x and an integer n. n is the size of array b and array x.
// Find a substring which has the sum of the ASCII values of its every character, as maximum.ASCII values of some characters are redefined.
// Note: Uppercase & lowercase both will be present in the string w. Array b and Array x contain corresponding redefined ASCII values.
// For each i, b[i] contain redefined ASCII value of character x[i].

// source:- https://practice.geeksforgeeks.org/problems/save-your-life4601/1

package excercise.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfChar {

    public static void main(String[] args) {
        String w = "abcde";
        int n = 1;
        char[] x = { 'c' };
        int[] b = { -1000 };

        MaxSumOfCharSolution s1 = new MaxSumOfCharSolution();

        System.out.println(s1.maxSum(w,x,b,n));

    }
}

class MaxSumOfCharSolution{
    static String maxSum(String w,char x[],int b[], int n){

         Map<Character,Integer> map=new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(x[i],b[i]);
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(char c:w.toCharArray()){
            curr += map.containsKey(c)?map.get(c):c;
            temp.append(c);
            if(curr > max){
                max = curr;
                ans = new StringBuilder(temp);
            }

            if(curr < 0){
                curr = 0;
                temp = new StringBuilder();
            }
        }
        return ans.toString();
    }
}
