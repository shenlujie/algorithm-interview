package 数组中的问题.盛最多水的容器;


/**
 * @Description: No.11
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * @create: 2018/12/3
 * @Author: SLJ
 */
public class Solution {
    //首先想到的是暴力一下,将所有情况全部列出来加入最大堆中，取出最大值,结果超时了
    /*public int maxArea(int[] height) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1;j < height.length;j ++){
                int min = Math.min(height[i],height[j] );
                int item = (j - i)*min;
                maxHeap.add(item);
            }
        }
        return maxHeap.extractMax();
    }*/

    //对撞指针，另开辟一个空间来维护一个容量值并使之始终保持最大
    //指针l和r始终向着增大的那一方靠拢
    public int maxArea(int[] height) {
        int capacity = 0;//维护最大容量
        int l = 0;//初始化左指针
        int r = height.length - 1;//初始化右指针
        while (l < r){
            int len = r - l;
            int hei = Math.min(height[l],height[r] );
            int curCapacity = len * hei;
            capacity = Math.max(capacity, curCapacity);
            if (height[l] < height[r]){
                l ++;
            }else {
                r --;
            }
        }
        return capacity;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }
}
