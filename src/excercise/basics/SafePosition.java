//There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed.
// The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction (clockwise).
// In each step, a certain number of people are skipped and the next person is executed.
// The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed),
// until only the last person remains, who is given freedom.
//Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle.
// The task is to choose the place in the initial circle so that you are the last one remaining and so survive.

// source:- https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1


package excercise.basics;

import java.util.ArrayList;
import java.util.List;

public class SafePosition{
    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        SafePositionSolution1 s1= new SafePositionSolution1();
//      SafePositionSolution2 s2= new SafePositionSolution2();

        System.out.println(s1.safePos(n,k));
//      System.out.println(s2.safePos(n,k));


    }
}


class SafePositionSolution1{
    static int safePos(int n, int k) {
        // code here
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<n+1;i++){
            list.add(i);
        }
        int index=0;
        k--;
        while(list.size()!=1){
            index = (index+k)%list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}

class SafePositionSolution2{
    static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        else
        /* The position returned by josephus(n - 1, k) is adjusted because the
           recursive call josephus(n - 1, k) considers the original position
           k%n + 1 as position 1 */
            return (josephus(n - 1, k) + k-1) % n + 1;
    }

    static int safePos(int n, int k) {

        return josephus(n,k);
    }
}
