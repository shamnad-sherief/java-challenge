// Geek is extremely punctual but today even he is not feeling like doing his homework assignment. He must start doing it immediately in order
// to meet the deadline. For the assignment, Geek needs to type a string s.
// To reduce his workload, he has decided to perform one of the following two operations till he gets the string.
// Append a character at the end of the string.
// Append the string formed thus far to the end of the string. (This can not be done more than once.)

// source:- https://practice.geeksforgeeks.org/problems/95080eb9efbf7cc5cb4851ddf8d7946e3f212a49/1

package excercise.strings;

public class MinimumOperationString {

    public static void main(String[] args) {

        String s = "abcabca";

        MinimumOperationStringSolution obj = new MinimumOperationStringSolution();

        System.out.println(obj.minOperation(s));

    }
}

class MinimumOperationStringSolution {

    int minOperation(String s) {

        if(s.length()==1)return 1;

        int max=Integer.MIN_VALUE;

        String temp=s.charAt(0)+"";

        for(int i=1;i<s.length();i++){

            int k=i;
            int index=i;

            for(int j=0;j<temp.length();j++){

                if(k<s.length() && temp.charAt(j)==s.charAt(k)){
                    k++;
                    continue;
                }
                else{
                    break;
                }
            }
            max=Math.max(max,k-i);

            if(k-i==temp.length()){
                temp+=s.substring(i,k);
                i=k-1;

            }

            else{
                temp+=s.charAt(i);
            }
        }
        return s.length()-max+1;

    }

}
