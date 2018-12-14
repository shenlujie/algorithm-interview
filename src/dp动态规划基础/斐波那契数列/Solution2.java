package dp动态规划基础.斐波那契数列;


/**
 * @Description: 将递归思路优化，采用记忆化搜索，自顶向下考虑
 * @create: 2018/12/12
 * @Author: SLJ
 */
public class Solution2 {
    private static int time = 0;
    private static int[] memo;
    public int fib(int n){

        time ++;

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (memo[n] == -1){
            memo[n] = fib(n-1) + fib(n-2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 40;
        memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        long startTime = System.nanoTime();
        int result = new Solution2().fib(n);
        long endTime = System.nanoTime();
        System.out.println("结果是：" + result);
        System.out.println("使用时间为：" + (double)(endTime - startTime)/1000000000.0);
        System.out.println("计算次数为：" + time);
    }
}
