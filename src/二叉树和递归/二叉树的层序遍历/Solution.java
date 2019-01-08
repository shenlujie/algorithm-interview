package 二叉树和递归.二叉树的层序遍历;

import javafx.util.Pair;
import 二叉树和递归.二叉树辅助类.TreeNode;

import java.util.*;

/**
 * @Description: No.102
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @create: 2018/12/7
 * @Author: SLJ
 */
public class Solution {

    /**
     * 存储最终结果的list
     */
    List<List<Integer>> resultList = new ArrayList<>();

    /**
     * 使用队列
     * 使用Pair来标记node和层数的映射关系（Pair是一种非常简易的键值映射关系数据结构，非常方便）
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //特殊情况
        if (root == null){
            return resultList;
        }
        //遍历使用的队列
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> pair = queue.remove();
            TreeNode curNode = pair.getKey();
            int level = pair.getValue();
            if (level == resultList.size()){
                resultList.add(new ArrayList<>());
            }
            resultList.get(pair.getValue()).add(curNode.val);

            if (curNode.left != null){
                queue.add(new Pair<>(curNode.left, level + 1));
            }
            if (curNode.right != null){
                queue.add(new Pair<>(curNode.right, level + 1));
            }
        }
        return resultList;
    }
}
