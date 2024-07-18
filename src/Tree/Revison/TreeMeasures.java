package Tree.Revison;

public class TreeMeasures {
    public class TreeNode {
        int val;
        TreeTraversals.TreeNode left;
        TreeTraversals.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeTraversals.TreeNode left, TreeTraversals.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
   }

   //Max Dept or Height OF BT
//    public static int maxDepth(TreeNode root) {
//        if(root==null) return 0;
//        int l=maxDepth(root.left);
//        int r=maxDepth(root.right);
//
//        return 1+Math.max(l,r);
//    }

    //Height Balanced BT
    //TREE IS HEIGHT BALANCED IF ABS(LEFT HEIGHT - RIGHT HEIGHT) < 1
//    public boolean isBalanced(TreeNode root) {
//        return DFS(root)!=-1;
//    }
//
//    public static int DFS(TreeNode root){
//        if(root==null) return 0;
//        int lh=DFS(root.left);
//        int rh=DFS(root.right);
//        if(lh==-1||rh==-1)   //IF ANY HEIGHT is -1 THEN RETURN -1
//            return -1;
//
//        if(Math.abs(lh-rh)>1)
//            return -1;
//
//        return (1+Math.max(lh,rh));
//    }


}
