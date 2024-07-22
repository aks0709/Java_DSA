package Tree.Revison;

public class SecondMiniNodeInBT {
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
//        public static void DFS(TreeNode root, int[] res,HashSet<Integer> set) {
//            if (root == null) return;
//            set.add(root.val);
//            if (root.val < res[0]) {
//                res[1] = res[0];
//                res[0] = root.val;
//            } else if (root.val > res[0] && root.val < res[1]) {
//                res[1] = root.val;
//            }
//
//            DFS(root.left, res,set);
//            DFS(root.right, res,set);
//        }
//
//        public int findSecondMinimumValue(TreeNode root) {
//            if (root == null) return -1;
//
//            int[] res = new int[2];
//            res[0] = Integer.MAX_VALUE;
//            res[1] = Integer.MAX_VALUE;
//            HashSet<Integer> set=new HashSet<>();
//            DFS(root, res,set);
//            //edge case
//            if(set.size()==2){
//                Integer[] array = set.toArray(new Integer[0]);
//                if(array[0]!=array[1])
//                    return Math.max(array[0], array[1]);
//            }
//
//            return res[1] == Integer.MAX_VALUE ? -1 : res[1];
//        }
//    }


/*++++++++++++++++++++++EDGE CASE HANDLED WITH SUCCESS+++++++++++++++++++++++++++++++++++++*/
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
//        public static void DFS(TreeNode root, int[] res) {
//            if (root == null) return;
//            if (root.val < res[0]) {
//                res[1] = res[0];
//                res[0] = root.val;
//            } else if (root.val > res[0] && root.val<=res[1]) {  //this equals is for edge case mentioned below
//                res[1] = root.val;
//                res[2]=1;
//            }
//
//            DFS(root.left, res);
//            DFS(root.right, res);
//        }
//
//        public int findSecondMinimumValue(TreeNode root) {
//            if (root == null) return -1;
//
//            int[] res = new int[3];
//            res[0] = Integer.MAX_VALUE;
//            res[1] = Integer.MAX_VALUE;
//            res[2]=0;  //for edge case when root node value equal to Integer.max
//            //so in that case res[1]=Integer.maxvalue but we do a if check that res[1]=max value return -1
//
//            //therefore res[2] is flag which determines value of res[1] changes or not in that case ,the value of res[1] only changes if second smallest element exsist hence flag changes
//            DFS(root, res);
//
//            return (res[1] == Integer.MAX_VALUE && res[2]==0) ? -1 : res[1];
//        }
//    }

}
