//Given the base (in units) of a right-angled isoceles traingle,
//find the maximum number of 2X2 squares that can fit in the triangle with given base.

package excercise.basics;

import java.util.Scanner;

public class MaximumNumberOf2X2Squares {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MaximumNumberOf2X2SquaresSolution2 s2 = new MaximumNumberOf2X2SquaresSolution2();

        System.out.print("Enter base value: ");
        long base=input.nextLong();
        System.out.println(s2.numberOfSquares(base));
    }

}


class  MaximumNumberOf2X2SquaresSolution1{
    public static long numberOfSquares(long base)
    {
        long res=0;
        long n=1;
        if(base>3){
            for(int i=4;i<=base;i+=2){

                res=res+n;
                n++;
            }
        }
        return res;
    }
}




class  MaximumNumberOf2X2SquaresSolution2{
    public static long numberOfSquares(long base)
    {

        long res=0;
        long n=0;
        if(base>3){
            if(base%2!=0){
                base--;
            }
            n=base-((base/2)+1);
            res=(n*(n+1))/2;

        }

        return res;
    }
}