// Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked-list is in sorted order.
// Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
// Note: The flattened list will be printed using the bottom pointer instead of next pointer.

// source:- https://practice.geeksforgeeks.org/problems/da62a798bca208c7a678c133569c3dc7f5b73500/1

package excercise.linkedList;

import java.util.Scanner;

class FlattenLinkedListNode
{
    int data;
    FlattenLinkedListNode next;
    FlattenLinkedListNode bottom;

    FlattenLinkedListNode(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}


public class FlattenLinkedList {
    FlattenLinkedListNode head;

    void printList(FlattenLinkedListNode node)
    {
        //FlattenLinkedListNode temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
    public  static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        FlattenLinkedList list = new FlattenLinkedList();
        while(t>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0;i<N;i++)
                arr[i] = sc.nextInt();

            FlattenLinkedListNode temp = null;
            FlattenLinkedListNode tempB = null;
            FlattenLinkedListNode pre = null;
            FlattenLinkedListNode preB = null;
            int flag=1;
            int flag1=1;
            for(int i=0; i<N;i++)
            {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new FlattenLinkedListNode(a1);
                if(flag == 1)
                {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                }
                else
                {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for(int j=0;j<m;j++)
                {
                    int a = sc.nextInt();
                    tempB = new FlattenLinkedListNode(a);
                    if(flag1 == 1)
                    {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    }
                    else
                    {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            //list.printList();
            FlattenLinkedListSolution g = new FlattenLinkedListSolution();
            FlattenLinkedListNode root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}
class FlattenLinkedListSolution{
    FlattenLinkedListNode flatten(FlattenLinkedListNode root){
        if(root == null || root.next == null)
            return root;
        root.next = flatten(root.next);
        root = together(root,root.next);

        return root;
    }
    FlattenLinkedListNode together(FlattenLinkedListNode a, FlattenLinkedListNode b){
        FlattenLinkedListNode temp = new FlattenLinkedListNode(0);
        FlattenLinkedListNode newNode = temp;

        while(a!= null && b!= null){
            if(a.data<=b.data){
                temp.bottom = a;
                a=a.bottom;
                temp= temp.bottom;
            }else {
                temp.bottom = b;
                b = b.bottom;
                temp=temp.bottom;
            }
        }
        if(a!= null){
            temp.bottom = a;
        }else{
            temp.bottom = b;
        }
        return newNode.bottom;
    }
}