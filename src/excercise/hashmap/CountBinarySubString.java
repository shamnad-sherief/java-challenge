// Given a binary string S consists only of 0s and 1s. The task is to calculate the number of substrings that have more 1s than 0s.

//source:- https://practice.geeksforgeeks.org/problems/f72994353d123b925ff20f0694b662191df03ea2/1

package excercise.hashmap;

import java.util.HashMap;

public class CountBinarySubString {
    public static void main(String[] args) {

        String S = "011";

        CountBinarySubStringSolution obj = new CountBinarySubStringSolution();

        System.out.println(obj.countSubstring(S));

    }
}

class CountBinarySubStringSolution {

    long countSubstring(String S){
            long res=0;

            HashMap<Long,Integer> map=new HashMap<>();

            long[] dp=new long[S.length()];

            long sum=-1;

            if(S.charAt(0)=='1'){

                dp[0]=1;

                res=1;

                sum=1;

            }

            map.put(sum,0);

            map.put((long) 0,-1);

            for(int i=1;i<S.length();i++){

                long temp=0;

                if(S.charAt(i)=='0'){

                    sum-=1;

                }

                else{

                    sum+=1;

                }

                if(S.charAt(i)=='0'){

                    if(map.containsKey(sum)){

                        if(map.get(sum)!=-1){

                            temp+=dp[map.get(sum)];
                        }
                    }
                }
                else{
                    if(map.containsKey(sum)){

                        if(map.get(sum)!=-1){

                            temp=temp+dp[map.get(sum)]+i-map.get(sum)-1;
                        }

                        else{

                            temp=temp+i-map.get(sum)-1;
                        }

                    }

                    else{

                        temp+=i+1;

                    }
                }

                map.put(sum,i);
                dp[i]=temp;
                res+=temp;
            }

            return res;
        }

}