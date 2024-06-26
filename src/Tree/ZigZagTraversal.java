package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> ans=new LinkedList<>();

        if(root==null)
            return ans;

        queue.add(root);

        boolean flag=true;
        while(!queue.isEmpty())
        {
            int LevelSize=queue.size();
            List<Integer> LevelElements=new LinkedList<>();


            for(int i=0;i<LevelSize;i++)
            {
                TreeNode temp =queue.remove();

                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);

                if(flag==true) {
                    LevelElements.add(temp.val);
                }
                else
                {
                    LevelElements.add(0,temp.val);
                }

            }

            flag=!flag;
            ans.add(LevelElements);
        }
        return ans;
    }
}
