import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
    public DLinkedNode() {}
    public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
}
public class leet146 {
    /*
    利用hash中存储链表的节点，达到效果
    在双向链表中头部为不常使用节点，尾部为最新使用节点，从头节点处删除，尾节点处插入
     */
    private int initcapacity;
    private int num;
    private DLinkedNode head;
    private DLinkedNode tail;
    private HashMap<Integer,DLinkedNode> map;
    public leet146(int capacity) {//LRUCache   hashmap中存储key和节点位置 双向链表中存储key和value
        HashMap<Integer,DLinkedNode> map = new HashMap<Integer, DLinkedNode>();
        this.map = map;
        this.initcapacity = capacity;
        this.num = 0;
        DLinkedNode head = new DLinkedNode(0,0);
        DLinkedNode tail = new DLinkedNode(0,0);
        this.head = head;
        this.tail = tail;
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            //从双向链表中删除节点
            map.get(key).prev.next = map.get(key).next;
            map.get(key).next.prev = map.get(key).prev;
            //将节点连接在尾节点上
            tail.prev.next = map.get(key);
            map.get(key).prev = tail.prev;
            map.get(key).next = tail;
            tail.prev = map.get(key);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            //从双向链表中删除节点
            map.get(key).prev.next = map.get(key).next;
            map.get(key).next.prev = map.get(key).prev;
            //将节点连接在尾节点上
            tail.prev.next = map.get(key);
            map.get(key).prev = tail.prev;
            map.get(key).next = tail;
            tail.prev = map.get(key);
        }else{
            if(num<initcapacity){
                DLinkedNode node = new DLinkedNode(key,value);
                tail.prev.next = node;
                node.prev = tail.prev;
                node.next = tail;
                tail.prev = node;
                map.put(key,node);
                num++;
            }else{
                //删除双向链表中最前面的元素
                head.next.next.prev = head;
                map.remove(head.next.key);
                head.next = head.next.next;

                //添加元素
                DLinkedNode node = new DLinkedNode(key,value);
                tail.prev.next = node;
                node.prev = tail.prev;
                node.next = tail;
                tail.prev = node;
                map.put(key,node);

            }
        }
    }
}
