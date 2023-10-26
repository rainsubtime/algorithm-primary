package class07;

public class Code03_PathSum {

    // 测试链接：https://leetcode.com/problems/path-sum
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSum = false;

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }

    public static void process(TreeNode x, int preSum, int sum) {

        int curSum = preSum + x.val;
        if(curSum == sum){
            if(x.right == null && x.left == null){
                isSum = true;
            }
            return;
        }
        if(x.left != null){
            process(x.left,curSum,sum);
        }
        if(x.right != null){
            process(x.right,curSum,sum);
        }
    }

//	public static boolean hasPathSum(TreeNode root, int sum) {
//		if (root == null) {
//			return false;
//		}
//		return process(root, sum);
//	}
//
//	public static boolean process(TreeNode root, int rest) {
//		if (root.left == null && root.right == null) {
//			return root.val == rest;
//		}
//		boolean ans = root.left != null ? process(root.left, rest - root.val) : false;
//		ans |= root.right != null ? process(root.right, rest - root.val) : false;
//		return ans;
//	}

}