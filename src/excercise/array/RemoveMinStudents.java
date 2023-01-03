// N Students of different heights are attending an assembly. The heights of the students are represented by an array H[].
// The problem is that if a student has less or equal height than the student standing in front of him,
// then he/she cannot see the assembly. Find the minimum number of students to be removed such that maximum possible number of students can see the assembly.

// source:- https://practice.geeksforgeeks.org/problems/7d0fa4007b8eabadc404fcc9fa917aa52982aa96/1

package excercise.array;

import java.util.Arrays;

public class RemoveMinStudents {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int removeStudents(int[] H, int N) {

        int ans = N - lengthOfLIS(H);
        return ans;
    }


    public static void main(String[] args) {

        int N = 8;
        int[] H = {5, 8,  6, 3, 6, 1, 2, 2};

        RemoveMinStudents obj = new RemoveMinStudents();

        System.out.println(obj.removeStudents(H,N));
    }
}
