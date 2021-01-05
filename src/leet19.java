//删除列表的倒数第n个结点
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 1 2 3 4 5  -> 1 2 3 5
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x){ val = x; }
//}
public class leet19 {
    public static void main(String []args){
        ListNode head=new ListNode(1);
        ListNode head1=new ListNode(2);
        head.next = head1;
//        ListNode head2=new ListNode(3);
//        head1.next = head2;
//        ListNode head3=new ListNode(4);
//        head2.next = head3;
//        ListNode head4=new ListNode(5);
//        head3.next = head4;

        removeNthFromEnd(head,2);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针，第一个指针先遍历，当第一个指针和第二个指针的距离为n+1时，两个指针一起运动，当
        //第一个指针到达末尾时，第二个指针正好指在倒数第n+1个元素上
        ListNode node = head;
        ListNode pre = head;
        int len = 0;
        if(head.next == null){
            return null;
        }
        while(node!=null){
            if(len>=n+1){
                pre = pre.next;
            }
            node = node.next;
            len++;
        }
        if(len == n){
            head =head.next;
            return head;
        }
        pre.next = pre.next.next;
        return head;
    }
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode node = head;
        ListNode pre = head;
        int len = 0;
        int tmp = 0;
        while(node.next!=null){//计算链表长度
            node = node.next;
            len++;
        }
        len++;

        node =head;
        int forword = len-n+1;
        if(forword == 1){
            head = head.next;
            return head;
        }
        //System.out.print(forword);
        while(node!=null){//找到forword的前一个节点
            tmp++;
            if(forword == tmp){
                System.out.print(tmp);
                pre.next = node.next;
                break;
            }
            pre =node;
            node = node.next;

        }
        return head;
    }
}
