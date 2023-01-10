// Given a Binary Tree of size N , where each node can have positive or negative values. Convert this to a tree
// where value of each node will be the sum of the values of all the nodes in left and right sub trees of the original tree.
// The values of leaf nodes are changed to 0.

// source:- https://practice.geeksforgeeks.org/problems/d7e0ce338b11f0be36877d9c35cc8dfad6636957/1

package excercise.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;




class SumTreeNode {
    int data;
    SumTreeNode left;
    SumTreeNode right;
    SumTreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class SumTree {

    static SumTreeNode buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        SumTreeNode root = new SumTreeNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<SumTreeNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            SumTreeNode currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new SumTreeNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new SumTreeNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(SumTreeNode root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            SumTreeNode root = buildTree(s);
            SumTreeSolution ob = new SumTreeSolution();
            ob.toSumTree(root);
            printInorder(root);
            System.out.println();
            t--;

        }
    }

}



class SumTreeSolution {
    int helper(SumTreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            int leaf = root.data;
            root.data = 0;
            return leaf;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        int curr = root.data;
        root.data = left + right;
        return root.data+curr;
    }
    public void toSumTree(SumTreeNode root){

        if(root==null) return ;
        helper(root);
    }
}