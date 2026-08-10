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
    int inx = 0;
    int ksmall=0;
    public int kthSmallest(TreeNode root, int k) {
         hepler(root,k);
         return ksmall;
    }
    private void hepler(TreeNode root,int k){
        if(root== null) return;
        hepler(root.left,k);
        inx++;
        if(inx==k){
            ksmall = root.val;
            
        }
        hepler(root.right,k);
    }
    
}