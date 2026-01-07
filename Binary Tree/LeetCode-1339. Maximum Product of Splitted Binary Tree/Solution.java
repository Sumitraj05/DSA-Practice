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
    long Product = 0;
    public long dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        long left = dfs(root.left);
        long right = dfs(root.right);
        return root.val+left+right;
    }

    public long ProductDFS(TreeNode root, long TotalSum, long sum){
        if(root == null){
            return 0;
        }
        long left = ProductDFS(root.left, TotalSum, sum);
        long right = ProductDFS(root.right, TotalSum, sum);
        sum = root.val+left+right;
        Product = Math.max(Product, (sum*(TotalSum-sum)));
        return sum;
    }
    public int maxProduct(TreeNode root) {
        long TotalSum = 0;
        TotalSum = dfs(root);
        ProductDFS(root, TotalSum, 0);
        return (int) (Product%1000000007);
    }
}
