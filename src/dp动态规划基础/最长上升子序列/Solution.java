package dp动态规划基础.最长上升子序列;

/**
 * @Description: No.300
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * @create: 2018/12/13
 * @Author: SLJ
 */
public class Solution {
    /*
    * 自底向上动态规划
    * */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //特殊情况
        if (n == 0){
            return 0;
        }
        //初始化memo，memo[i]表示算上i在内的最长上升子序列的长度
        //所以初始值每个位置都是1，因为每个元素自身都是一个子序列
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = 1;
        }
        //memo[0]肯定是1，从memo[1]开始考虑
        for (int i = 1; i < n; i++) {
            //memo[i]表示从i往前遍历，所有比memo[i]小的所有结果中最大的值+1
            for (int j = i - 1; j >= 0 ; j--) {
                if (nums[j] < nums[i]){
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        //求出memo[]中最大的值即为最大子序列
        int finalResult = memo[0];
        for (int i = 1; i < n; i++) {
            finalResult = Math.max(finalResult, memo[i]);
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums = {10,15,20,11,9,101};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
