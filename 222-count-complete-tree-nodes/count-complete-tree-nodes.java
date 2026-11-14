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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftHeight =countLeft(root);
        int rightHeight = countRight(root);
        if(leftHeight == rightHeight) return (1<<leftHeight) -1;
        else return countNodes(root.left) + countNodes(root.right) +1;
    }
    public int countLeft(TreeNode root) {
        int length=0;
        while(root != null) {
            length++;
            root=root.left;
        }
        return length;
    }
    public int countRight(TreeNode root) {
        int length=0;
        while(root != null) {
            length++;
            root=root.right;
        }
        return length;
    }
}