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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            inorderMap.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inorderMap);
    }
    public TreeNode helper(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,
    Map<Integer,Integer> inorderMap) {
        if(preStart>preEnd || inStart > inEnd) return null;
        int rootval = preorder[preStart];
        TreeNode root = new TreeNode(rootval);
        int inIndex = inorderMap.get(rootval);
        int leftSize = inIndex-inStart;
        root.left = helper(preorder,preStart+1,preStart+leftSize,inorder,inStart,inIndex-1,inorderMap);
        root.right = helper(preorder,preStart+leftSize+1,preEnd,inorder,inIndex+1,inEnd,inorderMap);
        return root;
    }
}