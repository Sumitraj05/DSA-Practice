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
    public Node addTwoLists(Node head1, Node head2) {
        // code here
       while (head1 != null && head1.data == 0 && head1.next != null) head1 = head1.next;
       while (head2 != null && head2.data == 0 && head2.next != null) head2 = head2.next;
       head1 = rev(head1);
       head2 = rev(head2);
       Node dummy = new Node(0);
       Node curr = dummy;
       int carry = 0;
       while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            carry = sum / 10;          // e.g., 13 / 10 = 1
            curr.next = new Node(sum % 10); // e.g., 13 % 10 = 3
            curr = curr.next;
        }
       return rev(dummy.next);
    }
}
