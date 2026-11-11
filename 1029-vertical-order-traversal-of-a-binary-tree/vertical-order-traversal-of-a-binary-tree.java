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
    private class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node,int row,int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<int[]>> colMap = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root,0,0));
        while(!queue.isEmpty()) {
            Tuple current = queue.poll();
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;
            colMap.putIfAbsent(col, new ArrayList<>());
            colMap.get(col).add(new int[]{row,node.val});
            if(node.left != null) queue.offer(new Tuple(node.left,row+1,col-1));
            if(node.right != null) queue.offer(new Tuple(node.right,row+1,col+1));
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int col : colMap.keySet()) {
            List<int[]> list = colMap.get(col);
            list.sort((a,b) -> {
                if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            });
            List<Integer> sorted =  new ArrayList<>();
            for(int[] val: list) {
                sorted.add(val[1]);
            }
            result.add(sorted);
        }
        return result;
    }
}