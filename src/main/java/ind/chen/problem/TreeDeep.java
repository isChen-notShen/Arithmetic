package ind.chen.problem;

/**
 * @author Mr.Chen
 **/
public abstract class TreeDeep {

    public static void main(String[] args) {
        TreeNode<Integer> node7 = new TreeNode<>(7, null, null);
        TreeNode<Integer> node6 = new TreeNode<>(6, node7, null);
        TreeNode<Integer> node5 = new TreeNode<>(5, null, null);
        TreeNode<Integer> node4 = new TreeNode<>(4, null, null);
        TreeNode<Integer> node3 = new TreeNode<>(3, node6, null);
        TreeNode<Integer> node2 = new TreeNode<>(2, node4, node5);
        TreeNode<Integer> node1 = new TreeNode<>(1, node2, node3);
        System.out.println(minDepth(node1));
    }

    public static <T> int minDepth(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null)
            return minDepth(root.right) + 1;
        else if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static class TreeNode<T> {

        public T value;

        public TreeNode<T> left;

        public TreeNode<T> right;

        public TreeNode() {
        }

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
