import org.w3c.dom.NodeList;

import java.util.List;

/**
 * @author linaluo
 * @date 2021/1/27 6:53 下午
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    /**
     * 递归
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param head
     * @return
     */
    public ListNode method1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = method1(next.next);
        next.next = head;
        return next;
    }

    /**
     * 迭代
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode method2(ListNode head){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode tmp = dummyNode;
        while (tmp.next != null && tmp.next.next != null){
            ListNode node1 = tmp.next;
            ListNode node2= tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return tmp.next;
    }

}
