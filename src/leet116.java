class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class leet116 {
    public Node connect(Node root) {
        Node node = root;
        Node first = root;
        node.next=null;
        while(node!=null){
            if(node.right!=null){
                node.left.next = node.right;
            }else{
                node.left = null;
            }
            if(node.next!=null){
                node.right.next = node.next.left;
            }else{
                node.right.next = null;
            }
            if(node.next!=null){//同一行
                node = node.next;
            }else{//换行
                node = first.left;
                first = node;
            }
        }
        return node;
    }
}
