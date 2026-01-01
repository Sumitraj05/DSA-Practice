/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        int n1 = 0;
        int n2 = 0;
        Node temp = head1;
        while(temp != null){
            n1++;
            temp = temp.next;
        }
        temp = head2;
        while(temp != null){
            n2++;
            temp = temp.next;
        }
        if(n1 >= n2){
            n1 = n1-n2;
            temp = head1;
            while(n1 > 0){
                temp = temp.next;
                n1--;
            }
            while(temp != head2){
                temp = temp.next;
                head2 = head2.next;
            }
        }else{
            n2 = n2-n1;
            temp = head2;
            while(n2 > 0){
                temp = temp.next;
                n2--;
            }
            while(temp != head1){
                temp = temp.next;
                head1 = head1.next;
            }
        }
        return temp;
    }
}
