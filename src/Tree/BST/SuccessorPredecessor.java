package Tree.BST;

public class SuccessorPredecessor
{
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode Successor(TreeNode root,TreeNode p)
    {
        TreeNode successor=null;
        while(root!=null)
        {
            if(p.val>=root.val) //it means we cant find successor in left go to right
                root=root.right;
            else {
                //we get bigger node than p
                successor = root; //make it successor and check further
                root = root.left;
            }
        }
        return successor;
    }

    public TreeNode Predecessor(TreeNode root,TreeNode p)
    {
        TreeNode predecessor=null;
        while(root!=null)
        {
            if(p.val>=root.val)
            {
                predecessor=root;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return predecessor;
    }

}
