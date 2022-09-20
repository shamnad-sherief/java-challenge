package excercise.array;

import java.util.Scanner;

public class ArrayPrint {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int []a= {1,4,5,6,7,8,9};

        for(int i=0;i<a.length;i++){
            System.out.println("Element at index "+ i +": "+a[i]);
        }
    }
}

