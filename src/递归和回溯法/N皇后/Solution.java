package 递归和回溯法.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: No.51
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 即任意两个皇后不在同一行、同一列、同一对角线上
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * @create: 2018/12/11
 * @Author: SLJ
 */
public class Solution {
    private List<List<String>> result = new ArrayList<>();
    private boolean[] col,dia1,dia2;
    public List<List<String>> solveNQueens(int n) {
        //初始化list,col,dia1,dia2
        List<Integer> list = new ArrayList<>();//存放满足规则的列数
        col = new boolean[n];//代表index行中n元素对应的列数
        dia1 = new boolean[2*n - 1];//二维图中所有左对角线个数
        dia2 = new boolean[2*n - 1];//二维图中所有右对角线个数
        putQueue(n, 0, list);
        return result;
    }

    //n皇后问题、从index行开始考虑、将每行的存放皇后的列数存到list中
    private void putQueue(int n,int index,List<Integer> list){
        //递归边界
        if (index == n){
            result.add(generate(n,list));
            return;
        }

        //向index行中递归尝试摆放皇后
        for (int i = 0; i < n; i++) {
            //col[i]代表index行中第i个元素对应的列数
            //dia1[index + 1]代表index行中第i个元素对应的左对角线
            //dia2[index - i + n - 1]代表index行中第i个元素对应的右对角线
            //当列上、左对角线上、右对角线上都元素时，当前index行，i列的元素才满足，将i存入list
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
                list.add(i);
                //存入list之后将列数、左对角线、右对角线全部标记
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                //继续考虑下一行
                putQueue(n, index + 1, list);
                //回溯,将做过标记的列数、左对角线、右对角线、list恢复
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private List<String> generate(int n,List<Integer> list){
        ArrayList<String> board = new ArrayList<String>();
        for(int i = 0 ; i < n ; i ++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[list.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }
}
