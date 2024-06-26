package Tree;

public class MaxValueInBinaryTree
{
    TreeNode root;
    public static class TreeNode{
        private int data;
        private TreeNode Left;
        private TreeNode right;
        public TreeNode(int data)
        {
            this.data=data;
        }
    }

    public void createBinaryTree()
    {
        TreeNode first=new TreeNode(80);
        TreeNode sec=new TreeNode(20);
        TreeNode third=new TreeNode(90);
        TreeNode fourth=new TreeNode(140);
        TreeNode fifth=new TreeNode(50);
        TreeNode sixth=new TreeNode(6);

        root=first;
        first.Left=sec;
        first.right=third;
        sec.Left=fourth;
        sec.right=fifth;
        third.Left=sixth;
    }
    public static void main(String[] args) {

        MaxValueInBinaryTree bt=new MaxValueInBinaryTree();
        bt.createBinaryTree();
        System.out.println(bt.GetMax(bt.root));
    }
    public static int GetMax(TreeNode root)
    {
        if (root==null)
            return Integer.MIN_VALUE;

        int result=root.data;
        int left=GetMax(root.Left);
        int right=GetMax(root.right);

        if (left>result)
            result=left;
        if (right>result)
            result=right;

        return result;
    }
}
