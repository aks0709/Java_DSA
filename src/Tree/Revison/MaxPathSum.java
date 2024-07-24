package Tree.Revison;

public class MaxPathSum {
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
//        public int maxPathSum(TreeNode root) {
//            int diameter[]=new int[1];
//            diameter[0]=Integer.MIN_VALUE;
//            height(root,diameter);
//            return diameter[0];
//        }
//
//        public static int height(TreeNode root,int []diameter)
//        {
//            if(root==null)
//                return 0;
//
      // we apply max at each node becoz we do not consider negative path as it decrease our ans
//            int lh=Math.max(0,height(root.left,diameter));  //
//            int rh=Math.max(0,height(root.right,diameter));
//
//            diameter[0]=Math.max(diameter[0],root.val+lh+rh);  //apply this at every node(umbrella figure)
//             //our ans is getting store in diameter[0]
//            return root.val+Math.max(lh,rh);   (to get max Path)
//        }
//    }
}
