package 栈和队列和优先队列的问题.完全平方数;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: No.279
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * @create: 2018/12/8
 * @Author: SLJ
 */
public class Solution {
    /*
    * 第一种思路，把0 - n的数想象成一个无向无权的连通图
    * 所有差值为平方数的两个数连成边
    * 这样问题就转化为了求n到0的最短路径
    * 缺陷：时间复杂度为O（2^n），时间超时
    * */
    public int numSquares(int n) {
        //Pair<Integer,Integer>代表 <n,step>
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(n, 0));
        while (!queue.isEmpty()){
            Pair<Integer,Integer> curPair = queue.remove();
            int num = curPair.getKey();
            int step = curPair.getValue();

            if (num == 0){
                return step;
            }
            for (int i = 1; num - i * i >= 0; i++) {
                queue.add(new Pair<>(num - i * i, step + 1));
            }
        }
        return 0;
    }

    /*
    * 针对第一版进行优化
    * 设置一个visited数组记录访问过的节点，队列中只存放没有访问过的节点；
    *
    * */
    public int numSquares2(int n) {
        //Pair<Integer,Integer>代表 <n,step>
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(new Pair<>(n, 0));
        visited[n] = true;
        while (!queue.isEmpty()){
            Pair<Integer,Integer> curPair = queue.remove();
            int num = curPair.getKey();
            int step = curPair.getValue();

            if (num == 0){
                return step;
            }
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0){
                    break;
                }
                if (a == 0){
                    return step + 1;
                }
                if (!visited[a]){
                    queue.add(new Pair<>(a, step + 1));
                    visited[a] = true;
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new Solution().numSquares2(n));
    }
}
