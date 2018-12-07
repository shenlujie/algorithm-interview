package 链表中的问题.删除链表中的节点;

import 链表中的问题.链表辅助类.LinkedListHelper;
import 链表中的问题.链表辅助类.ListNode;

/**
 * @Description: No.237
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 *     4 -> 5 -> 1 -> 9
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * @create: 2018/12/7
 * @Author: SLJ
 */
public class Solution {
    //将要删除的节点的下一个节点的值赋给该节点，删除该节点的下一个节点
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        ListNode delNext = next.next;
        node.next = delNext;
        next.next = null;
    }
}
