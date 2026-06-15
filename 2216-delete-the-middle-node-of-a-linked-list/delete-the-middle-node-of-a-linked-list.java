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
    public ListNode deleteMiddle(ListNode head) {
        int count=0;
        ListNode temp=head;
        if(head==null || head.next==null){
            return null;
        }
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int mid=count/2;
        temp=head;
        int cnt=0;
        while(cnt<mid-1){
            temp=temp.next;
            cnt++;
        }
        temp.next=temp.next.next;
        return head;

        
    }
}