package excercise.array;


import java.util.Scanner;

public class ArrayInsert {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int []a=new int[5];
        System.out.println("Enter values: ");
        for(int i=0;i<a.length;i++){
            a[i]=input.nextInt();
        }

        for(int i=0;i<a.length;i++){
            System.out.println("Element at index "+ i +": "+a[i]);
        }

    }
}
