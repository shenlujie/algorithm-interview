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
public class Solution {
    int[] memo;//将递归改良，使用记忆搜索法
    public int integerBreak(int n) {
        memo = new int[n];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return breakInteger(n);
    }

    private int breakInteger(int n){
        //递归边界
        if (n == 1){
            return 1;
        }
        int result = -1;
        for (int i = 1; i <= n - 1; i++) {
            if (memo[n - i] == -1){
                memo[n - i] = breakInteger(n - i);
            }
            result = Math.max(result, Math.max(i * (n - i), i * memo[n - i]));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 29;
        System.out.println(new Solution().integerBreak(n));
    }
}
