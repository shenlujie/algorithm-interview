package 链表中的问题.两数相加;

import 链表中的问题.链表辅助类.LinkedListHelper;
import 链表中的问题.链表辅助类.ListNode;

/**
 * @Description: No.2
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @create: 2020/01/31
 * @Author: SLJ
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化结果链表
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + res.val;
            res.val = sum % 10;
            if (sum >= 10) {
                // 结果链表当前节点进位
                res.next = new ListNode(1);
            }else if ((l1 == null && l2.next == null)
                    || (l2 == null && l1.next == null)
                    || ((l1 != null && l2 != null) && (l1.next == null && l2.next == null))){
                break;
            }else {
                res.next = new ListNode(0);
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            res = res.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,0,4};
        ListNode l1 = LinkedListHelper.createLinkedList(arr1);
        LinkedListHelper.printLinkedList(l1);
        int[] arr2 = {5,6,4};
        ListNode l2 = LinkedListHelper.createLinkedList(arr2);
        LinkedListHelper.printLinkedList(l2);
        ListNode head = new Solution().addTwoNumbers(l1, l2);
        LinkedListHelper.printLinkedList(head);
    }
}
