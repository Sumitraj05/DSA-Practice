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
    TreeNode groot;
    public TreeNode lca(TreeNode groot, TreeNode left, TreeNode right){
        if(groot == null) return null;
        if(groot == left || groot == right) return groot;
        TreeNode leftN = lca(groot.left, left, right);
        TreeNode rightN = lca(groot.right, left, right);
        if(leftN != null && rightN != null) return groot;
        if(leftN != null) return leftN;
        return rightN;
    }

    public TreeNode solve(TreeNode root, int h, int idx){
        if(root == null){
            return null;
        }
        if(idx == h){
            return root;
        }
        TreeNode left = solve(root.left, h, idx+1);
        TreeNode right = solve(root.right, h, idx+1);
        return lca(groot, left, right);
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        groot = root;
        int h = height(root);
        return solve(root, h, 1);
    }
}
