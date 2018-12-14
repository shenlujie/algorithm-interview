package 递归和回溯法.岛屿个数;

/**
 * @Description: No.200
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
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

    public int numIslands(char[][] grid) {
        //特殊情况
        if (grid.length == 0){
            return 0;
        }
        //初始化m、n、isVisited数组
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];//默认为false
        int result = 0;//记录结果
        //遍历所有节点，如果发现一个岛屿，首先结果+1，再将该岛屿扩张flood fill
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (inArea(i, j) && !isVisited[i][j] && grid[i][j] == '1'){
                    result ++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }

    //flood fill算法，将和该岛屿相邻的所有小岛屿全部归为该岛屿
    private void dfs(char[][] grid,int startx,int starty){
        isVisited[startx][starty] = true;//先将该小岛屿标记为已开发
        for (int i = 0; i < 4; i++) {//向四个方向疯狂考虑
            int newx = startx + d[i][0];
            int newy = starty + d[i][1];
            //满足三个条件：在大洋内、没被开发过、是小岛屿就继续flood fill
            if (inArea(newx, newy) && !isVisited[newx][newy] && grid[newx][newy] == '1'){
                dfs(grid, newx, newy);
            }
        }
    }

    private boolean inArea(int x,int y){
        return x >=0 && x < m && y >= 0 && y < n;
    }
}
