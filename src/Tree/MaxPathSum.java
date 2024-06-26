package Tree;

import com.sun.source.tree.Tree;

public class MaxPathSum
{
    TreeNode root;
    public class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int data)
        {
            this.val=data;
        }
    }
    public void creatTree(){
        TreeNode first=new TreeNode(10);
        TreeNode second=new TreeNode(20);
        TreeNode third=new TreeNode(30);
        TreeNode fourth=new TreeNode(40);
        TreeNode fifth=new TreeNode(50);

        root=first;
        first.left=second;
        first.right=third;   //second<--first-->third

        second.left=fourth;
        second.right=fifth; //fourth<--second-->fifth
    }
    public static void main(String[] args) {
        MaxPathSum bt=new MaxPathSum();
        bt.creatTree();
        System.out.println(bt.maxPathsum(bt.root));

    }
    public int maxPathsum(TreeNode root) {
        int diameter[]=new int[1];
        diameter[0]=Integer.MIN_VALUE;
        MaxSum(root,diameter);
        return diameter[0];
    }

    public static int MaxSum(TreeNode root,int []diameter)
    {
        if(root==null)
            return 0;

        int leftsum=Math.max(0,MaxSum(root.left,diameter));
        int rightsum=Math.max(0,MaxSum(root.right,diameter));

        diameter[0]=Math.max(diameter[0],root.val+leftsum+rightsum);

        return root.val+Math.max(leftsum,rightsum);
    }

}
