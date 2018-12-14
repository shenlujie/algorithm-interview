package 递归和回溯法.全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: No.46
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @create: 2018/12/11
 * @Author: SLJ
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();//存放结果的list
    boolean[] marked;//存放当前元素是否被访问过的记录的数组
    public List<List<Integer>> permute(int[] nums) {
        //特殊情况判断
        if (nums.length == 0){
            return result;
        }
        //初始化标记数组
        marked = new boolean[nums.length];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        //初始化递归调用的list，整个递归过程在该list中进行
        List<Integer> list = new ArrayList<>();
        findPermute(nums,0,list);
        return result;
    }

    //nums要操作的数组，index当前操作的元素，list存放nums[0]-nums[index]的一种排列方式的组合
    private void findPermute(int[] nums,int index,List<Integer> list){
        //当index为数组的容量时，说明list中已经存满了元素
        //并将list赋给一个新的list，result中添加新的list
        //因为该list一会还要回溯，回溯会清空里面的元素
        if (index == nums.length){
            List<Integer> newList = new ArrayList<>();
            for (Integer i : list) {
                newList.add(i);
            }
            result.add(newList);
            return;
        }

        //遍历nums数组，每个元素都有作为第一个元素的机会
        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]){//该元素没有被标记就可以添加到排列中
                list.add(nums[i]);
                marked[i] = true;
                findPermute(nums, index + 1, list);//递归对后边的元素进行同样的排列操作
                //回溯，操作完一个元素需要将其恢复初始状态（从list中清除，并且清楚标记），因为一会还会用到
                list.remove(list.size() - 1);
                marked[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = new Solution().permute(nums);
        for (List<Integer> list : result) {
            for (Integer i  : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
