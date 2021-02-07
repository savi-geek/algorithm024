import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author linaluo
 * @date 2021/1/28 10:39 上午
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 */
public class LinkedListCycle {

    /**
     * 方法一，通过哈希判断是否有重复节点
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            //当set中添加head不成功时，即返回false时，说明set中已经包含该节点
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
