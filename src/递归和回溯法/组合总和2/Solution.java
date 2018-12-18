package 递归和回溯法.组合总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: No.40
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * @create: 2018/12/18
 * @Author: SLJ
 */
public class Solution {

    /**
     * 结果集
     */
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 求所有的组合
     * @param candidates 目标数组
     * @param target 目标和
     * @return 结果集
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //特殊情况
        if (candidates.length == 0){
            return result;
        }
        //临时存储集
        List<Integer> list = new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        dfs(candidates,0,target,list);
        return result;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> list){
        if (target == 0){
            if (!result.contains(list)){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //剪枝
            if (candidates[i] > target){
                return;
            }
            list.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], list);
            //回溯
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> result = new Solution().combinationSum2(candidates, target);
        for (List<Integer> list :result ) {
            for (Integer i  :list ) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
