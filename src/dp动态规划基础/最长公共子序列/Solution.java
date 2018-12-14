package dp动态规划基础.最长公共子序列;

/**
 * @Description: 求字符串a,b中最长的公共子序列的长度
 * 例如：a = ABCDEF; B = XBDFEG
 * a、b的最长公共子序列为BDE，长度为3
 * @create: 2018/12/13
 * @Author: SLJ
 */
public class Solution {
    /*
    * 自底向上动态规划
    * 状态转移方程：m,n表示字符串a[0...m]、字符串b[0...n]
    * LCS(m,n) = m == n ? LCS(m - 1,n - 1) + 1: max( LCS(m - 1,n) , LCS(m,n - 1) )
    * */
    public int LCS(String a,String b){
        //特殊情况
        if (a.equals("") || b.equals("")){
            return 0;
        }
        int m = a.length();
        int n = b.length();
        //memo[m][n]表示以m - 1字符结尾的a和以n - 1字符结尾的b的最大公共子序列
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i + 1][j + 1] = (a.charAt(i) == b.charAt(j)) ?
                        memo[i][j] + 1 :
                        Math.max(memo[i + 1][j], memo[i][j + 1]);
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(memo[i][j] + "\t");
            }
            System.out.println();
        }
        return memo[m][n];
    }

    public static void main(String[] args) {
        String a = "ABCDEF";
        String b = "XBDFEG";
        System.out.println(new Solution().LCS(a, b));
    }
}
