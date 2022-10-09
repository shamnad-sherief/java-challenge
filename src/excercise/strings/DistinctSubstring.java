//Given a String S consisting only lowercase alphabets and an integer K.
// Find the count of all substrings of length K which have exactly K-1 distinct characters.

// source:- https://practice.geeksforgeeks.org/problems/substrings-of-length-k-with-k-1-distinct-elements/1


package excercise.strings;

import java.util.ArrayList;

public class DistinctSubstring {

    public static void main(String[] args) {

        String X = "abcc";
        int K = 2;

        DistinctSubstringSolution1 s1 = new DistinctSubstringSolution1();
        DistinctSubstringSolution2 s2 = new DistinctSubstringSolution2();

        System.out.println(s2.countOfSubstrings(X,K));
    }


}


class DistinctSubstringSolution1 {
    static int countOfSubstrings(String S, int K) {
        // code here
        int distcount = 0;
        for(int i=0;i<=S.length()-K;i++){
            int count = 0;

            String X="";
            for(int j=i;count<K;j++){
                X += S.charAt(j);
                if(count==(K-1)){
                    distcount +=  distinctCount(X,K);
                }

                count++;
            }
        }

        return distcount;
    }

    public static int distinctCount(String X, int K){
        ArrayList<Character> list = new ArrayList<>();
        list.clear();
        for(int i=0;i<X.length();i++){
            if (!list.contains(X.charAt(i))){
                list.add(X.charAt(i));
            }
        }

        if(list.size()==(K-1))
            return 1;

        else
            return 0;


    }
}


class DistinctSubstringSolution2 {
    static int countOfSubstrings(String S,int K){
        int ans = 0, dist = 0, n = S.length();
        int[] fre = new int[26];
        for(int i = 0; i < K; i++)
        {
            fre[S.charAt(i)-'a']++;
            if(fre[S.charAt(i)-'a']==1)
                dist++;
        }

        if(dist==K-1)
            ans++;

        for(int i = K; i < n; i++)
        {
            fre[S.charAt(i-K)-'a']--;
            if(fre[S.charAt(i-K)-'a']==0)
                dist--;
            fre[S.charAt(i)-'a']++;
            if(fre[S.charAt(i)-'a']==1)
                dist++;

            if(dist==K-1)
                ans++;
        }

        return ans;
    }

}