package Tree.Revison;

public class BoundaryTraversal {
//
//    class Solution {
//        ArrayList<Integer> boundary(Node node) {
//            ArrayList<Integer> res = new ArrayList<>();
//
//            if (node == null) {
//                return res;
//            }
//
//            res.add(node.data); // Add root node
//
//            // Get the left boundary in top-down manner, except the leaf nodes
//            addLeftBoundary(node.left, res);
//
//            // Get all leaf nodes
//            addLeaves(node.left, res);
//            addLeaves(node.right, res);
//
//            // Get the right boundary in bottom-up manner, except the leaf nodes
//            addRightBoundary(node.right, res);
//
//            return res;
//        }
//
//        private void addLeftBoundary(Node node, ArrayList<Integer> res) {
//            Node curr = node;
//            while (curr != null) {
//                if (curr.left != null || curr.right != null) {
//                    res.add(curr.data);
//                }
//                if (curr.left != null) {
//                    curr = curr.left;
//                } else {
//                    curr = curr.right;
//                }
//            }
//        }
//
//        private void addLeaves(Node node, ArrayList<Integer> res) {
//            if (node == null) {
//                return;
//            }
//            if (node.left == null && node.right == null) {
//                res.add(node.data);
//                return;
//            }
//            addLeaves(node.left, res);
//            addLeaves(node.right, res);
//        }
//
//        private void addRightBoundary(Node node, ArrayList<Integer> res) {
//            Node curr = node;
//            Stack<Integer> stack = new Stack<>();
//            while (curr != null) {
//                if (curr.left != null || curr.right != null) {
//                    stack.push(curr.data);
//                }
//                if (curr.right != null) {
//                    curr = curr.right;
//                } else {
//                    curr = curr.left;
//                }
//            }
//            while (!stack.isEmpty()) {
//                res.add(stack.pop());
//            }
//        }
//    }

}
