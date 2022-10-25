// Given a matrix as 2D array. Find the reverse spiral traversal of the matrix.

package excercise.matrix;

import java.util.Arrays;

public class ReverseSpiral {
    public static void main(String[] args) {
        int R = 3;
        int C = 3;
        int[][] a = {{9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}};

        ReverseSpiralSolution s1 = new ReverseSpiralSolution();

        System.out.println(Arrays.toString(s1.reverseSpiral(R,C,a)));
    }
}


class ReverseSpiralSolution {
    public int[] reverseSpiral(int R, int C, int[][] a) {
         int[] ans=new int[R*C];
        int idx=R*C-1;

        int up=0;
        int down=a.length-1;
        int left=0;
        int right=a[0].length-1;



        while(idx>=0){
            //upper row
            for(int i=left;i<=right && idx>=0;i++){
                ans[idx--]=a[up][i];
            }
            up++;

            //last col
            for(int i=up;i<=down && idx>=0;i++){
                ans[idx--]=a[i][right];
            }
            right--;

            //lower row
            for(int i=right;i>=left && idx>=0;i--){
                ans[idx--]=a[down][i];
            }
            down--;

            for(int i=down;i>=up && idx>=0;i--){
                ans[idx--]=a[i][left];
            }
            left++;
        }

        return ans;

    }
}