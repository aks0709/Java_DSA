package Tree;
//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class MaxDepthOfBinarySearch
{
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
        first.right=third;

        third.right=fourth;
        fourth.left=fifth;
    }
    public static void main(String[] args) {

        MaxDepthOfBinarySearch bt=new MaxDepthOfBinarySearch();
        bt.createBT();
        System.out.println(bt.MaxDepth(bt.root));
    }

    public int MaxDepth(TreeNode root)
    {
        if (root==null)
            return 0;

        int lh=MaxDepth(root.left);
        int rh=MaxDepth(root.right);

        return (1+Math.max(lh,rh));
    }
}
