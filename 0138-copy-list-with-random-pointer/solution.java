/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;

        Node curr=head;
        while(curr!=null){
            Node copy=new Node(curr.val);
            copy.next=curr.next;
            curr.next=copy;
            curr=copy.next;
        }

        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        Node originalCurr = head;
        Node copyHead =head.next;
        Node copyCurr =copyHead;
        while(originalCurr != null){
            originalCurr.next=originalCurr.next.next;
            copyCurr.next=(copyCurr.next!=null)? copyCurr.next.next: null;
            originalCurr=originalCurr.next;
            copyCurr=copyCurr.next;
        }
        return copyHead;
    }
}
