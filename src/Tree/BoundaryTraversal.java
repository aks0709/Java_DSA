package Tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal
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
    static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    public static void AddLeftBoundary(TreeNode root, List<Integer> ans)
    {
        TreeNode current=root.left;
        while (current!=null)
        {
            if (isLeaf(current))
            {
                ans.add(current.val);
            }
            if (current.left!=null)
            {
                current=current.left;
            }
            else {
                current=current.right;
            }
        }

    }
    static void addRightBoundary(TreeNode root, ArrayList< Integer > res) {
        TreeNode cur = root.right;
        ArrayList < Integer > tmp = new ArrayList < Integer > ();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.val);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));  //add right boundary in reverse order
        }
    }
    static void addLeaves(TreeNode root, ArrayList < Integer > res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        //simple Inorder traversal reach to leaves
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    static ArrayList < Integer > printBoundary(TreeNode node) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        if (isLeaf(node) == false) ans.add(node.val);
        AddLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }

}
