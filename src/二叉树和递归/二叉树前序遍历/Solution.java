package 二叉树和递归.二叉树前序遍历;

import 二叉树和递归.二叉树辅助类.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: No.144
 * @create: 2018/12/7
 * @Author: SLJ
 */
public class Solution {

    /*
     * 利用递归的方式来遍历
     * 思路简单清晰
     * */
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    /*
    * 非递归方式一（前序遍历专属）：
    * 直接将当前节点压入栈，
    * 每取出一个节点，就将其右节点、左节点压入栈
    * */
    List<Integer> list2 = new ArrayList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null){
            return list2;
        }
        Stack<TreeNode> stack = new Stack<>();
        //将root压入栈
        stack.push(root);
        while (!stack.empty()){
            TreeNode cur = stack.pop();
            list2.add(cur.val);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        return list2;
    }

    /*
     * 非递归方式二，利用栈存放一系列的Command类，根据栈顶的Command来
     * 进行相应的操作
     * */
    List<Integer> list3 = new ArrayList<>();
    public List<Integer> preorderTraversal3(TreeNode root) {
        if (root == null){
            return list3;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("visit", root));
        while (!stack.empty()){
            Command curCommand = stack.pop();
            if (curCommand.command.equals("print")){
                list3.add(curCommand.treeNode.val);
            }else {
                if (curCommand.treeNode.right != null){
                    stack.push(new Command("visit", curCommand.treeNode.right));
                }
                if (curCommand.treeNode.left != null){
                    stack.push(new Command("visit", curCommand.treeNode.left));
                }
                stack.push(new Command("print", curCommand.treeNode));
            }
        }
        return list3;
    }

    //指令类
    class Command{
        private String command;//visit、print
        private TreeNode treeNode;

        public Command(String command, TreeNode treeNode) {
            this.command = command;
            this.treeNode = treeNode;
        }
    }
}
