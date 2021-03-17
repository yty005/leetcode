class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class JZ06 {
    //剑指 Offer 06. 从尾到头打印链表
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int length = 0;
        while(p!=null){
            length++;
            p = p.next;

        }
        int[] node = new int[length];
        p = head;
        for(int i=length-1;i>=0;i--){
            node[i]=p.val;
            p = p.next;
        }
        return node;
    }
}
