package Tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/submissions/879451611/
public class PathSum2
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();

        Paths(root,targetSum,ans,list,0);
        return ans;

    }
    public static void Paths(TreeNode root,int targetSum,List<List<Integer>> ans,List<Integer> list,int sum)
    {
     //edgeCase
        if (root == null)
            return;

        list.add(root.val);
        sum=sum+root.val;

        //BaseCase
        if (sum==targetSum&& root.left==null && root.right==null)
        {
            ans.add(new ArrayList<>(list));
        }

        //RecursiveCalls
        Paths(root.left, targetSum,ans,list,sum);
        Paths(root.right, targetSum,ans,list,sum);

        //BackTrack
        list.remove(list.size() - 1);
        sum=sum-root.val;
    }
}
