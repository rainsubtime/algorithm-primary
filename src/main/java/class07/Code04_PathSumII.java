package class07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code04_PathSumII {

    // 测试链接：https://leetcode.com/problems/path-sum-ii
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        List<Integer> list = new LinkedList<>();
        int newSum = 0;
        process(root,list,newSum,sum);
        return ans;
    }

    public static void process(TreeNode x, List<Integer> path, int preSum, int sum) {
        path.add(x.val);
        int curSum = x.val + preSum;
        if(x.left == null && x.right == null){
            if(curSum == sum){
                List<Integer> newList = copyList(path);
                ans.add(newList);
            }
        }
        if(x.left != null){
            process(x.left,path,curSum,sum);
        }
        if(x.right != null){
            process(x.right,path,curSum,sum);
        }
        path.remove(path.size() - 1);
    }

    public static List<Integer> copyList(List<Integer> orig){
        List<Integer> newList = new ArrayList<>(orig);
        return newList;
    }

}