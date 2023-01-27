// A top secret message containing letters from A-Z is being encoded to numbers using the following mapping: A:1, B:2, C:3 ...etc:
//  You have to determine the total number of ways that message can be decoded, as the answer can be large return the answer modulo 109 + 7.

// source:- https://practice.geeksforgeeks.org/problems/total-decoding-messages1235/1

package excercise.strings;

public class DecodeString {
    public static void main(String[] args) {
        String str = "123";

        DecodeStringSolution obj = new DecodeStringSolution();

        System.out.println(obj.CountWays(str));

    }
}


class DecodeStringSolution {
    public int CountWays(String str) {

        int dp[] = new int[str.length()+1];
        dp[0] = 1;
        dp[1] = str.charAt(0) == '0'?0:1;

        for(int i = 2; i <= str.length(); i++){
            if(str.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }
            int twoDigit = Integer.parseInt(str.substring(i-2,i));
            if(twoDigit <= 26 && twoDigit >= 10){
                dp[i] += dp[i-2];
            }
            dp[i] %= 1000000007;
        }
        return dp[str.length()];
    }
}

