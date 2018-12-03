package 数组中的问题.无重复字符的最长子串;

/**
 * @Description: No.3
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @create: 2018/12/3
 * @Author: SLJ
 */
public class Solution {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s == "" || s.equals("")){
            return 0;
        }
        char[] chars = s.toCharArray();
        int result = 1;//初始化第一个值为子串并且长度为1
        int l = 0;
        int r = 0;//表示当前指向的元素

        while (l < chars.length && r + 1 < chars.length){
            r ++;
            for (int i = r - 1;i >= l;i --){
                if (chars[r] == chars[i]){
                    l = i + 1;
                }

            }
            int curResult = r - l + 1;
            result = Math.max(result, curResult);//更新result
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
