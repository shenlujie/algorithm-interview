package dp动态规划基础.分割等和子集;

/**
 * @Description: No.416
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 * @create: 2018/12/13
 * @Author: SLJ
 */
public class Solution {

    //自底向上动态规划:C容量就是nums[]所有元素总和的一半，index表示0--index的元素能否填充容量C
    //状态转移方程：canPartition(index,C) = canPartition(index - 1,C) || canPartition(index,C - nums[index])
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        //sum无法分为一半，那么就无法满足题意，false
        if (sum % 2 != 0){
            return false;
        }
        //C表示最大容量
        int C = sum / 2;
        //memo[i]表示nums[0 -- i]是否可以填满容量i
        boolean[] memo = new boolean[C + 1];
        //初始化memo
        for (int i = 0; i <= C; i++) {
            memo[i] = nums[0] == i;//动态规划的基础数据，nums[0]可以求出，从nums[0]开始递推
        }
        //递推过程
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i] ; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }

        return memo[C];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Solution().canPartition(nums));
    }
}
