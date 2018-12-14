package dp动态规划基础.打家劫舍;

/**
 * @Description: No.198
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @create: 2018/12/12
 * @Author: SLJ
 */
public class Solution {

    /*
    * 记忆化搜索
    * */
    int[] memo;//memo[i]表示从i到街道末尾所能偷盗的最大值
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return tryRob(nums,0);
    }

    //考虑抢劫index --> 街道末尾这段街道的所有房子
    private int tryRob(int[] nums,int index){
        //已经出了街道了，就没得抢了
        if (index >= nums.length){
            return 0;
        }
        //如果memo[index]不为-1说明从i到街道末尾已经考虑过了，直接将该值返回，避免重复计算
        if (memo[index] != -1){
            return memo[index];
        }
        int result = 0;
        for (int i = index; i < nums.length; i++) {
            result = Math.max(result, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = result;//将result的值赋给memo[index]，避免重复计算
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new Solution().rob(nums));
    }

}
