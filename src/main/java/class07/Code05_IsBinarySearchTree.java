package class07;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class07
 * @Author: cywork
 * @CreateTime: 2023-10-20  18:29
 * @Description: TODO
 * @Version: 1.0
 */
public class Code05_IsBinarySearchTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int ma, int mi) {
            isBST = is;
            max = ma;
            min = mi;
        }
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info rightInfo = process(x.right);
        Info leftInfo = process(x.left);

        int max = x.val;
        int min = x.val;
        if (x.left != null) {
            min = leftInfo.min < min ? leftInfo.min : min;
        }
        if(x.right != null){
            max = rightInfo.max > max ? rightInfo.max : max;
        }
        boolean isBST = true;
        if( rightInfo != null && !rightInfo.isBST){
            isBST = false;
        }
        if( leftInfo != null && !leftInfo.isBST){
            isBST = false;
        }

        boolean isLeftBST = leftInfo == null ? true : leftInfo.max < x.val;
        boolean isRightBST = rightInfo == null ? true : rightInfo.min > x.val;

        if(!isLeftBST || !isRightBST){
            isBST = false;
        }

        return new Info(isBST,max,min);
    }

}
