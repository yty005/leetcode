/*
给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
k是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
/*class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}*/
public class leet25 {
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        reverseKGroup(node1,2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode node = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode list = head;
        int i = 1;
        while(i<k){//找到list所处位置
            if(list == null){
                break;
            }
            list = list.next;
            i++;
        }
        if(list == null){
            return pre.next;
        }
        ListNode later = list.next;
        int j=1;
        while(j<k){
            pre.next = node.next;
            node.next = list.next;
            list.next = node;
            node = pre.next;
            j++;
        }
        ListNode list1 = reverseKGroup(later,k);
        head.next = list1;
        return pre.next;
    }
}
