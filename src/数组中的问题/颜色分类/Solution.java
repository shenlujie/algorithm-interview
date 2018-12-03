package 数组中的问题.颜色分类;

/**
 * @Description: No.75
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @create: 2018/12/1
 * @Author: SLJ
 */
public class Solution {
    //第一版先用插入排序走一下
    public void sortColors(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j;
            int e = nums[i];
            for (j = i; j > 0;j --){
                if (nums[j - 1] > e){
                    nums[j] = nums[j-1];
                }else {
                    break;
                }
            }
            nums[j] = e;
        }
    }

    /*
    * 一个直观的解决方案是使用计数排序的两趟扫描算法。
      首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
    */
    public void sortColors2(int[] nums){
        int[] arr = new int[3];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] ++;
        }
        int index = 0;
        for (int i = 0; i < arr[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < arr[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < arr[2]; i++) {
            nums[index++] = 2;
        }
    }

    //只循环一次，三路快排的思想
    public void sortColor3(int[] nums){
        int zero = -1;//0元素索引的初始值
        int two = nums.length;//2元素索引的初始值
        for (int i = 0; i < two;) {
            if (nums[i] == 1){
                i ++;
            }else if (nums[i] == 2){
                two --;
                int item = nums[two];
                nums[two] = nums[i];
                nums[i] = item;

            }else {
                zero ++;
                int item = nums[zero];
                nums[zero] = nums[i];
                nums[i] = item;
                i ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        new Solution().sortColor3(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
