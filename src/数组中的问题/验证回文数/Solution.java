package 数组中的问题.验证回文数;

/**
 * @Description: No.125
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * @create: 2018/12/2
 * @Author: SLJ
 */
public class Solution {
    /*
    首先想到的思路：开辟一个新字符串，将原字符串中的所有字母和数字添加到该字符串中；
    将该新字符串转化成数组，利用两个指针碰撞检测
    * */
    public boolean isPalindrome(String s) {
        if(s.equals(null)){
            return true;
        }
        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 48 && chars[i] <= 57) || (chars[i] >= 97 && chars[i] <= 122)){
                stringBuilder.append( chars[i]);
            }
        }
        char[] vector = stringBuilder.toString().toCharArray();
        int l = 0;
        int r = vector.length-1;
        while (l <= r){
            if (vector[l++] != vector[r--]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "123456";
        System.out.println(new Solution().isPalindrome(s));
    }
}
