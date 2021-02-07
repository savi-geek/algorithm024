/**
 * @author linaluo
 * @date 2021/1/28 11:39 上午
 * 25. K 个一组翻转链表
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode begin = null;
        if(head == null || head.next == null || k==1){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        begin = dummyHead;
        int i=0;
        while (head != null){
            i++;
            if(i%k==0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode reverse(ListNode begin, ListNode end){
        ListNode curr = begin.next;
        ListNode prev = begin;
        ListNode first = curr;
        ListNode next = null;
        while (curr != end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = end;
        return first;
    }
}
