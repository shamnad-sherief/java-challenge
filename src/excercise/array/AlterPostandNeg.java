package excercise.array;

import java.util.ArrayList;
import java.util.Arrays;

public class AlterPostandNeg {

    public static void main(String[] args) {

    int[] arr={9,-4,1,7,6,-2,-5};


                ArrayList<Integer> neg = new ArrayList<Integer>();
                ArrayList<Integer> pos = new ArrayList<Integer>();

                for (int i = 0; i < arr.length; i++) {

                    if (arr[i] < 0)
                        neg.add(arr[i]);
                    else
                        pos.add(arr[i]);
                }

                int i = 0, j = 0, k = 0;
                while (i < neg.size() && j < pos.size()) {
                    arr[k++] = pos.get(j++);
                    arr[k++] = neg.get(i++);
                }
                while (j < pos.size()) { arr[k++] = pos.get(j++); }

                while (i < neg.size()) { arr[k++] = neg.get(i++); }

        System.out.println(Arrays.toString(arr));
            }
}



