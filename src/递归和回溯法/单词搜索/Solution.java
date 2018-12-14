package 递归和回溯法.单词搜索;

/**
 * @Description: No.79
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * @create: 2018/12/11
 * @Author: SLJ
 */
public class Solution {

    private int[][] d = {
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };
    private int m,n;//记录board的行数和列数
    private boolean[][] isVisited;
    public boolean exist(char[][] board, String word) {
        //特殊情况
        if (board.length == 0 || word.equals("")){
            return false;
        }
        m = board.length;
        n = board[0].length;
        isVisited = new boolean[m][n];
        //每个元素都有作为起始元素的机会
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (seachWord(board,word.toCharArray(),0,i,j)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean seachWord(char[][] board,char[] word,int index,int startx,int starty){
        //递归边界,当遍历到单词的最后一个字母时，只需判断board当前指向的字母是否与word的最后一个字母相同即可
        if (index == word.length - 1){
            return word[index] == board[startx][starty];
        }

        if (word[index] == board[startx][starty]){
            //标记该点为已访问
            isVisited[startx][starty] = true;
            //向当前字母的四个方向继续递归
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx,newy) && !isVisited[newx][newy]){
                    if (seachWord(board, word, index + 1, newx, newy)){
                        return true;
                    }
                }
            }
            //回溯，将该店重新标记为未访问
            isVisited[startx][starty] = false;

        }

        return false;
    }

    private boolean inArea(int x,int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
