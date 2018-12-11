package 二叉树和递归.二叉树的最小深度;

import 二叉树和递归.二叉树辅助类.TreeNode;

/**
 * @Description: No.111
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * @create: 2018/12/9
 * @Author: SLJ
 */
public class Solution {
    //需要注意的是，如果一个节点的左子树或右子树为null的话，那么该节点的最小深度应该为
    //不为空的子节点的最小深度 + 1
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else if (root.left == null && root.right != null){
            return minDepth(root.right) + 1;
        }else if (root.right == null && root.left != null){
            return minDepth(root.left) + 1;
        }else {
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            return Math.min(leftDepth,rightDepth ) + 1;
        }
    }
}
