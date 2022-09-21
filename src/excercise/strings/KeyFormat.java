
//Given a string S that consists of only alphanumeric characters and dashes.
// The string is separated into N + 1 groups by N dashes. Also given an integer K.
//We want to reformat the string S, such that each group contains exactly K characters,
// except for the first group, which could be shorter than K but still must contain at least one character.
// Furthermore, there must be a dash inserted between two groups,
// and you should convert all lowercase letters to uppercase.

//S = "5F3Z-2e-9-w", K = 4
//Output: "5F3Z-2E9W"

// source:- https://practice.geeksforgeeks.org/problems/license-key-formatting/1


package excercise.strings;

public class KeyFormat {
    public static void main(String[] args) {


        String S = "La5F3Z-2e-9-w";
        int K = 4;

        KeyFormatSolution2 s2= new KeyFormatSolution2();
        System.out.println(s2.ReFormatString(S,K));
    }

}


class KeyFormatSolution1{
    static String ReFormatString(String S, int K){

        StringBuilder sb = new StringBuilder();
        S=S.toUpperCase();
        S=S.replaceAll("-","");  //replace all '-'
        int n = S.length();
        for(int i=n-1,count=0;i>=0;i--){        //iterate the string from right to left
            if(count==K){
                sb.append('-');                  //append '-' after each K number of characters
                count=0;
            }
            sb.append(S.charAt(i));
            count++;
        }
        return sb.reverse().toString();
    }
}



class KeyFormatSolution2{
    static String ReFormatString(String S, int K){
        StringBuilder res = new StringBuilder();
        int cnt = 0;                                //initialize count=0 to track the characters
        for(int i=S.length()-1; i>=0; i--){
            if(S.charAt(i) != '-') {
                Character cap = Character.toUpperCase(S.charAt(i));  //store each element in cap variable
                if(cnt != 0 && cnt % K == 0) {       // if character count is divisible by K;
                    cnt = 1;                         // reinitialize count=1
                    res.insert(0,'-');      //  insert '-' before the next character
                    res.insert(0,cap);        //   insert next character. That is cap
                }
                else {
                    cnt++;
                    res.insert(0,cap);
                }
            }
        }

        return res.toString();
    }
}




class KeyFormatSolution3 {
    static String ReFormatString(String S, int K) {

        int count=0;
        String a="";

        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i)=='-')
                continue;

            if(count==K){
                a="-"+ a;
                count=0;
                a=Character.toUpperCase(S.charAt(i))+a;
                count++;
                continue;

            }

            else{
                a=Character.toUpperCase(S.charAt(i))+a;
            }
            count++;
        }

        return a;
    }

}
