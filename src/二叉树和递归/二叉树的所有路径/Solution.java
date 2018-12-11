package 二叉树和递归.二叉树的所有路径;

import 二叉树和递归.二叉树辅助类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: No.257
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @create: 2018/12/10
 * @Author: SLJ
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        //初始root为null，直接返回空list
        if (root == null){
            return list;
        }
        //递归边界，当遇到叶子节点时，直接存入该节点的值并返回
        if (root.left == null && root.right == null){
            list.add(String.valueOf(root.val));
            return list;
        }
        //将左子树的所有字符串都添加到头节点下面
        List<String> leftList = binaryTreePaths(root.left);
        for (String i:leftList) {
            list.add(String.valueOf(root.val) + "->" + i);
        }
        //将右子树的所有字符串都添加到头节点下面
        List<String> rightList = binaryTreePaths(root.right);
        for (String i:rightList) {
            list.add(String.valueOf(root.val) + "->" + i);
        }
        return list;
    }
}
