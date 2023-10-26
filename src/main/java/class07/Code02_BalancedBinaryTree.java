package class07;

// 测试链接：https://leetcode.com/problems/balanced-binary-tree
public class Code02_BalancedBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        boolean isBalanced;
        int height;

        Info(boolean a,int b) {
            this.isBalanced = a;
            this.height = b;
        };

    }

    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public static Info process(TreeNode root) {
        if(root == null){
            return new Info(true,0);
        }

        Info left = process(root.left);
        Info right = process(root.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;

        return new Info(isBalanced,height);

    }

}
