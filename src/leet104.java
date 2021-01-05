import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet104 {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list_num = new ArrayList<>();
        queue.add(root);
        list_num.add(1);
        int i=0;
        while(!queue.isEmpty()){
            TreeNode x = queue.poll();
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
        return list_num.get(list_num.size()-1);
    }
}
