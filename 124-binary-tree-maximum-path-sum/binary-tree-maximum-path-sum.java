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
    public int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum =Integer.MIN_VALUE;
        calc(root);
        return maxSum;
    }
    public int calc(TreeNode root) {
        if(root==null) return 0;
        int left= Math.max(0,calc(root.left));
        int right = Math.max(0,calc(root.right));
        int curr = root.val +left+right;
        maxSum = Math.max(maxSum,curr);
        return root.val+Math.max(left,right);
    }
}