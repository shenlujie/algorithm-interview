package 查找表相关问题.回旋镖的数量;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: No.447
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
 * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * @create: 2018/12/4
 * @Author: SLJ
 */
public class Solution {
    /*
    * 思路思路，还是思路啊
    * 这题看似很难，无从下手，理清思路还是很简单的
    * 题目中明确给出n值范围比较小，即解决思路复杂度应该是O（n^2）级别的
    * */
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        //首先遍历一遍所有点i
        for (int i = 0; i < points.length; i++) {
            //HashMap记录每个点j到点i的距离，以及对应的点数(这个距离出现的频率)
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j){
                    map.put(distance(points[i],points[j]),
                            map.getOrDefault(distance(points[i],points[j]), 0) + 1);
                }
            }
            //此时map中已经存了其余所有点到i的距离和频率的对应关系
            //遍历map并将大于2的情况求出所有可能性加到result上
            for (Map.Entry<Integer, Integer> item:map.entrySet()) {
                if (item.getValue() >= 2){
                    //所有情况公式Cn2（n个点任选两个）n * (n - 1)
                    result += item.getValue() * (item.getValue() - 1);
                }
            }
        }
        return result;
    }
    //求两点间的距离
    private int distance(int[] a,int[] b){
        int len = (a[0] - b[0]) * (a[0] - b[0]);
        int hei = (a[1] - b[1]) * (a[1] - b[1]);
        return len + hei;//返回距离的平方和，没有开平方，避免出现非整数
    }
}
