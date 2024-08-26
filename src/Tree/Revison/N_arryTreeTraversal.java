package Tree.Revison;
import java.util.*;

public class N_arryTreeTraversal {

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> ans=new LinkedList<>();
            PostTraversal(ans,root);
            return ans;
        }

        static void PostTraversal(List<Integer> ans,Node root)
        {
            if(root==null)
                return ;

            for(Node n : root.children)
            {
                PostTraversal(ans,n);
            }
            ans.add(root.val);
        }
    }
}
