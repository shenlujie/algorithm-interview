package 链表中的问题.反转一个链表;

import 链表中的问题.链表辅助类.LinkedListHelper;
import 链表中的问题.链表辅助类.ListNode;

/**
 * @Description: No.206
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @create: 2018/12/5
 * @Author: SLJ
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//头节点head的前序节点prev
        ListNode cur = head;//头节点head为当前节点
        while (cur != null){
            ListNode next = cur.next;//头节点head.next为后继节点
            /*反转操作
            * 当前的next指向prev
            * prev指向cur
            * cur指向最初的next
            * */
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //循环结束后，cur指向原来链表的最后一个节点的下一个节点，也就是null
        //所以此时prev就是头节点
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = LinkedListHelper.createLinkedList(arr);
        LinkedListHelper.printLinkedList(head);
        ListNode head1 = new Solution().reverseList(head);
        LinkedListHelper.printLinkedList(head1);

    }
}
