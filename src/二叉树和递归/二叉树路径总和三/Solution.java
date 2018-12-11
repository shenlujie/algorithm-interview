package 二叉树和递归.二叉树路径总和三;

import 二叉树和递归.二叉树辅助类.TreeNode;

/**
 * @Description: No.437
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * @create: 2018/12/10
 * @Author: SLJ
 */
public class Solution {
    //分为两种情况:
    //一种是root再路径上的所有路径
    //另一种时root不在路径上的所有路径
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        int result = findPath(root,sum);//root在路径上的所有符合条件的路径总数
        result += pathSum(root.left, sum);//root的左子树所有的路径
        result += pathSum(root.right, sum);//root的右子树所有的路径
        return result;
    }
    //以node为根的二叉树路径和为num的总数
    //node一定在路径上
    private int findPath(TreeNode node,int num){
        if (node == null){
            return 0;
        }
        int result = 0;
        if (node.val == num){
            result += 1;
        }
        result += findPath(node.left, num - node.val);
        result += findPath(node.right, num - node.val);
        return result;
    }
}
