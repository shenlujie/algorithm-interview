package 递归和回溯法.组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: No.77
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * @create: 2018/12/11
 * @Author: SLJ
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        //特殊情况
        if (k <= 0 || k > n || n <= 0){
            return result;
        }
        //list用来存放各个组合
        List<Integer> list = new ArrayList<>();
        findCombine(n,1,list,k);
        return result;
    }

    private void findCombine(int n,int start,List<Integer> list,int k){
        //当list中的元素个数达到规定的k值时，复制一个list存入result中
        if (list.size() == k){
            List<Integer> newList = new ArrayList<>();
            for (Integer i : list) {
                newList.add(i);
            }
            result.add(newList);
            return;
        }

        //由于各个组合中元素不能重复，遍历从start开始
        //for (int i = start; i <= n; i++)
        //优化：i从start开始，但是并没有必要遍历到n，只需遍历到n - (k - list.size()) + 1即可保证这个区间内能够存满list
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            findCombine(n, i + 1, list,k );
            //回溯，将list中的元素取出
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> result = new Solution().combine(n,2);
        for (List<Integer> list : result) {
            for (Integer i  : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
