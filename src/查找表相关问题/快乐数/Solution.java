package 查找表相关问题.快乐数;

import java.util.HashSet;

/**
 * @Description: No.202
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * @create: 2018/12/3
 * @Author: SLJ
 */
public class Solution {
    /*
    * 毫无头绪，查阅资料得到的答案
    * 第一版：将n以及之后得到的每一个数存到set中，当set中再次存入相同数据时，则说明n陷入了循环，false
    * 当得到的下一个数是1，则是快乐数true
    * */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (true){
            n = getNext(n);
            if (n == 1){
                return true;
            }else if (set.contains(n)){
                return false;
            }else if (!set.contains(n) && n != 1){
                set.add(n);
            }
        }
    }

    //计算出n的下一个值
    private int getNext(int n){
        int result = 0;
        while (n > 0){
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(new Solution().isHappy(n));
    }
}
