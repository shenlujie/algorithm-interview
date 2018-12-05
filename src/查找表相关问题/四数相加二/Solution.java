package 查找表相关问题.四数相加二;

import java.util.HashMap;

/**
 * @Description: No.454
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 * @create: 2018/12/4
 * @Author: SLJ
 */
public class Solution {
    //将A和B的所有情况添加到HashMap中，在匹配所有C和D的和
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                //map中不存在就返回默认值
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(- C[i] - D[j])){
                    result += map.get(- C[i] - D[j]);
                }
            }
        }
        return result;
    }
}
