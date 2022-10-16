// Given a array of N numbers, we need to maximize the sum of selected numbers. At each step, you need to select
// a number Ai, delete one occurrence of Ai-1 (if exists), and Ai each from the array. Repeat these steps until the array gets empty.
// The problem is to maximize the sum of the selected numbers.
// Note: Numbers need to be selected from maximum to minimum.

// source:- https://practice.geeksforgeeks.org/problems/maximize-the-sum-of-selected-numbers-from-an-array-to-make-it-empty0836/1


package excercise.array;

public class MaximizeSum {
    public static void main(String[] args) {

        int arr[ ] = {1, 2, 2, 2, 3, 4};
        int n = arr.length;

        MaximizeSumSolution s1 = new MaximizeSumSolution();

        System.out.println(s1.maximizeSum(arr,n));

    }
}

class MaximizeSumSolution {

    public static int maximizeSum(int arr[], int n) {

        int sum = 0;
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int freq[] = new int[max + 1];
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }
        for (int i = n - 1; i >= 0; i--) {
            int value = arr[i];
            if (freq[value] > 0) {
                sum += value;
                freq[value]--;
                freq[value - 1]--;
            }
        }
        return sum;
    }
}