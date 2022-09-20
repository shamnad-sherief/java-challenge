package excercise.array;


//Given an array arr[] of N integers.
//Find the contiguous sub-array(containing at least one number)
//which has the minimum sum and return its sum.

//arr[] = {3,-4, 2,-3,-1, 7,-5}
//Output: -6

//sum among all the sub-array is {-4,2,-3,-1} = -6

 class Solution1 {
    static int smallestSumSubarray(int a[], int size)
    {
        // your code here

        int min_ending_here = Integer.MAX_VALUE;


        int min_so_far = Integer.MAX_VALUE;

        for (int i=0; i<size; i++)
        {

            if (min_ending_here > 0)
                min_ending_here = a[i];


            else
                min_ending_here += a[i];


            min_so_far = Math.min(min_so_far, min_ending_here);
        }


        return min_so_far;
    }


}


class Solution2 {
    static int smallestSumSubarray(int a[], int size)
    {
        // your code here

        int min = a[size-1];


        for(int i=0;i<size;i++){
            int sum =0;

            for(int j=i;j<size;j++){

                sum=sum+a[j];

                if(sum<min){
                    min=sum;
                }


            }

        }

        return min;
    }
}

public class SmallestSumContigArray{
    public static void main(String[] args) {
        int[] arr={6,4,7,-2,1,5};
        int size = arr.length;

        System.out.println(Solution1.smallestSumSubarray(arr,size));
       // System.out.println(Solution2.smallestSumSubarray(arr,size));
    }
}
