package 数组中的问题.合并两个有序数组;

/**
 * @Description: No.88
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @create: 2018/12/2
 * @Author: SLJ
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //开辟一个nums1的数组arr
        int[] arr = new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums1[i];
        }

        //将arr与nums2进行归并，把归并结果放进nums1
        int i = 0;//遍历arr的指针
        int j = 0;//遍历nums2的指针
        for (int k = 0;k < nums1.length;k ++){
            if (i >= arr.length){
                nums1[k] = nums2[j];
                j ++;
            }else if (j >= n){
                nums1[k] = arr[i];
                i ++;
            }else if (arr[i] <= nums2[j]){
                nums1[k] = arr[i];
                i ++;
            }else if (arr[i] > nums2[j]){
                nums1[k] = nums2[j];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new Solution().merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + "\t");
        }
    }
}
