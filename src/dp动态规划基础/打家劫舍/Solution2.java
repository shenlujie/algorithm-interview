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
public class Solution2 {

    /*
    * 动态规划
    * */
    int[] memo;//memo[i]表示从i到街道末尾所能偷盗的最大值
    public int rob(int[] nums) {
        //特殊情况，街道没房子，偷个奶子
        if (nums.length == 0){
            return 0;
        }
        int n = nums.length;
        memo = new int[n + 1];
        memo[n] = 0;//出了街道的第一家肯定是0了
        memo[n - 1] = nums[n - 1];//街道的最后一家肯定是这家有多少就算多少了
        for (int i = n - 2; i >= 0; i--) {
            //从倒数第二家开始往前算，从这家开始能偷到的最多钱无非是:
            //这家之后的每一家都按照同样的逻辑计算得到的值的最大值
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i],nums[j] + (j + 2 < n ? memo[j + 2] : 0) );
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new Solution2().rob(nums));
    }

}
