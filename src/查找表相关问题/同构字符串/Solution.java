package 查找表相关问题.同构字符串;

import java.util.HashMap;

/**
 * @Description: No.205
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * @create: 2018/12/4
 * @Author: SLJ
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i])){
                if (tChars[i] == map.get(sChars[i])){
                    continue;
                }else {
                    return false;
                }
            }else {
                if (map.containsValue(tChars[i])){
                    return false;
                }else {
                    map.put(sChars[i],tChars[i] );
                }
            }
        }
        return true;
    }
}
