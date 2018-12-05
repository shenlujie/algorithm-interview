package 查找表相关问题.单词模式;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: No.290
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 *
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * @create: 2018/12/3
 * @Author: SLJ
 */
public class Solution {

    //问题的关键在于边界的判断、pattern每个字母对应的String是唯一的
    public boolean wordPattern(String pattern, String str) {
        if (str.equals("")){
            return false;
        }
        HashMap<Character,String> map = new HashMap<>();
        char[] patternChars = pattern.toCharArray();
        String[] strings = str.split(" ");
        if (patternChars.length != strings.length){
            return false;
        }
        for (int i = 0; i < patternChars.length; i++) {
            if (map.containsKey(patternChars[i])){
                if (map.get(patternChars[i]).equals(strings[i])){
                    continue;
                }else {
                    return false;
                }
            }else {
                //可能存在这种情况，就是pattern中的字母不同，但对应的string确实相同的，这种情况false
                if (map.containsValue(strings[i])){
                    return false;
                }else {
                    map.put(patternChars[i],strings[i] );
                }
            }
        }
        return true;
    }
}
