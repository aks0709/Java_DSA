package Tree;

import java.util.HashMap;

public class ConstructAUniqueBinaryTree
{
    public static void main(String[] args) {


    }
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

  //construct a unique BT from PreOrder and inOrder
  public TreeNode buildTree2(int[] preorder, int[] inorder) {
      HashMap<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<inorder.length;i++)
      {
          map.put(inorder[i],i);
      }
      TreeNode root=construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
      return root;
  }

    public TreeNode construct(int preorder[],int preStart,int preEnd,int inorder[],int inStart,int inEnd,HashMap<Integer,Integer> inorderMap)
    {
        if(preStart>preEnd||inStart>inEnd)
            return null;

        TreeNode root=new TreeNode(preorder[preStart]);

        int InOrderRootindex=inorderMap.get(root.val);
        int numsLeft=InOrderRootindex-inStart;

        root.left=construct(preorder,preStart+1,preStart+numsLeft,inorder,inStart,InOrderRootindex-1,inorderMap);
        root.right=construct(preorder,preStart+numsLeft+1,preEnd,inorder,InOrderRootindex+1,inEnd,inorderMap);

        return root;
    }

  //construct a unique BT from PostOrder and inOrder
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);

        }
        TreeNode res=Build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return res;
    }

    public TreeNode Build(int postorder[],int postStart,int postEnd,int [] inorder,int inStart,int inEnd,HashMap<Integer,Integer> inordermap)
    {
        if(postStart>postEnd||inStart>inEnd) return null;

        TreeNode root=new TreeNode(postorder[postEnd]);
        int inorderRootIndex=inordermap.get(root.val);
        int numsLeft=inorderRootIndex-inStart;

        root.left=Build(postorder,postStart,postStart+numsLeft-1,inorder,inStart,inorderRootIndex-1,inordermap);
        root.right=Build(postorder,postStart+numsLeft,postEnd-1,inorder,inorderRootIndex+1,inEnd,inordermap);

        return root;
    }


}
