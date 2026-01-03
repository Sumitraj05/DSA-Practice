

// User function Template for Java

class Solution {
    // Function to flatten a linked list
    Node merge(Node temp1, Node temp2){
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp1 != null && temp2 != null){
            if(temp1.data <= temp2.data){
                res.bottom = temp1;
                temp1 = temp1.bottom;
            }else{
                res.bottom = temp2;
                temp2 = temp2.bottom;
            }
            res.next = null;
            res = res.bottom;
        }
        if(temp1 != null){
            res.bottom = temp1;
            res = res.bottom;
        }
        else{
            res.bottom = temp2;
            res = res.bottom;
        }
        return dummy.bottom;
    }
    Node flatten(Node root) {
        if(root == null || root.next == null){
            return root;
        }
        Node l1 = flatten(root.next);
        return merge(l1, root);
        }
}
