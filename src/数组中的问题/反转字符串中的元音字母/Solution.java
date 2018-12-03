package 数组中的问题.反转字符串中的元音字母;

/**
 * @Description: No.345
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 元音字母：a e i o u
 * @create: 2018/12/2
 * @Author: SLJ
 */
public class Solution {
    public String reverseVowels(String s) {
        if (s.equals(null) || s == ""){
            return s;
        }
        char[] arr = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int l = 0;
        int r = arr.length - 1;
        //指针对撞
        while (true){
            if (l >= r){
                break;
            }
            if (isVowels(arr[l]) && !isVowels(arr[r])){
                r --;
            }else if (!isVowels(arr[l]) && isVowels(arr[r])){
                l ++;
            }else if (!isVowels(arr[l]) && !isVowels(arr[r])){
                l ++;
                r --;
            }else if (isVowels(arr[l]) && isVowels(arr[r])){
                char item = arr[l];
                arr[l] = arr[r];
                arr[r] = item;
                l ++;
                r --;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.toString();
    }

    //判断是否属于元音字母
    private boolean isVowels(char s){
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u' ||
                s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "Aa";
        System.out.println(new Solution().reverseVowels(s));
    }
}
