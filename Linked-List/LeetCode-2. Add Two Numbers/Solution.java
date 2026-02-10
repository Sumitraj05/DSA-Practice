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
    public ListNode addTwoNumbers(ListNode first, ListNode second) {
         int carry = 0;
         ListNode dummy = new ListNode(100);
         ListNode temp  = dummy;
         while(first != null && second != null){
            int sum = first.val+second.val+carry;
            carry = 0;
            if(sum > 9){
                carry += 1;
                sum = sum%10;
            }
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = temp.next;
            first = first.next;
            second = second.next;
         }
         while(first != null){
            int sum = first.val+carry;
            carry = 0;
            if(sum > 9){
                carry += 1;
                sum = sum%10;
            }
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = temp.next;
            first = first.next;
         }
          while(second != null){
            int sum = second.val+carry;
            carry = 0;
            if(sum > 9){
                carry += 1;
                sum = sum%10;
            }
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = temp.next;
            second = second.next;
         }
         if(carry > 0){
            ListNode node = new ListNode(carry);
            temp.next = node;
            temp = temp.next;
         }
         return dummy.next;
    }
}
