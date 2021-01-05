import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//二叉树层次遍历
public class leet102 {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        levelOrder(node1);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        //利用一个列表记录元素的层数
        List<Integer> list_num = new ArrayList<Integer>();
        queue.add(root);
        list_num.add(1);
        int i=0;
        while(!queue.isEmpty()){
            TreeNode x = queue.poll();
            if(i!=0&&list_num.get(i-1)!=list_num.get(i)){
                list.add(new ArrayList<>(list1));
                list1.clear();
            }

            list1.add(x.val);
            //找到当前元素的左孩子和右孩子
            if(x.left!=null){
                queue.add(x.left);
                list_num.add(list_num.get(i)+1);
            }
            if(x.right!=null){
                queue.add(x.right);
                list_num.add(list_num.get(i)+1);
            }
            i++;
        }
        list.add(list1);

        return list;
    }
}
