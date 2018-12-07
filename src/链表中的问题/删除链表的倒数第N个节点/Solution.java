package 链表中的问题.删除链表的倒数第N个节点;

import 链表中的问题.链表辅助类.ListNode;

import java.util.List;

/**
 * @Description: No.19
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 * @create: 2018/12/7
 * @Author: SLJ
 */
public class Solution {
    //使用双指针,滑动窗口思路
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode dummyStart = dummyHead;
        ListNode end = head;
        for (int i = 0; i < n - 1; i++) {
            end = end.next;
        }
        //此时end已经是第n个元素了，dummyStart的下一个元素是第一个元素
        while (end.next != null){
            dummyStart = dummyStart.next;
            end = end.next;
        }
        //此时end已经是最后一个元素了，dummyStart是倒数第n个节点的前一个节点
        //删除dummyStart的后一个节点start节点就可以了
        ListNode start = dummyStart.next;
        ListNode next = start.next;
        dummyStart.next = next;
        start.next = null;
        return dummyHead.next;
    }
}
