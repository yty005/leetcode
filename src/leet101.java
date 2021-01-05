import java.util.ArrayList;
import java.util.List;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
public class leet101 {
    //中序遍历所得的字符串是回文字符串
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        node4.left = node6;
        node5.left = node7;
        isSymmetric(node1);
    }
    /*
    错误解法，仅通过中序遍历无法知道二叉树的形状
    特殊用例[5,4,1,null,1,null,4,2,null,2,null]
     */
    public static boolean isSymmetric1(TreeNode root) {
        List<String> list = new ArrayList<String>();
        LDR(root,list);
        for(int i=0;i<list.size()/2;i++){

            if(!list.get(i).equals(list.get(list.size()-1-i))){
                return false;
            }
        }
        return true;
    }
    //中序遍历二叉树
    public static void LDR(TreeNode root, List<String> list){
        TreeNode node = root;
        if(node.left!=null){
            LDR(node.left,list);
        }
        if(node.left==null&&node.right!=null){
            list.add("null");
        }
        list.add(String.valueOf(node.val));
        if(node.right==null&&node.left!=null){
            list.add("null");
        }
        if(node.right!=null){
            LDR(node.right,list);
        }


    }
/*
设定两个指针，分别指向最左节点与最右节点，按照LDR 和 RDL分别遍历，比较两个指针当前所指的节点的值是否相等
 */
    public static boolean isSymmetric(TreeNode root) {



        return false;
    }
}
