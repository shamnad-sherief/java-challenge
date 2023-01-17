package excercise.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumGCDofSiblings {
    public static void main(String[] args) {

//          class Node
//            {
//                int data;
//                Node left, right;
//
//                Node(int item)
//                {
//                    data = item;
//                    left = right = null;
//                }
//            }
//

        Node root = new Node(4);
        root.left = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(3);
        root.right.right = new Node(1);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(12);

        MaximumGCDofSiblingsSolution obj = new MaximumGCDofSiblingsSolution();

        System.out.println(obj.maxGCD(root));
    }
}



class MaximumGCDofSiblingsSolution {

    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    int maxGCD(Node root) {
        if(root==null)
            return 0;
        int ans=0;
        int max=0;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();

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