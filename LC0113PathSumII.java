// package VO;

import java.util.*;

public class LC0113PathSumII {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum);
        return res;
    }

    public void dfs(TreeNode root, int num, int sum) {
        if (root == null)
            return;
        num += root.val;
        list.add(root.val);
        if (num == sum && root.left == null && root.right == null)
            res.add(new ArrayList<>(list));
        dfs(root.left, num, sum);
        dfs(root.right, num, sum);
        list.remove(list.size() - 1);
    }
}

// https://leetcode-cn.com/problems/path-sum-ii/