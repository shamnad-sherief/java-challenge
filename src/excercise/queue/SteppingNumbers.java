// A number is called a stepping number if all adjacent digits have an absolute difference of 1, e.g. '321' is a
// Stepping Number while 421 is not. Given two integers n and m, find the count of all the stepping numbers in the range [n, m].

// source:- https://practice.geeksforgeeks.org/problems/stepping-numberswrong-output1813/1
package excercise.queue;

import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumbers {
    public static void main(String[] args) {
       int n = 0;
       int m = 21;

       SteppingNumbersSolution s1 = new SteppingNumbersSolution();

        System.out.println(s1.steppingNumbers(n,m));
    }
}

class SteppingNumbersSolution{
    int bfs(int n, int m, int num) {
        int cnt = 0;
        Queue<Integer> q=new LinkedList<>();
        q.add(num);
        while (!q.isEmpty()) {
            int stepNum = q.poll();
            if (stepNum <= m && stepNum >= n)
                cnt++;
            if (num == 0 || stepNum > m)
                continue;
            int lastDigit = stepNum % 10;
            int stepNumA = stepNum * 10 + (lastDigit- 1);
            int stepNumB = stepNum * 10 + (lastDigit + 1);

            if (lastDigit != 9)
                q.add(stepNumB);
            if (lastDigit != 0)
                q.add(stepNumA);

        }
        return cnt;
    }

    int steppingNumbers(int n, int m) {
        int ans = 0;
        for (int i = 0 ; i <= 9 ; i++){
            ans +=	bfs(n, m, i);
        }
        return ans;
    }
}