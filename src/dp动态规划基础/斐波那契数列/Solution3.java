package dp动态规划基础.斐波那契数列;


/**
 * @Description: 动态规划，自底向上考虑
 * @create: 2018/12/12
 * @Author: SLJ
 */
public class Solution3 {
    private static int time = 0;
    public int fib(int n){

        time ++;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n ; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 40;
        long startTime = System.nanoTime();
        int result = new Solution3().fib(n);
        long endTime = System.nanoTime();
        System.out.println("结果是：" + result);
        System.out.println("使用时间为：" + (double)(endTime - startTime)/1000000000.0);
        System.out.println("计算次数为：" + time);
    }
}
