package 数组中的问题.长度最小的子数组;

/**
 * @Description: No.209
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * @create: 2018/12/3
 * @Author: SLJ
 */
public class Solution {

    //滑动窗口双指针
    public int minSubArrayLen(int s, int[] nums) {
        int count = 0;//记录子数组的和
        int result = nums.length + 1;//记录满足条件的子数组的长度，并维护始终保持最小
        int l = 0;
        int r = -1;//代表初始情况下子数组中不包含任何值
        while (l < nums.length){
            if (count < s && r + 1 < nums.length){
                count += nums[++ r];
            }else {
                count -= nums[l ++];
            }
            if (count >= s){
                int curResult = r - l + 1;
                result = Math.min(result, curResult);
            }
        }
        return result == nums.length + 1? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new Solution().minSubArrayLen(7, nums));
    }
}
