// source:- https://www.codechef.com/submit/CABS

package excercise.basics;

import java.util.Scanner;

public class CabProblem {

    public static void main (String[] args) throws java.lang.Exception {

        Scanner input = new Scanner(System.in);

        int t=input.nextInt();

        while(t>0){
            int X = input.nextInt();
            int Y = input.nextInt();


            if(X==Y){
                System.out.println("ANY");
            }

            else if(X>Y){
                System.out.println("FIRST");
            }

            else {
                System.out.println("SECOND");
            }
            t--;
        }
    }
}
