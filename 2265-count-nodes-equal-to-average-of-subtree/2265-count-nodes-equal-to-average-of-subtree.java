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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
        
    }
    int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] leftpart = helper(root.left);
        int[] rightpart = helper(root.right);

        int sum = leftpart[0] + rightpart[0]+ root.val;
        int count = leftpart[1]+rightpart[1]+1;
        if(root.val == sum/count){
            ans++;
        }
        return new int[]{sum,count};
        
    }
}