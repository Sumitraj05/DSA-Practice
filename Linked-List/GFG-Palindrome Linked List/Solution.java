/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node rev(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(Node head) {
        // code here
        int n = 0;
        Node temp = head;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        temp = rev(slow);
        while(head != null && temp != null){
            if(head.data != temp.data){
                return false;
            }
            head = head.next;
            temp = temp.next;
        }
        return true;
    }
}
