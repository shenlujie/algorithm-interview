package 查找表相关问题.存在重复元素三;

import java.util.TreeSet;

/**
 * @Description: No.220
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * @create: 2018/12/5
 * @Author: SLJ
 */
public class Solution {
    //首先想到的思路，O（n^2）超时了
    //维护一个count作为i到i+k的所有数与nums[i]差值
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2){
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int count;
            while (j <= i + k && j < nums.length){
                //i j两个元素的差值绝对值大于int的最大值，false
                if ((nums[i] < 0 && nums[j] >= Integer.MAX_VALUE) || (nums[j] < 0 && nums[i] >= Integer.MAX_VALUE)){
                    return false;
                }
                count = Math.abs(nums[j] - nums[i]);
                if (count <= t){
                    return true;
                }
                j ++;
            }

        }
        return false;
    }

    //还是滑动窗口，只是需要使用TreeSet来保证窗口中所有元素的顺序性
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如何保证set中存在差距在t之内的值呢？|v - x| <= t 得 x - t <= v <= x + t
            if (set.ceiling((long)nums[i] - (long)t) != null &&
                    set.ceiling((long) nums[i] - (long)t) <= (long)nums[i] + (long)t){
                return true;
            }else {
                set.add((long)nums[i]);
            }

            //维持set中有k + 1个元素，即滑动窗口
            if (set.size() == k + 1){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2147483647};
        System.out.println(new Solution().containsNearbyAlmostDuplicate(nums, 1,2147483647));
    }
}
