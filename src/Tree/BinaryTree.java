package Tree;

import com.sun.source.tree.Tree;
import jdk.dynalink.linker.LinkerServices;

import java.util.*;

public class BinaryTree {
    TreeNode root;
    public static class TreeNode{
        private int data;
        private TreeNode left;
        private  TreeNode right;

        public TreeNode(int data){
            this.data=data;
        }
    }

    public void creatTree(){
        TreeNode first=new TreeNode(10);
        TreeNode second=new TreeNode(20);
        TreeNode third=new TreeNode(30);
        TreeNode fourth=new TreeNode(40);
        TreeNode fifth=new TreeNode(50);

        root=first;
        first.left=second;
        first.right=third;   //second<--first-->third

        second.left=fourth;
        second.right=fifth; //fourth<--second-->fifth
    }

    public void preOrderTraversal(TreeNode root)
    {
        if (root==null)
            return; //base case

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void iterativePreOrder()
    {

        if (root==null)  //base condition
            return;
        Stack<TreeNode> stack=new Stack<>();  //we create stack of type TreeNode
        stack.push(root);  //we push RootNode of tree
        while (!stack.isEmpty())
        {
            TreeNode temp=stack.pop();
            System.out.print(temp.data+" ");

            //we first push right child then left child because stack is lifo Data structure so,left child is evaluated
            //first then right child(preorder)

            if (temp.right!=null)
            {
                stack.push(temp.right);

            }
            if (temp.left!=null)
            {
                stack.push(temp.left);
            }

        }


    }

    public void InorderTraversal(TreeNode root)
    {
        if (root==null)//base case
        {
            return;
        }

        InorderTraversal(root.left);
        System.out.print(root.data+" ");
        InorderTraversal(root.right);
    }

    public void IterativeInOrderTraversal()
    {
        if (root==null)//that means there is no node
            return;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while (!stack.isEmpty()||temp!=null)
        {
            if (temp!=null) //we keep going to left subtree until temp==null
            {
                stack.push(temp);
                temp=temp.left;
            }
            else
            {
                temp=stack.pop();  //according to if condition ,this line execute when temp==null so we temp =stack.pop()
                System.out.print(temp.data+" ");  //it means successfully traversed left subtree now visit node
                temp=temp.right;  //now move to right subtree
            }
        }
    }
    public void PostOrderTraversal(TreeNode root)
    {
        if (root==null)
            return;

        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public void IterativePostOrderTraversal()
    {
        if (root==null)  //means there is no node
            return;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        while (current!=null||!stack.isEmpty())
        {
            if (current!=null)
            {
                stack.push(current);  //we push current if it is not equal to null
                current=current.left;  // we try to traverse left subtree
            }
            else //it met when current ==null //eiter right subtree or left subtree
            {
                TreeNode temp=stack.peek().right;   //when we already traverse left subtree now we need to traverse right subtree
                if (temp==null)  //it means right subtree is null so we now visit node
                {
                    temp=stack.pop();  //we need to check this temp is left or right subtree
                    System.out.print(temp.data+" ");
                    while (!stack.isEmpty()&&temp==stack.peek().right) //if you dry you will get to know about this condition,(rightmost right subtree)
                    {
                        temp=stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else {
                    current=temp;
                }

            }
        }
    }

    public void LevelOrderTraversal(TreeNode root)//traversing level by level from level 0 to end level
    {
        if (root==null)
            return;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode temp=queue.remove();
            System.out.print(temp.data+" ");
            if (temp.left!=null)
            {
                queue.add(temp.left);
            }
            if (temp.right!=null)
            {
                queue.add(temp.right);
            }
        }
    }
    public List<List<Integer>> BFS(TreeNode root)
    {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> ans=new LinkedList<>();
        if(root==null)
            return ans;

        queue.add(root);
        while (!queue.isEmpty())
        {
            int levelSize=queue.size();
            List<Integer> levelElements=new LinkedList<>();
            for (int i=0;i<levelSize;i++)
            {
                TreeNode temp=queue.remove();
                levelElements.add(temp.data);
                if (temp.left!=null) { queue.add(temp.left);}
                if (temp.right!=null){ queue.add(temp.right);}
            }
            ans.add(levelElements);
        }

        return ans;
    }



    public static void main(String[] args) {
        BinaryTree bt =new BinaryTree();
        bt.creatTree();
        bt.preOrderTraversal(bt.root);
        System.out.println("\n");
        bt.iterativePreOrder();
        System.out.println("\n");
        bt.InorderTraversal(bt.root);
        System.out.println("\n");
        bt.IterativeInOrderTraversal();
        System.out.println("\n");
        bt.PostOrderTraversal(bt.root);
        System.out.println("\n");
        bt.IterativePostOrderTraversal();
        System.out.println("\n\nLevelOrder Traversal:-");
        bt.LevelOrderTraversal(bt.root);
        System.out.println("\n\nLevelOrder Traversal Listwise:-");
        System.out.println(bt.BFS(bt.root));
    }
}
