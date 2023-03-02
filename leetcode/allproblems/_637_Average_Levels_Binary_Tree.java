package leetcode.allproblems;

import common.InputReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637_Average_Levels_Binary_Tree {
    public static void main(String[] args) {
    //    System.out.println(new _637_Average_Levels_Binary_Tree().averageOfLevels(InputReader.));
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> results = new ArrayList<>();
        Queue<TreeNode> parents = new LinkedList<>();
        parents.add(root);
        while (parents.isEmpty()) {
            Queue<TreeNode> children = new LinkedList<>();
            double average = 0;
            int count = 0;
            while (parents.isEmpty()) {
                TreeNode parent = parents.remove();
                average = (average * count) + parent.val;
                count++;
                if (parent.left != null) {
                    children.add(parent.left);
                }
                if (parent.right != null) {
                    children.add(parent.right);
                }
            }
            parents = children;
            results.add(average);
        }
        return results;
    }

    private static class TreeNode {
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
}
