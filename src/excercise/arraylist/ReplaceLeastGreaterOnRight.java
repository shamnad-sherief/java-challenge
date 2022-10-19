// Given an array arr[] of N integers and replace every element with the least greater element on its right side in the array.
// If there are no greater elements on the right side, replace it with -1.

// https://practice.geeksforgeeks.org/problems/replace-every-element-with-the-least-greater-element-on-its-right/1


package excercise.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class ReplaceLeastGreaterOnRight {
    public static void main(String[] args) {

        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        int n = arr.length;

        ReplaceLeastGreaterOnRightSolution s1 = new ReplaceLeastGreaterOnRightSolution();

        System.out.println(s1.findLeastGreater(n,arr));

    }
}


class ReplaceLeastGreaterOnRightSolution {

    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = n-1; i >= 0; i--){
            set.add(arr[i]);
            if(set.higher(arr[i]) == null) list.add(-1);
            else list.add(set.higher(arr[i]));
        }
        Collections.reverse(list);
        return list;
    }
}
