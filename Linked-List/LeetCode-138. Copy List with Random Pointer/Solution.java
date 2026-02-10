/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node deepCopy = new Node(head.val);
        Node temp = deepCopy;
        Node h = head.next;
        map.put(head, temp);
        while(h!=null){
           Node node = new Node(h.val);
           temp.next = node;
           temp = temp.next;
           map.put(h, temp);
           h = h.next;
        }
        h = head;
        temp = deepCopy;
        while(h != null){
           temp.random = map.get(h.random);
           temp = temp.next;
           h = h.next;
        }
        return deepCopy;
    }
}
