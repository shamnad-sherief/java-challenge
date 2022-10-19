// source https://www.codechef.com/submit/VOLCONTROL

package excercise.basics;

import java.util.Scanner;

public class VolumeControl {
        public static void main (String[] args) throws java.lang.Exception {

            Scanner input = new Scanner(System.in);

            int t = input.nextInt();


            while(t > 0){

                int X = input.nextInt();
                int Y = input.nextInt();

                if(X > Y){
                    int temp = X;
                    X = Y;
                    Y = temp;
                }

                System.out.println(Y - X);

                t--;
            }
        }

    }

