package 查找表相关问题.三数之和;

import java.util.*;

/**
 * @Description: No.15
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @create: 2018/12/4
 * @Author: SLJ
 */
public class Solution {
    //完全没思路，StackOverflow上带佬的思路，三指针搞定一切
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        //先对nums进行排序
        Arrays.sort(nums);
        /*i是第一个指针，从0开始遍历整个数组
         * j是第二个指针，从i+1开始，遍历到数组最后
         * k是第三个指针，从数组末尾开始向前遍历
         * */
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int j = i + 1;
                int k = nums.length - 1;
                int sum = 0 - nums[i];
                while (j < k){
                    if (nums[j] + nums[k] == sum){
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]){
                            j ++;
                        }
                        while (j < k && nums[k] == nums[k - 1]){
                            k --;
                        }
                        j ++;
                        k --;

                    }else if (nums[j] + nums[k] < sum){
                        j ++;
                    }else {
                        k --;
                    }
                }
            }

        }

        return resultList;
    }
}
