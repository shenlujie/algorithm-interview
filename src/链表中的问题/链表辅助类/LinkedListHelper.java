package 链表中的问题.链表辅助类;

/**
 * @Description: 链表相关问题的辅助类
 * @create: 2018/12/5
 * @Author: SLJ
 */
public class LinkedListHelper {
    //根据一个数组创建一个链表
    public static ListNode createLinkedList(int[] arr){
        if (arr.length == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }

    //根据链表的头节点打印整个链表
    public static void printLinkedList(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val);
            System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.print("null\n");
    }
}
