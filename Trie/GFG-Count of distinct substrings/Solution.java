class Solution {
    
    public static class Node{
        Node[] children = new Node[26];
        boolean eow;
        public Node(){
            for(int i = 0; i<26; i++){
                children[i] = null;
            }
        }

    }
    
    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }


        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count+= countNodes(root.children[i]);
            }
        }
        return 1+count; //extra one for the self node
    }
    
    public static int countSubs(String s) {
        // code here
        Node root = new Node();  // Fresh trie for each call
        
        // Insert all suffixes
        for(int i = 0; i < s.length(); i++) {
            Node curr = root;
            for(int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';
                if(curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
        }
        
        return countNodes(root) - 1;
        
    }
}
