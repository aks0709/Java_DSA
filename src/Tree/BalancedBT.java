package Tree;
//https://leetcode.com/problems/balanced-binary-tree/submissions/867692002/
public class BalancedBT
{
    //A Binary tree is balanced if Height of left subtree- height of right ssubtree<=1
    TreeNode root;
    public class TreeNode{
        private  int data;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int data)
        {
            this.data=data;
        }
    }

    public void createBT()
    {
        TreeNode first=new TreeNode(13);
        TreeNode second=new TreeNode(14);
        TreeNode third=new TreeNode(11);
        TreeNode fourth=new TreeNode(17);
        TreeNode fifth=new TreeNode(12);

        root=first;
        first.left=second;
        second.right=third;

        third.right=fourth;
        fourth.left=fifth;
    }

    public boolean isBalanced(TreeNode root) {
        return DFS(root)!=-1;
    }
    public static int DFS(TreeNode root)
    {
        if(root==null)
            return 0;

        int lh=DFS(root.left);
        if(lh==-1)
            return -1;

        int rh=DFS(root.right);
        if(rh==-1)
            return -1;

        if(Math.abs(lh-rh)>1)
            return -1;

        return (Math.max(lh,rh)+1);
    }

    public static void main(String[] args) {
        BalancedBT bt=new BalancedBT();
        System.out.println(  bt.isBalanced(bt.root));

    }
}
