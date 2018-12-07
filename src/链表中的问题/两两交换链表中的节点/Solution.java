package 链表中的问题.两两交换链表中的节点;

import 链表中的问题.链表辅助类.LinkedListHelper;
import 链表中的问题.链表辅助类.ListNode;

/**
 * @Description: No.24
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @create: 2018/12/5
 * @Author: SLJ
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            p.next = node2;
            node2.next = node1;
            node1.next = next;

            p = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode head = LinkedListHelper.createLinkedList(arr);
        LinkedListHelper.printLinkedList(head);
        ListNode head1 = new Solution().swapPairs(head);
        LinkedListHelper.printLinkedList(head1);
    }
}
