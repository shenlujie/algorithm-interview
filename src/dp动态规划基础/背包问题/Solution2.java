package dp动态规划基础.背包问题;

/**
 * @Description: 自顶向下，记忆化搜索
 * 有n件物品和一个容量为C的背包。第i件物品的重量是[i]，价值是v[i]。求解将哪些物品装入背包可使价值总和最大.
 * @create: 2018/12/12
 * @Author: SLJ
 */
public class Solution2 {

    int[][] memo;
    //返回放进书包的最大价值
    public int knapsack01(int[] w,int[] v,int C){
        int n = w.length;
        memo = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return bestValue(w,v,C,n - 1);
    }

    //将0 -- index个物品尝试放进书包所能取得的最大价值
    private int bestValue(int[] w,int[] v,int C,int index){
        //递归边界，当index<0或者背包的容量比0还小
        if (index < 0 || C <= 0){
            return 0;
        }
        if (memo[index][C] != -1){
            return memo[index][C];
        }
        //result取两种情况中的最大值，即所谓的01问题：
        //1、没有把index位置的物品放入背包
        //2、把index位置的物品放入背包
        int result = bestValue(w, v, C, index - 1);
        if (C - w[index] >= 0){
            result = Math.max(result,v[index] + bestValue(w, v, C - w[index],index - 1) );
        }
        memo[index][C] = result;
        return result;
    }

    public static void main(String[] args) {
        int[] w = {1,2,3};
        int[] v = {6,10,12};
        int C = 5;
        System.out.println(new Solution2().knapsack01(w, v, C));
    }

}
