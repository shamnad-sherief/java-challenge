package excercise.matrix;

import java.util.Arrays;

public class MaximumProfitOnIntervals {
    public static void main(String[] args) {

        int n = 3;
        int[][] intervals = {
                {1, 2, 4},
                {1, 5, 7},
                {2, 4, 4}
        };

        MaximumProfitOnIntervalsSolution obj = new MaximumProfitOnIntervalsSolution();

        System.out.println(obj.maximum_profit(n,intervals));

    }
}



class MaximumProfitOnIntervalsSolution {
    public static int maximum_profit(int n, int[][] intervals) {

         Arrays.sort(intervals,(a, b) -> (a[0]-b[0]));
        int[] dp = new int[n];
        for(int i=n-1;i>=0;i--) {
            int idx = searchGreaterOrEqualTo(intervals,intervals[i][1]);
            if(idx>=dp.length) {
                dp[i]=intervals[i][2];
            } else {
                dp[i] = intervals[i][2]+dp[idx];
            }
            if(i!=n-1) dp[i] = Math.max(dp[i],dp[i+1]);
        }
        return dp[0];
    }

    public static int searchGreaterOrEqualTo(int[][] a,int val) {
        int lo=0,hi=a.length-1,ans=a.length;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid][0]<val) {
                lo=mid+1;
            } else {
                hi=mid-1;
                ans = Math.min(ans,mid);
            }
        }
        return ans;
    }
}
