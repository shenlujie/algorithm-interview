package 数组中的问题.二分查找法;

/**
 * @Description:
 * @create: 2018/11/30
 * @Author: SLJ
 */
public class BinarySearch<T extends Comparable> {

    public int binarySearch(T[] arr,int n,T target){
        int l = 0;
        int r = n - 1;

        while (l <= r){
            int mid = l + (r - l)/2;
            if (arr[mid] == target){
                return mid;
            }

            if (target.compareTo(arr[mid]) > 0){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,5,43,56,64,65};
        System.out.println(new BinarySearch<Integer>().binarySearch(arr, arr.length, 56));
    }
}
