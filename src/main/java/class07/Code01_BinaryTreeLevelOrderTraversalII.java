package class07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsProject: arithmatic
 * @BelongsPackage: class07
 * @Author: cywork
 * @CreateTime: 2023-10-20  16:37
 * @Description: TODO
 * @Version: 1.0
 */

// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii

public class Code01_BinaryTreeLevelOrderTraversalII {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> nodeList = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.add(queue.poll().val);
            }
            nodeList.add(0,list);
        }

        return nodeList;


    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        treeNode2.right = treeNode2;
        treeNode2.left = new TreeNode(15);
        treeNode2.right = new TreeNode(7);

    }

}
