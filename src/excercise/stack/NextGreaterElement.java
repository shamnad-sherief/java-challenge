// Given an array arr[ ] of size n having distinct elements, the task is to find the next greater element for each element
//  of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest
//  element on the right which is greater than the current element. If there does not exist next greater of current element,
//  then next greater element for current element is -1. For example, next greater of the last element is always -1.

// source:- https://practice.geeksforgeeks.org/problems/214734e358208c1c6811d9b237b518f6b3c3c094/1

package excercise.stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int n = 4;
        long[] arr = {1, 3, 2, 4};

        NextGreaterElementSolution obj = new NextGreaterElementSolution();

        long[] result = obj.nextLargerElement(arr,n);
        for(int i=0;i<result.length;i++)
            System.out.print(result[i]+" ");

    }
}

class NextGreaterElementSolution {
    public static long[] nextLargerElement(long[] arr, int n) {

         long[] ans = new long[n];
        Stack<Long> stack = new Stack<>();

        for(int i=n-1;i>=0;i--) {
            while(stack.size()>0 && stack.peek()<=arr[i]) {
                stack.pop();
            }
            if(stack.size()==0) {
                ans[i]=-1;
            } else {
                ans[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }
}
