package 查找表相关问题.有效的字母异位词;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description: No.242
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * @create: 2018/12/3
 * @Author: SLJ
 */
public class Solution {

    //第一版使用HashMap
    public boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < charS.length; i++) {
            if (map.containsKey(charS[i])){
                map.put(charS[i],map.get(charS[i]).intValue() + 1);
            }else {
                map.put(charS[i], 1);
            }
        }

        for (int i = 0; i < charT.length; i++) {
            if (map.containsKey(charT[i])){
                if (map.get(charT[i]).intValue() > 1){
                    map.put(charT[i],map.get(charT[i]).intValue() - 1 );
                }else {
                    map.remove(charT[i]);
                }
            }else {
                return false;
            }
        }
        return map.isEmpty() ? true : false;
    }

    //使用Array.sort进行排序，然后比较排序后的s和t
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] != charT[i]){
                return false;
            }
        }
        return true;
    }
}
