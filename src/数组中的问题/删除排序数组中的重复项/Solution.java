package 数组中的问题.删除排序数组中的重复项;

/**
 * @Description: No.26
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度k，并且
 * 数组的前k个元素被修改为不重复的元素。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @create: 2018/11/30
 * @Author: SLJ
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;//初始索引值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[k-1]){
                continue;
            }else {
                nums[k ++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Solution().removeDuplicates(arr));
    }
}
