class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class leet148 {
    //排序链表
    //归并排序 找出链表的中点
    public ListNode sortList(ListNode head) {
        ListNode p = new ListNode(0);
        ListNode q = new ListNode(0);
        p.next = head;
        q.next = head;
        while(q.next!=null&&q.next.next!=null){//找出链表的中点
            p = p.next;
            q = q.next.next;
        }
        return null;
    }
}
