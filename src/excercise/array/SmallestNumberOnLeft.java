//Given an array a of integers of length n,
//find the nearest smaller number for every element
//such that the smaller element is on left side.
//If no small element present on the left print -1.



package excercise.array;
import java.util.ArrayList;
import  java.util.List;
import java.util.Stack;

public class SmallestNumberOnLeft {

    public static  void main(String[] args) {

        int[] a={1,5,2,7,0,4,3};
        int n= a.length;

        SmallestNumberOnLeftSolution1 s1= new SmallestNumberOnLeftSolution1();
        System.out.println(s1.leftSmaller(n,a));

//        SmallestNumberOnLeftSolution2 s2= new SmallestNumberOnLeftSolution2();
//        System.out.println(s1.leftSmaller(n,a));

    }
}


    class SmallestNumberOnLeftSolution1{
        static List<Integer> leftSmaller(int n, int a[]) {


            ArrayList<Integer> list = new ArrayList<Integer>();
            int min= -1;
            list.add(min);
            for(int i=1;i<n;i++){
                min= -1;
                innerloop:
                for(int j=(i-1);j>=0;j--){
                    if(a[i]>a[j]){
                        min=a[j];
                        break innerloop;
                    }
                }
                list.add(min);
            }

            return list;
        }

    }



class SmallestNumberOnLeftSolution2{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        List<Integer> arr=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                arr.add(-1);
                st.push(a[i]);
            }else{
                while(!st.isEmpty() && st.peek()>=a[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    arr.add(-1);
                }else{
                    arr.add(st.peek());
                }
                st.push(a[i]);
            }
        }
        return arr;
    }
}
