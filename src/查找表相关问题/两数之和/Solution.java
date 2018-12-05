package 查找表相关问题.两数之和;

import java.util.HashMap;

/**
 * @Description: No.1
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @create: 2018/12/4
 * @Author: SLJ
 */
public class Solution {
    //HashMap中存值及值对应的索引，遍历数组判断HashMap中是否存在target-nums[i]
    //需要注意的是，索引不能是重复值
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i );
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                if (result[0] == result[1]){
                    continue;
                }else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] result = new Solution().twoSum(arr, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }
}
