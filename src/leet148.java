//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
public class leet148 {
    //排序链表
    //归并排序 找出链表的中点
    public static ListNode sortList(ListNode head) {

        return sortlist(head);
    }
    public static ListNode sortlist(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        while(q.next!=null&&q.next.next!=null){//找出链表的中点 p表示链表中点
            p = p.next;
            q = q.next.next;
        }
        ListNode mid1 = p.next;
        p.next = null;
        return merge(sortlist(head),sortlist(mid1));
        //return head;
    }
    public static ListNode merge(ListNode head1,ListNode head2){
        ListNode node = new ListNode(0);
        ListNode head = node;
        ListNode p = head1;
        ListNode q = head2;
        while(p!=null&&q!=null){
            if(p.val<q.val){
                node.next = p;
                p = p.next;
            }else{
                node.next = q;
                q = q.next;
            }
            node = node.next;
        }
        if(p!=null){
            node.next = p;
        }
        if(q!=null){
            node.next = q;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(4);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(1);
        A.next = B;
        B.next = C;
        C.next = D;
        sortList(A);
    }
}
