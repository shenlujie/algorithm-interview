package 查找表相关问题.存在重复元素二;

import java.util.HashSet;

/**
 * @Description: No.219
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
 * 并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * @create: 2018/12/4
 * @Author: SLJ
 */
public class Solution {

    //首先能想到的暴力解法
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2){
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(j - i) <= k){
                    return true;
                }
            }
        }

        return false;
    }

    //当然了，典型的滑动窗口问题，维护一个l到l+k范围的窗口，将窗口中的所有值添加到
    //set中，观察set是否包含此元素，包含为true，不包含继续维护窗口
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }

            //维持set中有k + 1个元素，即滑动窗口
            if (set.size() == k + 1){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new Solution().containsNearbyDuplicate2(nums, 2));
    }
}
