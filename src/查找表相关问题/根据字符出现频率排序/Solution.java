package 查找表相关问题.根据字符出现频率排序;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: No.451
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * @create: 2018/12/4
 * @Author: SLJ
 */
public class Solution {
    //自己思路有瓶颈，网上找了答案，HashMap存词频，list对HashMap中的entry进行排序
    public String frequencySort(String s) {
        char[] sChars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i])){
                map.replace(sChars[i], map.get(sChars[i]) + 1);
            }else {
                map.put(sChars[i], 1);
            }
        }
        ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character,Integer> entry:list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
