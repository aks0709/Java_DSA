package Tree.BST;

public class ConstructBSTFromPreorder
{
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode bstFromPreorder(int[] preorder,int upbound,int[] i) {
        if(i[0]==preorder.length||preorder[i[0]]>upbound)
            return null;

        TreeNode root=new TreeNode(preorder[i[0]++]);
        root.left=bstFromPreorder(preorder,root.val,i);
        root.right=bstFromPreorder(preorder,upbound,i);
        return root;
    }
}
