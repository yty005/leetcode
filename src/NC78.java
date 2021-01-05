class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class NC78 {
    public ListNode ReverseList(ListNode head) {
        ListNode node = new ListNode(0);
        if(head==null){
            return null;
        }
        ListNode p = head.next;
        node.next = head;
        while(head.next!=null){
            head.next = p.next;
            p.next = node.next;
            node.next = p;
            p = head.next;
        }

        return node.next;
    }
}
