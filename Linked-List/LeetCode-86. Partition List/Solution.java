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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode p1 = small;
        ListNode p2 = large;
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                p1.next = temp;
                p1 = p1.next;
            }else{
                p2.next = temp;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        p1.next = large.next;
        p2.next = null;
        return small.next;
    }
}
