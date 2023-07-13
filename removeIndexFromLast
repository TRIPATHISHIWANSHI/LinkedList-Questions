// 19. Remove Nth Node From End of List

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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        ListNode cur = head;
        int count = 0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        int index = count-n;

        cur = head;
        if(head.next==null && index==0)return null;
        if(head.next!=null && index==0){
            head=head.next;
            return head;
        }
        int count1 =1;
        while(cur!=null && cur.next != null){
            if(count1 != index){
                cur=cur.next;
                ++count1;
            }
            if(count1 == index){
                cur.next = cur.next.next;
                break;
            }
        }
        return head;
    }
}
