// Given two numbers a and b. In one operation you can pick any non negative integer x and either of a or b.
// Now if you picked a then replace a with a&x else if you picked b then replace b with b&x. Return the minimum number of operation required to make a and b equal.

// source:- https://practice.geeksforgeeks.org/problems/5a7e1a52f1b7796238f9efea4c6fda389f26c327/1

package excercise.basics;

public class MinOperationToEqual {
    public static void main(String[] args) {

        int a = 5;
        int b = 12;

        MinOperationToEqualSolution obj = new MinOperationToEqualSolution();

        System.out.println(obj.solve(a,b));
    }
}


class MinOperationToEqualSolution {
    public static int solve(int a, int b) {

         if(a == b){
            return 0;
        }
        if((a&b) == a || (a&b) == b){
            return 1;
        }
        return 2;
    }
}
