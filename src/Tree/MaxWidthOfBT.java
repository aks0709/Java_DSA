package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBT
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

  class pair{
        TreeNode node;
        int num;
        pair(TreeNode node,int num)
        {
            this.node=node;
            this.num=num;
        }
  }

  public int widthOfBT(TreeNode root)
  {
      if(root==null)  return 0;  //it means zero width
      Queue<pair> q=new LinkedList<>();  //queue of type pair
      int ans=0;  //variable used to store width

      q.add(new pair(root,0));  //we offer queue ,the root with 0 index

      while (!q.isEmpty())
      {
          int first=0;
          int last=0;
          int size=q.size();
          int min=q.peek().num;
          for (int i=0;i<size;i++)
          {
              int CurrIndex=q.peek().num-min;
              TreeNode node=q.peek().node;
              q.remove();

              if(i==0) first=CurrIndex;
              if(i==size-1)  last=CurrIndex;

              if(node.left!=null )  q.add(new pair(node.left,2*CurrIndex+1));
              if(node.right!=null)  q.add(new pair(node.right,2*CurrIndex+2));
          }
          ans=Math.max(ans,last-first+1);

      }
      return ans;
  }
}
