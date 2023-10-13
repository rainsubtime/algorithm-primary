package class06;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class06
 * @Author: cywork
 * @CreateTime: 2023-10-09  18:25
 * @Description: TODO
 * @Version: 1.0
 */
public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2){
        //baseCase 1
        if(L1 > R1){
            return null;
        }
        //baseCase 2
        if(L1 == R1){
            return new TreeNode(pre[L1]);
        }

        TreeNode treeNode = new TreeNode(pre[L1]);
        int find = L2;
        while(in[find] != pre[L1]){
            find ++;
        }

        treeNode.left = f(pre,L1 + 1, L1 + find - L2, in , L2 ,find - 1);
        treeNode.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1,R2 );

        return treeNode;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode node = buildTree(pre, in);
        System.out.println(node.right.left.val);

    }
}
