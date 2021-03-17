//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
public class leet206 {
    public ListNode reverseList(ListNode head) {
        ListNode head0 = new ListNode(0);
        head0.next = head;
        ListNode node = head;
        while(node.next!=null){//将head后面的节点插入到头节点之后
            ListNode p = node.next;
            node.next = p.next;
            p.next = head0.next;
            head0.next = p;
        }
        return head0.next;
    }
}
