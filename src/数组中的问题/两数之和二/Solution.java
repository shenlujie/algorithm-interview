package 数组中的问题.两数之和二;

/**
 * @Description: No.167
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）是从1开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * @create: 2018/12/2
 * @Author: SLJ
 */
public class Solution {
    //第一版最容易想到的暴力破解
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int i1 = i+1; i1 < numbers.length; i1++) {
                if (numbers[i] + numbers[i1] == target){
                    result[0] = i + 1;
                    result[1] = i1 + 1;
                    return result;
                }
            }
        }
        return null;
    }

    //由于是升序数组，使用两个指针，起始和结尾，两个指针向中间靠拢，最终得到答案（碰撞指针）
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target){
            if (numbers[i] + numbers[j] < target){
                i ++;
            }else if (numbers[i] + numbers[j] > target){
                j --;
            }
        }
        result[0] = i + 1;
        result[1] = j + 1;
        return result;
    }

    //利用有序数组，采用二分搜索法
    public int[] twoSum3(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1;
            int r = numbers.length-1;
            while (l <= r){
                int mid = l + (r-l)/2;
                if (numbers[mid] == target-numbers[i]){
                    result[0] = i + 1;
                    result[1] = mid + 1;
                    return result;
                }else if (numbers[mid] > target-numbers[i]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
//        int[] arr = {2,7,11,16,23,25,29,37};
        int[] arr = {-1,0};
        int[] nums = new Solution().twoSum2(arr, -1);
        System.out.println(nums[0] + "\t" + nums[1]);
    }
}
