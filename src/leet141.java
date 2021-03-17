//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
public class leet141 {
    //1.利用hashmap将节点位置存入，然后每次比较当前指向节点在hashmap中是否存在即可
    //2.利用快慢指针进行判断，若链表中无环，则两个指针永远不会相遇，若链表中存在环，则两个指针在链表中一定会相遇
    public boolean hasCycle(ListNode head) {
        ListNode p = head;//兔子指针
        ListNode q = head.next;//乌龟指针
        while(p!=null&&q!=null&&q!=p){
            p = p.next;
            q = q.next;
            if(q!=p){
                q = q.next;
            }
        }
        if(q==p){
            return true;
        }
        return false;
    }
}
