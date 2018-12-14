package 递归和回溯法.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: No.17
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * @create: 2018/12/11
 * @Author: SLJ
 */
public class Solution {
    private static final String[] STRINGMAPS = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        //digits为空
        if (digits.equals("")){
            return result;
        }
        findCombinations(digits,0,"");
        return result;
    }
    //递归方法，digits是输入的数字字符串，index是digits中的索引，s是最终生成的字符串
    private void findCombinations(String digits,int index,String s){
        //递归边界，当索引遍历到digits末尾时，s就已经完整的生成了
        if (index == digits.length()){
            result.add(s);
            return;
        }

        char[] num = digits.toCharArray();
        char digit = num[index];//得到字符串中的号码
        char[] items = STRINGMAPS[digit - '0'].toCharArray();//根据字典查出号码对应的字母字符串
        for (int i = 0; i < items.length; i++) {//遍历这些字母
            findCombinations(digits, index + 1, s + String.valueOf(items[i]));
        }


    }

    public static void main(String[] args) {
        String digits = "234";
        for (String s:new Solution().letterCombinations(digits)) {
            System.out.println(s);
        }
    }
}
