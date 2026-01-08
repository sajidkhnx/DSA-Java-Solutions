public class Btreeleetcode {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static long maxProduct = 0;
    static long totalSum = 0;

    // First DFS to get total sum
    public static long getTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }

    // Second DFS to compute max product
    public static long subtreeSum(TreeNode root) {
        if (root == null) return 0;

        long left = subtreeSum(root.left);
        long right = subtreeSum(root.right);

        long currentSum = left + right + root.val;

        long product = currentSum * (totalSum - currentSum);
        maxProduct = Math.max(maxProduct, product);

        return currentSum;
    }

    public static int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        subtreeSum(root);
        return (int) (maxProduct % 1_000_000_007);
    }

    public static void main(String[] args) {

        // Leaf nodes
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        // Level 2 nodes
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, null, node6);

        // Root node
        TreeNode root = new TreeNode(1, node2, node3);

        System.out.println(maxProduct(root)); // ✅ Correct output
    }
}
