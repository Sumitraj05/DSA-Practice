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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            n += 1;
            temp = temp.next;
        }
        k = k%n;
        int a = n-k;
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        temp = head;
        while(a-- > 1){
            temp = temp.next;
        }
        ListNode first = temp.next;
        ListNode ans = first;
        temp.next = null;
        while(first.next != null){
            first = first.next;
        }
        first.next = head;
        return ans;
    }
}
