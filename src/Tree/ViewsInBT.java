package Tree;

import java.util.*;

public class ViewsInBT
{
    static class TreeNode {
        int data;
         TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static class Pair{
        int vertical;
        TreeNode node;
        public Pair(TreeNode node,int vertical){
            this.vertical=vertical;
            this.node=node;
        }

    }
    public static void main(String[] args) {
        TreeNode first=new TreeNode(1);
        TreeNode sec=new TreeNode(2);
        TreeNode third=new TreeNode(3);
        TreeNode fourth=new TreeNode(4);
        TreeNode fifth=new TreeNode(5);
        TreeNode sixth=new TreeNode(6);
        TreeNode seventh=new TreeNode(7);
        first.left=sec;
        first.right=third;
        sec.left=fourth;
        sec.right=fifth;
        fifth.left=sixth;
        third.right=seventh;

        List<Integer> topview=new ArrayList<>();
        topview=TopView(first);
        System.out.println(topview);

        List<Integer> bottomview=new ArrayList<>();
        bottomview= BottomView(first);
        System.out.println(bottomview);

        List<Integer> rsv=new ArrayList<>();
        rsv=rightSideView(first);
        System.out.println(rsv);



    }

    public static List<Integer> TopView(TreeNode root)
    {
        List<Integer> ans=new LinkedList<>();
        if (root==null)
            return ans;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(root,0));
        while (!q.isEmpty())
        {
            Pair it=q.remove();
            TreeNode node=it.node;
            int Vertical=it.vertical;

            if(map.get(Vertical)==null) map.put(Vertical,node.data);

            if(node.left!=null)
            {
                q.add(new Pair(node.left,Vertical-1));
            }

            if(node.right!=null)
            {
                q.add(new Pair(node.right,Vertical+1));
            }


        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;



    }
    public static List<Integer> BottomView(TreeNode root)
    {
        List<Integer> ans=new LinkedList<>();
        if (root==null)
            return ans;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(root,0));
        while (!q.isEmpty())
        {
            Pair it=q.remove();
            TreeNode node=it.node;
            int Vertical=it.vertical;

             map.put(Vertical,node.data);  //it keeps on updating value if already exsist so in end of level order
            //traversal we simply  get the last nodes on each verticals

            if(node.left!=null)
            {
                q.add(new Pair(node.left,Vertical-1));
            }

            if(node.right!=null)
            {
                q.add(new Pair(node.right,Vertical+1));
            }


        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new LinkedList<>();
        RSV(root,0,ans);

        return ans;
    }

    public static void RSV(TreeNode Curr,int CurrLevel,List<Integer> ans)
    {
        if(Curr==null)
            return;

        if(CurrLevel==ans.size())
        {
            ans.add(Curr.data);
        }
        RSV(Curr.right,CurrLevel+1,ans);
        RSV(Curr.left,CurrLevel+1,ans);
    }

}
