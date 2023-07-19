/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=head;
        ListNode head1=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode next1=null;
        ListNode prev1=null;
        ListNode current=slow;
        while(current!=null){
            next1=current.next;
            current.next=prev1;
            prev1=current;
            current=next1;
        }
        slow=prev1;
        while(head1!=null && slow!=null){
            if(head1.val!=slow.val){
                return false;
            }
            head1=head1.next;
            slow=slow.next;
        }
        return true;
        
    }
}
