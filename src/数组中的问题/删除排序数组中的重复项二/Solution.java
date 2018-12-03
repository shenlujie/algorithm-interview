package 数组中的问题.删除排序数组中的重复项二;

/**
 * @Description: No.80
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。并且
 * 数组的前k个元素被修改为不重复的元素。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @create: 2018/12/1
 * @Author: SLJ
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;//初始索引值
        int count = 1;//重复项的计数器
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[k-1]){
                if (count < 2){
                    nums[k++] = nums[i];
                    count ++;
                }else {
                    continue;
                }
            }else {
                nums[k ++] = nums[i];
                count = 1;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        for (int i = 0; i < new Solution().removeDuplicates(arr); i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
