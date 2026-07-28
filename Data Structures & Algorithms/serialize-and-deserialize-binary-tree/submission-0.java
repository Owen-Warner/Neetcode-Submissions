/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "!";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return dWorker(nodes);
    }

    private TreeNode dWorker(Deque<String> nodes) {
        String val = nodes.poll();
        if (val.equals("!")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dWorker(nodes);
        node.right = dWorker(nodes);
        return node;
    }
}
