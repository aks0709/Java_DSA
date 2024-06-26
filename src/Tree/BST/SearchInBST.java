package Tree.BST;

public class SearchInBST
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

    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null&&root.val!=val)
        {
            if(val<root.val)
                root=root.left;  //since value is less go to left subtree
            else
                root=root.right;  //since value is greater go to right subtree
        }

        return root;  //we break out of loop either by root=null or val=root.val in either case return root

    }
    static int ceil=-1;
    public static int Ceil(TreeNode root,int key)  //find value of node which is just greater or equal to key
    {
        while (root!=null)
        {
            if(root.val==key)  //if this condition happen we simply return ceil
            {
             ceil= root.val;
             return ceil;
            }

            if(key> root.val)
            {
                root=root.right;  //if key is greater then obviously it lie in Right sub tree
            }
            else {
                ceil=root.val;  //we take current node and got to lST to find more closer value
                root=root.left;  //if key is less than root.val then it lie in Left sub tree
                //suppose our root node is 10 and key is 8 since 8<10 therefore key lies in LST ceil=10;
                //but there is a chance for exsistance of value 8,9 in LST  which are just greater than equal to key
                //there fore search in LST,in RST we got every value greater than root
            }
        }
        return ceil;
    }

    int floor=-1;
    public int findFloor(TreeNode root,int key)  //find value of node which is just smaller or equal to key
    {
        while (root!=null)
        {
            if(root.val==key)  //simply we got the node return it
            {
                floor=root.val;
                return floor;
            }

            if(key>root.val)  
            {
                floor=root.val;
                root=root.right;
            }
            else
            {
                root=root.left;
            }
        }
        return floor;
    }

}
