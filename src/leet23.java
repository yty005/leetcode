//合并k个升序链表
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class leet23 {
    public static void main(String []args){
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(4);
        list1.next = list2;
        ListNode list3 = new ListNode(5);
        list2.next = list3;
        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(3);
        list4.next = list5;
        ListNode list6 = new ListNode(4);
        list5.next = list6;
        ListNode list7 = new ListNode(2);
        ListNode list8 = new ListNode(6);
        list7.next = list8;
        ListNode list[]={list1,list4,list7};
        mergeKLists(list);
    }

    public static ListNode mergeKLists(ListNode[] lists) {//先比较前两个列表，然后将比较好的链表与其他链表继续比较
        ListNode list =new ListNode(0);//定义头节点
        ListNode head =list;
        //ListNode num[] = new ListNode[];
        int len = lists.length;
        if(lists.length==1){
            return list = lists[0];
        }
        if(lists.length==0){
            return null;
        }
        int j = 1;
        //首先合并两个链表，然后利用合并后的链表和剩余链表进行比较
        list.next = lists[0];
//        ListNode pre = list;
//        list =list.next;
        while(j<len){
            ListNode pre = head;
            list =pre.next;
            while(list!=null&&lists[j]!=null){
                if(list.val<lists[j].val){
                    list = list.next;
                    pre = pre.next;
                }else{
                    pre.next = lists[j];
                    lists[j] = lists[j].next;
                    pre.next.next = list;
                    pre = pre.next;
                }
            }
//            if(list!=null){
//
//            }
            if(lists[j]!=null){
                pre.next = lists[j];
            }
            j++;
        }
        return head.next;
    }
}
