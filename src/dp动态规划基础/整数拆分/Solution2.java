package dp动态规划基础.整数拆分;

/**
 * @Description: No.343
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * @create: 2018/12/12
 * @Author: SLJ
 */
public class Solution2 {
    int[] memo;//使用动态规划
    public int integerBreak(int n) {
        memo = new int[n + 1];
        memo[1] = 1;
        //memo[i]表示将i从分割后(最少分成两份)求得乘积的最大值
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i-1; j++) {
                memo[i] = Math.max(memo[i], Math.max(j * (i - j), j * memo[i - j]));
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        long startTime = System.nanoTime();
        int result = new Solution2().integerBreak(n);
        long endTime = System.nanoTime();
        System.out.println("结果是：" + result);
        System.out.println("使用时间为：" + (double)(endTime - startTime)/1000000000.0);
    }
}
