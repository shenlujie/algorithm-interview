package 栈和队列和优先队列的问题.逆波兰表达式求值;

import java.util.Stack;

/**
 * @Description: No.150
 *根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * @create: 2018/12/7
 * @Author: SLJ
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String e = tokens[i];
            //当字符串中元素为数字时，将该元素添加到stack中
            if (!e.equals("+") && !e.equals("-") && !e.equals("*") && !e.equals("/")){
                stack.push(e);
            }else {
                //当遇到运算符时，从stack中取出两个元素进行计算
                Integer a = Integer.valueOf(stack.pop());
                Integer b = Integer.valueOf(stack.pop());
                int result = 0;
                switch (e){
                    case "+":
                        result = b + a;
                        break;
                    case "-":
                        result = b - a;
                        break;
                    case "*":
                        result = b * a;
                        break;
                    case "/":
                        result = b / a;
                        break;
                }
                //再将计算得到的结果添加到stack中
                stack.push(String.valueOf(result));
            }
        }
        int finalResult = Integer.valueOf(stack.pop());
        return finalResult;
    }

    public static void main(String[] args) {
        String[] arr = {"4", "13", "5", "/", "+"};
        int result = new Solution().evalRPN(arr);
        System.out.println(result);
    }
}
