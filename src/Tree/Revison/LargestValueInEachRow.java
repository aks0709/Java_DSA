package Tree.Revison;

public class LargestValueInEachRow {
    /*
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
//        public List<Integer> largestValues(TreeNode root) {
//            List<Integer> ans=new ArrayList<>();
//            if(root==null)
//                return ans;
//            Queue<TreeNode> q=new LinkedList<>();
//            q.add(root);
//            while(!q.isEmpty()){
//                int len=q.size();
//                int maxi=Integer.MIN_VALUE;
//                while(len-->0){
//                    TreeNode top=q.poll();
//                    maxi=Math.max(maxi,top.val);
//                    if(top.left!=null) q.add(top.left);
//                    if(top.right!=null) q.add(top.right);
//                }
//                ans.add(maxi);
//            }
//            return ans;
//        }
//    }
}
