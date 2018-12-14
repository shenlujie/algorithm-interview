package dp动态规划基础.斐波那契数列;


/**
 * @Description: 最常见也最简单的思路：递归，效率极其低下
 * @create: 2018/12/12
 * @Author: SLJ
 */
public class Solution1 {
    static int time = 0;
    public int fib(int n){

        time ++;

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        int n = 40;
        long startTime = System.nanoTime();
        int result = new Solution1().fib(n);
        long endTime = System.nanoTime();
        System.out.println("结果是：" + result);
        System.out.println("使用时间为：" + (double)(endTime - startTime)/1000000000.0);
        System.out.println("计算次数为：" + time);
    }
}
