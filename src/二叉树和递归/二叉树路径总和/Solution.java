package 二叉树和递归.二叉树路径总和;

import 二叉树和递归.二叉树辅助类.TreeNode;

/**
 * @Description: No.112
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @create: 2018/12/9
 * @Author: SLJ
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        //如果root节点为null，直接返回false
        if (root == null){
            return false;
        }

        //递归终止条件，必须到达叶子节点
        if (root.left == null && root.right == null){
            return root.val == sum;
        }
        if (hasPathSum(root.left, sum - root.val)){
            return true;
        }
        if (hasPathSum(root.right, sum - root.val)){
            return true;
        }

        return false;

    }
}
