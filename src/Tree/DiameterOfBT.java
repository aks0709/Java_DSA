package Tree;

public class DiameterOfBT
{
    public static void main(String[] args) {
        DiameterOfBT bt=new DiameterOfBT();
        bt.createBT();
        System.out.println(bt.diameterOfBinaryTree(bt.root));

    }

        TreeNode root;
          public class TreeNode {
              private int data;
              private TreeNode left;
              private TreeNode right;

            public TreeNode(int data) {
                this.data = data;
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
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[]=new int[1];
        height(root,diameter);
        return diameter[0];
    }

    public static int height(TreeNode root,int []diameter)
    {
        if(root==null)
            return 0;

        int lh=height(root.left,diameter);
        int rh=height(root.right,diameter);

        diameter[0]=Math.max(diameter[0],lh+rh);

        return 1+Math.max(lh,rh);
    }

}
