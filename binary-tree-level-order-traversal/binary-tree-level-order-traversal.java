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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> result = new LinkedList();
        if(root == null){
          return new LinkedList();
        }

        queue.add(root);
        while(!queue.isEmpty()){
            int sizeOfQueue = queue.size();
            List<Integer> listOfheads = new LinkedList();
            for(int i=0;i<sizeOfQueue;i++){
              TreeNode node = queue.remove();
              listOfheads.add(node.val);
              if(node.left != null){
                  queue.add(node.left);
              }
                  
              if(node.right != null)
              {
                  queue.add(node.right);
                }
            }
            result.add(listOfheads);
        }
        return result;
    }
}