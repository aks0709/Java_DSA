package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths
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
    public static void main(String[] args) {

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        String res="";
        path(root,res,ans);
        return ans;
    }

    void path(TreeNode root, String ans,List<String> list) {
        if(root==null) return;
        ans=ans+root.val;

        if(root.left==null && root.right==null){
            list.add(ans);
            return;
        }

        ans=ans+"->";
        path(root.left,ans,list);
        path(root.right,ans,list);
    }
}
