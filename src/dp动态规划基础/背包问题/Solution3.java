package dp动态规划基础.背包问题;

/**
 * @Description: 自底向上，动态规划
 * 有n件物品和一个容量为C的背包。第i件物品的重量是[i]，价值是v[i]。求解将哪些物品装入背包可使价值总和最大.
 * @create: 2018/12/12
 * @Author: SLJ
 */
public class Solution3 {

    //行数从0--n-1表示这n个物品
    //列数从0--C表示这背包的容量
    int[][] memo;
    //返回放进书包的最大价值
    public int knapsack01(int[] w,int[] v,int C){
        int n = w.length;
        if (n == 0){
            return 0;
        }
        //初始化memo，memo[i][j]表示在i容量的背包中考虑放从0-j个物品的最大价值
        memo = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = -1;
            }
        }

        //二维数组的第一行是基本数据
        //也就是当只考虑i = 0这个物品时，背包容量从0-C所能承受的最大价值
        for (int j = 0; j <= C; j++) {
            memo[0][j] = j >= w[0] ? v[0] : 0;
        }

        //由基本数据向后推断
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i]){//保证j容量的背包能承受当前i物品的重量
                    //a、当前物品i不放进背包的最大价值
                    //b、在保证j容量的背包能承受当前i物品的重量的情况下将物品i放进背包的最大价值
                    //a、b这两种情况取最大值
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= C; j++) {
               System.out.print(memo[i][j] + "\t");
            }
            System.out.println();
        }

        return memo[n - 1][C];
    }


    public static void main(String[] args) {
        int[] w = {1,2,3};
        int[] v = {6,10,12};
        int C = 5;
        System.out.println(new Solution3().knapsack01(w, v, C));
    }

}
