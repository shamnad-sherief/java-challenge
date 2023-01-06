// You are given two four digit prime numbers Num1 and Num2. Find the distance of the shortest path from Num1 to Num2
// that can be attained by altering only one single digit at a time. Every number obtained after changing a digit should be a
// four digit prime number with no leading zeros.

// source:- https://practice.geeksforgeeks.org/problems/1646a9b5169d7571cf672f2a31533af083d1f479/1

package excercise.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToPrime {
    public static void main(String[] args) {
        int Num1 = 1033;
        int Num2 = 8179;

        ShortestPathToPrimeSolution obj = new ShortestPathToPrimeSolution();

        System.out.println(obj.shortestPath(Num1,Num2));
    }
}


class ShortestPathToPrimeSolution
{
    boolean[] prime;
    ShortestPathToPrimeSolution()
    {
        prime =new boolean[10000];
        Arrays.fill(prime,true);
        prime[0]=prime[1]=false;
        for(int i=2;i<1000;i++){
            if(!prime[i])continue;
            for(int j=2;i*j<10000;j++)prime[i*j]=false;
        }
        for(int i=0;i<1000;i++)prime[i]=false;
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one mea
    }

    public int shortestPath(int Num1,int Num2){
        // Complete this function using prime array
        boolean[]vis=new boolean[10000];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{Num1,0});
        vis[Num1]=true;
        while(!q.isEmpty()){
            int[] curr=q.remove();
            if(curr[0]==Num2)return curr[1];

            char[] arr= Integer.toString(curr[0]).toCharArray();
            for(int i=0;i<4;i++){
                for(char ch='0';ch<='9';ch++){
                    char prevChar = arr[i];
                    arr[i]=ch;
                    int newNum = Integer.parseInt(new String(arr));
                    if(!vis[newNum] && prime[newNum] && newNum>=1000){
                        vis[newNum]=true;
                        q.add(new int[]{newNum,curr[1]+1});
                    }
                    arr[i]=prevChar;
                }
            }
        }
        return -1;
    }
}