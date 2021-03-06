import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet103 {
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
        zigzagLevelOrder(node1);
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list_num = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        list_num.add(1);
        int i=0;
        boolean flag = false;//false从左向右 true从右向左
        while(!queue.isEmpty()){
            if(list_num.get(i)%2==0){
                flag = true;
            }else{
                flag = false;
            }
            TreeNode x = queue.poll();
            if(i!=0&&list_num.get(i-1)!=list_num.get(i)){
                list.add(new ArrayList<>(list1));
                list1.clear();
            }

            if(!flag){
                list1.add(x.val);
            }else{
                list1.add(0,x.val);
            }
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
