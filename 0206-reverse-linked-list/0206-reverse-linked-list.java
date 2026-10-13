class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev,current,nextnode;
        prev=null;
        current=head;   
        while(current!=null){
            nextnode=current.next;
            current.next=prev;
            prev=current;
            current=nextnode;
        }
        head=prev;
        return head;   
    }
}