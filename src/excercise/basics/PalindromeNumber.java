package excercise.basics;

import java.util.Scanner;

class Solution {
    public boolean isPalindrome(int x) {
        int num = x;    //storing the value of x to num
        int res = 0;

        while(x!=0){
            res = (res*10) + x%10;
            x = x/10;

        }

        if(res==num && num>=0)
            return true;
        else
            return false;
    }
}

public class PalindromeNumber {

    public static void main(String[] args) {
        Solution solution= new Solution();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = input.nextInt();
        System.out.println(solution.isPalindrome(x));


    }
}

