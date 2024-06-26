package Tree.BST;

import java.util.ArrayList;
import java.util.List;

public class kthSmallest
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans=new ArrayList<>();
        kthSmallest2(root,k,ans);
        int res=ans.get(k-1);
        return res;
    }
    public void kthSmallest2(TreeNode root, int k,List<Integer> ans) {
        if(root==null)
            return;

        kthSmallest2(root.left,k,ans);
        ans.add(root.val);
        kthSmallest2(root.right,k,ans);
    }
}
