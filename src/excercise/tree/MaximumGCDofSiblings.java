package excercise.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumGCDofSiblings {
    public static void main(String[] args) {

//          class LargestValueNode
//            {
//                int data;
//                LargestValueNode left, right;
//
//                LargestValueNode(int item)
//                {
//                    data = item;
//                    left = right = null;
//                }
//            }
//

        LargestValueNode root = new LargestValueNode(4);
        root.left = new LargestValueNode(5);
        root.right = new LargestValueNode(2);
        root.right.left = new LargestValueNode(3);
        root.right.right = new LargestValueNode(1);
        root.right.left.left = new LargestValueNode(6);
        root.right.left.right = new LargestValueNode(12);

        MaximumGCDofSiblingsSolution obj = new MaximumGCDofSiblingsSolution();

        System.out.println(obj.maxGCD(root));
    }
}



class MaximumGCDofSiblingsSolution {

    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    int maxGCD(LargestValueNode root) {
        if(root==null)
            return 0;
        int ans=0;
        int max=0;
        Queue<LargestValueNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            LargestValueNode temp=q.poll();

            if(temp.left!=null && temp.right!=null){
                int d=gcd(temp.left.data,temp.right.data);
                if(d>=max){
                    ans=temp.data;
                    max=d;
                }
                q.add(temp.left);
                q.add(temp.right);
            }
            if(temp.left!=null && temp.right==null)
                q.add(temp.left);
            if(temp.left==null && temp.right!=null)
                q.add(temp.right);
        }
        return ans;
    }
}