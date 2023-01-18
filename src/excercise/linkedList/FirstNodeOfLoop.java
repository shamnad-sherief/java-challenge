// Given a singly linked list of N nodes. Find the first node of the loop if the linked list has a loop. If a loop is present return
// the node data of the first node of the loop else return -1.

// source:- https://practice.geeksforgeeks.org/problems/44bb5287b98797782162ffe3d2201621f6343a4b/1

package excercise.linkedList;

public class FirstNodeOfLoop {
    public static void main(String[] args) {

        FirstNodeOfLoopNode head = new FirstNodeOfLoopNode(1);
        FirstNodeOfLoopNode second = new FirstNodeOfLoopNode(2);
        FirstNodeOfLoopNode third = new FirstNodeOfLoopNode(3);
        FirstNodeOfLoopNode fourth = new FirstNodeOfLoopNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;


        FirstNodeOfLoopSolution obj = new FirstNodeOfLoopSolution();
        int data = obj.findFirstNode(head);
        System.out.println(data);
    }
}


class FirstNodeOfLoopSolution {
    public int findFirstNode(FirstNodeOfLoopNode head){
        if(head == null) return -1;
        FirstNodeOfLoopNode fast = head;
        FirstNodeOfLoopNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) break;
        }
        if(fast != slow) return -1;

        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }
}


class FirstNodeOfLoopNode       // node
{
    int data;
    FirstNodeOfLoopNode next;

    FirstNodeOfLoopNode(int x)
    {
        data = x;
        next = null;
    }
}
