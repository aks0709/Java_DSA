package Tree.Revison;

public class LongestUnivaluePath {
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
//        public int longestUnivaluePath(TreeNode root) {
//            int res[]=new int[1];
//            helper(root,res);
//            return res[0];
//        }
//
//        public static int helper(TreeNode root,int res[]){
//            if(root==null) return 0;
//
//            //Post-Order Traversal
//            int lh=helper(root.left,res);
//            int rh=helper(root.right,res);
//
//            //for every node we calculate it
//            int Lpath=0;
//            int Rpath=0;
//
//            //check for left subtree
//            if(root.left!=null && root.left.val==root.val)
//                Lpath+=lh+1;
//
//            //check for right subtree
//            if(root.right!=null && root.right.val==root.val)
//                Rpath+=rh+1;
//
//            res[0]=Math.max(res[0],Lpath+Rpath);  //current maximum path achived
//
//            return Math.max(Lpath,Rpath);//moving forward, we only choose one max(frequency count high) path to move ahed
//
//        }
//    }
}
