// You are given the head of a Linked List. You have to move the last element to the front of the Linked List and return the list.

// source:- https://practice.geeksforgeeks.org/problems/move-last-element-to-front-of-a-linked-list/1

package excercise.linkedList;

class LastElementToFront{
    public static NodeLastElementToFront moveToFront(NodeLastElementToFront head) {
        if(head.next==null)
            return head;
        NodeLastElementToFront tmp1=head,tmp2=head.next;
        while(tmp2.next != null){
            tmp1=tmp1.next;
            tmp2=tmp2.next;
        }
        tmp2.next = head;
        tmp1.next = null;
        return tmp2;
    }

}


class NodeLastElementToFront {
    int data;
    NodeLastElementToFront next;

    NodeLastElementToFront(int x){
        data = x;
        next = null;
    }
}