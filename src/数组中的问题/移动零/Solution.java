package 数组中的问题.移动零;

/**
 * @Description: No.283
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @create: 2018/11/30
 * @Author: SLJ
 */
public class Solution {
    //第一版：采用冒泡排序思想，把0冒泡到数组的末尾
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] == 0){
                    int item = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = item;
                }
            }
        }
    }

    //第二版：维护一个索引k,使得[0,k）的元素都是非零的，[k,n]的元素都是0
    public void moveZeroes1(int[] nums){
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                if (k != i){//避免和自身交换
                    //交换nums[k]和nums[i]
                    int item = nums[k];
                    nums[k] = nums[i];
                    nums[i] = item;
                }
                k ++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1,2,0,4};
        new Solution().moveZeroes1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
