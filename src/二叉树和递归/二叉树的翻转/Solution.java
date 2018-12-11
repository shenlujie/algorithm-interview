package 二叉树和递归.二叉树的翻转;

import 二叉树和递归.二叉树辅助类.TreeNode;

/**
 * @Description: No.226
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @create: 2018/12/9
 * @Author: SLJ
 */
public class Solution {
    //递归翻转
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)){
            return root;
        }

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;

        return root;
    }
}
