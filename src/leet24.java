//两两交换链表中的节点
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x){ val = x; }
//}
public class leet24 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode list = head;
        ListNode pre = node;
        while(list!=null&&list.next!=null){
            pre.next = list.next;
            list.next = pre.next.next;
            pre.next.next = list;
            pre = list;
            list = list.next;
        }
        return head;
    }
}
