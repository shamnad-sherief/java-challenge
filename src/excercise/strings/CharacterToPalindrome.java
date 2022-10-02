package excercise.strings;

//  Given string str of length N. The task is to find the minimum characters to be added at the front to make string palindrome.

// source:- https://practice.geeksforgeeks.org/problems/minimum-characters-to-be-added-at-front-to-make-string-palindrome/1

public class CharacterToPalindrome {

    public static void main(String[] args) {
        String str = "aacecaaa";

        CharacterToPalindromeSolution s1= new CharacterToPalindromeSolution();

        System.out.println(s1.minChar(str));
    }

}

class CharacterToPalindromeSolution {
    public static int solve(String s, String r) {
        int i,j,n=s.length();
        if(n==0)return 0;
        int []lps=new int[n+1];
        for(i=0,j=0;i<n;){
            if(s.charAt(i)==r.charAt(j)){
                lps[++i]=++j;
            }
            else if(j>0){
                j=lps[j-1];
            }
            else {
                lps[++i]=0;
            }
        }
        return n-lps[n];
    }
    public static int minChar(String str) {
        return solve(new StringBuilder(str).reverse().toString(),str);
    }
}