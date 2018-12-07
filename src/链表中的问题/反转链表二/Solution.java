package 链表中的问题.反转链表二;

import 链表中的问题.链表辅助类.LinkedListHelper;
import 链表中的问题.链表辅助类.ListNode;

/**
 * @Description: No.92
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @create: 2018/12/5
 * @Author: SLJ
 */
public class Solution {
    //思路拥堵，没做上来，评论区带佬的思路
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prevStart = dummyHead;//prevStart是m的前一个节点
        ListNode nextEnd;//nextEnd是n的下一个节点
        //cur和next是要反转的两个节点
        ListNode cur;
        ListNode next;
        for (int i = 0; i < m - 1; i++) {
            prevStart = prevStart.next;//head是m的前一个节点
        }
        cur = prevStart.next;
        next = cur.next;
        nextEnd = next;
        //从m节点开始反转
        for (int i = m; i < n; i++) {
            nextEnd = next.next;
            next.next = cur;
            cur = next;
            next = nextEnd;
        }
        prevStart.next.next = nextEnd;
        prevStart.next = cur;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = LinkedListHelper.createLinkedList(arr);
        LinkedListHelper.printLinkedList(head);
        ListNode head1 = new Solution().reverseBetween(head,2,4);
        LinkedListHelper.printLinkedList(head1);
    }
}

