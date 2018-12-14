package 贪心算法.无重叠区;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: No.435
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * @create: 2018/12/14
 * @Author: SLJ
 */
public class Solution {
    /*
     * 思路：动态规划--与最长上升子序列思路非常相似
     * 移除最小区间数变通一下即是找出最长连续子区间
     * */
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });
        int[] memo = new int[intervals.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 1;
        }
        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j].end <= intervals[i].start) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < memo.length; i++) {
            result = Math.max(result, memo[i]);
        }
        return intervals.length - result;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1,2);
        Interval interval2 = new Interval(2,3);
        Interval interval3 = new Interval(3,4);
        Interval interval4 = new Interval(1,3);
        Interval[] intervals = {interval1,interval2,interval3,interval4};
        System.out.println(new Solution().eraseOverlapIntervals(intervals));
    }
}

class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public Interval(){
        start = 0;
        end = 0;
    }
}
