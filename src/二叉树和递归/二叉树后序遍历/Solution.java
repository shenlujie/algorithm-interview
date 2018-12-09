package 二叉树和递归.二叉树后序遍历;

import 二叉树和递归.二叉树辅助类.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: No.145
 * @create: 2018/12/7
 * @Author: SLJ
 */
public class Solution {

    List<Integer> list = new ArrayList<>();
    //递归方式
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    /*
     * 非递归方式，利用栈存放一系列的Command类，根据栈顶的Command来
     * 进行相应的操作
     * */
    List<Integer> list2 = new ArrayList<>();
    public List<Integer> postorderTraversal2(TreeNode root){
        if (root == null){
            return list2;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("visit", root));
        while (!stack.empty()){
            Command curCommand = stack.pop();
            if (curCommand.command.equals("print")){
                list2.add(curCommand.treeNode.val);
            }else {
                stack.push(new Command("print", curCommand.treeNode));
                if (curCommand.treeNode.right != null){
                    stack.push(new Command("visit", curCommand.treeNode.right));
                }
                if (curCommand.treeNode.left != null){
                    stack.push(new Command("visit", curCommand.treeNode.left));
                }
            }
        }

        return list2;
    }
    //指令类
    class Command{
        private String command;//visit、print;访问代表考虑到当前节点，打印代表操作当前节点
        private TreeNode treeNode;

        public Command(String command, TreeNode treeNode) {
            this.command = command;
            this.treeNode = treeNode;
        }
    }
}
