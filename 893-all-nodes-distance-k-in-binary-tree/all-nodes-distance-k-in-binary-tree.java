/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void populate(TreeNode node,TreeNode parent, Map<TreeNode,TreeNode> parentMap) {
        if(node==null) return;
        if(parent != null) parentMap.put(node,parent);
        populate(node.left,node,parentMap);
        populate(node.right,node,parentMap);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        populate(root,null,parentMap);
        int distance =0;
        while(!queue.isEmpty()) {
            if(distance==k) {
                while(!queue.isEmpty()) {
                    result.add(queue.poll().val);
                }
                return result;
            }
            int size=queue.size();
            for(int i=0;i<size;i++) {
                TreeNode current = queue.poll();
                if(current.left !=null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.offer(current.left);
                }
                if(current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.offer(current.right);
                }
                TreeNode parent = parentMap.get(current);
                if(parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
            distance++;
        }
        return result;
    }
}