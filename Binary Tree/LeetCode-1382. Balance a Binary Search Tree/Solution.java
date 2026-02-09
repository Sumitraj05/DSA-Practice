/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode root, ArrayList<Integer> vec){
        if(root == null){
            return;
        }
        inorder(root.left, vec);
        vec.add(root.val);
        inorder(root.right, vec);
    }
    public TreeNode construct(int left, int right, ArrayList<Integer> vec){
        if(left>right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(vec.get(mid));
        root.left = construct(left, mid-1, vec);
        root.right = construct(mid+1, right, vec);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> vec = new ArrayList<>();
        inorder(root, vec);
        int left = 0;
        int right = vec.size()-1;
        return construct(left, right, vec);
    }
}
