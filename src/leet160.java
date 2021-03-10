//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
public class leet160 {
    /*
    相交链表 1走完a路径后走b路径 2走完b路径后走a路径，相遇节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = new ListNode(0);
        ListNode B = new ListNode(0);
        A.next = headA;
        B.next = headB;
        while(A.next!=null||B.next!=null){
            if(A.next==null){
                A.next = headB;
            }
            if(B.next==null){
                B.next = headA;
            }
            if(A.next!=B.next){
                A = A.next;
                B = B.next;
            }else{
                return A.next;
            }
        }
        return null;
    }
}
