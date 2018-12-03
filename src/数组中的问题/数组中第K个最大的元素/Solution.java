package 数组中的问题.数组中第K个最大的元素;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @Description: No.215
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @create: 2018/12/2
 * @Author: SLJ
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //第一种投机取巧,调用jdk库
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        return list.get(list.size() - k);
    }

    //第二种自己实现三路快排，Collections.sort也是三路快排
    public int findKthLargest2(int[] nums,int k){
        int l = 0;
        int r = nums.length - 1;
        quickSort(nums,l,r);
        return nums[nums.length - k];
    }
    private void quickSort(int[] nums,int l,int r){
        if (r - l <= 15){
            //改用插入排序
            for (int i = l+1;i <= r;i ++){
                int e = nums[i];
                int j;
                for (j = i;j > l;j --){
                    if (nums[j-1] > e){
                        nums[j] = nums[j-1];
                    }else {
                        break;
                    }
                }
                nums[j] = e;
            }
            return;
        }

        int lt = l + 1;//<e的指针，超出一位
        int gt = r;//>e的指针，超前一位
        int i = l + 1;//遍历的指针
        swap(nums, l, (int)Math.random()*(r-l)+l);
        int e = nums[l];
        while (i <= gt){
            if (nums[i] < e){
                swap(nums, lt, i);
                lt ++;
                i ++;
            }else if (nums[i] > e){
                swap(nums, gt, i);
                gt --;
            }else {
                i ++;
            }
        }
        swap(nums, l, lt-1);

        quickSort(nums,l , lt-1);
        quickSort(nums, gt+1, r);
    }
    private void swap(int[] arr,int a,int b){
        int item = arr[a];
        arr[a] = arr[b];
        arr[b] = item;
    }

    //第三种利用partition操作
    public int findKthLargest3(int[] nums,int k){
        int l = 0;
        int r = nums.length-1;
        int p = partition(nums,l,r);
        /*
        根据partition的值，和目标k(partition从小到大排列的话就是nums.length-k)进行比较；
        小于k就从p的右侧进行partition操作；
        大于k就从p的左侧进行partition操作；
        直到p和k值相等，返回p
        * */
        while (p != nums.length-k){
            if (p < nums.length-k){
                p = partition(nums,p+1,r);
            }
            if (p > nums.length-k){
                p = partition(nums,l,p-1);
            }
        }


        return nums[p];
    }
    private int partition(int[] nums,int l,int r){
        swap(nums, (int) Math.random()*(r - l)+l, l);
        int e = nums[l];
        int j = l;
        for (int i = l+1;i <= r;i ++){
            if (nums[i] < e){
                swap(nums, j+1, i);
                j ++;
            }
        }
        swap(nums,l , j);
        return j;
    }
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        System.out.println(new Solution().findKthLargest3(arr, 2));
    }
}
