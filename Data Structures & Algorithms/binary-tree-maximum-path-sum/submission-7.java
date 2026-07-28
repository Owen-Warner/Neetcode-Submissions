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
    static int bigNode = -1001;

    public static int maxPathSum(TreeNode root){
        bigNode = -1001;
        int lSum = Math.max(sideSum(root.left), 0);
        int rSum = Math.max(sideSum(root.right), 0);
        if((lSum + rSum + root.val) > bigNode){
            bigNode = lSum + rSum + root.val;
        }
        return bigNode;
    }

    public static int sideSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        else{
            int left = sideSum(root.left);
            int right = sideSum(root.right);
            int leftClamped = Math.max(left, 0);
            int rightClamped = Math.max(right, 0);
            if((root.val + leftClamped + rightClamped) > bigNode){
                bigNode = root.val + leftClamped + rightClamped;
            }
            int best = Math.max(left, right);
            if (best <= 0) {
                return root.val;
            } else {
                return root.val + best;
            }
        }
    }
}
