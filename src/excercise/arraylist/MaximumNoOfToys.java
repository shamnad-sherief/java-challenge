// You are given N toys in a shop . The cost of each toy is represented by an array A[]. You are given Q queries, For ith query,
// You have a C amount of money which you can use to purchase the toys. Also there are K broken toys and you won't purchase them.
// The task is to calculate the maximum number of toys you can purchase using the C amount of money.

// source:- https://practice.geeksforgeeks.org/problems/maximum-number-of-toys/1

package excercise.arraylist;

import java.util.ArrayList;

public class MaximumNoOfToys {
    public static void main(String[] args) {

        int N = 5;
        int A[] = {8, 6, 9, 2, 5};
        int Q = 2;



        ArrayList<Integer>[] Queries = new ArrayList[2];

        ArrayList<Integer> innerList1 = new ArrayList<Integer>();
        innerList1.add(12);
        innerList1.add(2);
        innerList1.add(3);
        innerList1.add(4);
        Queries[0] = innerList1;

        ArrayList<Integer> innerList2 = new ArrayList<Integer>();
        innerList2.add(30);
        innerList2.add(0);
        Queries[1] = innerList2;



        MaximumNoOfToysSolution obj = new MaximumNoOfToysSolution();

        System.out.println(obj.maximumToys(N,A,Q,Queries));

    }


}

class MaximumNoOfToysSolution {
        int[] freq;

        static class FenwikTree{
            int N;
            long bit[];
            public FenwikTree(int N){
                this.N = N;
                bit = new long[N];
            }

            void add(int node, int v){
                for(;node<N;node+=(node&(-node)))
                    bit[node]+=v;
            }

            long get(int node){
                long x = 0l;
                for(;node>0;node-=(node&(-node)))
                    x+=bit[node];
                return x;
            }
        }

        ArrayList<Integer> maximumToys(int n, int arr[], int Q, ArrayList<Integer> queries[]){

            freq=new int[1000001];

            for(int i=0;i<n;i++){
                freq[arr[i]]++;
            }

            FenwikTree f1= new FenwikTree(1000001);

            FenwikTree f2= new FenwikTree(1000001);

            for(int i=0;i<n;i++){
                f1.add(arr[i],arr[i]);
                f2.add(arr[i],1);
            }

            ArrayList<Integer> res=new ArrayList<>();

            for(int q=0;q<Q;q++){

                long cost=queries[q].get(0);
                int k=queries[q].get(1);

                for(int i=0;i<k;i++){
                    int ind=queries[q].get(i+2)-1;

                    f1.add(arr[ind],-arr[ind]);
                    f2.add(arr[ind],-1);

                }

                int lo=1,hi=1000000;
                int pos=1000000;

                while(lo<=hi){
                    int mid=lo+(hi-lo)/2;
                    if(f1.get(mid)>=cost){
                        pos=mid;
                        hi=mid-1;
                    }
                    else{
                        lo=mid+1;
                    }
                }

                int mx=(int)f2.get(pos-1);
                mx+=Math.min((cost-f1.get(pos-1))/pos,(long)freq[pos]);
                res.add(mx);


                for(int i=0;i<k;i++){
                    int ind=queries[q].get(i+2)-1;

                    f1.add(arr[ind],arr[ind]);
                    f2.add(arr[ind],1);

                }

            }

            return res;


        }


}