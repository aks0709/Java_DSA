package Tree.Revison;

public class SymmTree {
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
//    class Solution {
//        public boolean isSymmetric(TreeNode root) {
//            return ((root==null)||helper(root.left,root.right));
//        }
//        public boolean helper(TreeNode leftNode,TreeNode rightNode){
//            //base case
//            if(leftNode==null||rightNode==null)
//                return leftNode==rightNode;
//
//            if(leftNode.val!=rightNode.val)  return false;
//
//            return helper(leftNode.left,rightNode.right)&&helper(leftNode.right,rightNode.left);
//
//        }
//    }
}
