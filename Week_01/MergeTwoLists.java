/**合并两个链表
 这么难吗，第一次竟然想不清楚
 是为什么  这个递归不好想啊，还是不要想一次性就拿下比较好
 要注意边界条件的处理
 还有另一种解法
 现在本方法慢慢理解了，但是还是有点不好理解
 */

public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }else if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }
}
