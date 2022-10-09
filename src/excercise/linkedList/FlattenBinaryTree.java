// Given the root of a binary tree, flatten the tree into a "linked list":
// The "linked list" should use the same Node class where the right child pointer points to the next  node
// in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.
// source:- https://practice.geeksforgeeks.org/problems/flatten-binary-tree-to-linked-list/1

package excercise.linkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

class FlattenBinaryTreeSolution {
    public void flatten(Node root) {

        if(root == null)return;
        flatten(root.left);
        Node righty = root.right;
        root.right = root.left;
        root.left = null;
        flatten(righty);
        Node temp = root;

        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = righty;
    }
}


class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class FlattenBinaryTree {

    static Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
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
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException{

            String s = "123456";
            Node root = buildTree(s);
            FlattenBinaryTreeSolution ob=new FlattenBinaryTreeSolution();
            ob.flatten(root);
            printInorder(root);
            System.out.println();


        }
    }



