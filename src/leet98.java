import java.util.ArrayList;
import java.util.List;

public class leet98 {
    /*
    对二叉树进行遍历，判断左孩子是否小于根节点，右孩子是否大于根节点
    错误，eg:
            5
              \
               10
              /
             7
     */
    public boolean isValidBST(TreeNode root) {
        return DLR1(root);
    }
    public static boolean DLR1(TreeNode root){
        TreeNode node = root;
        if(node.left!=null){
            if(node.left.val< node.val){
                DLR1(node.left);
            }else{
                return false;
            }
        }
        if(node.right!=null){
            if(node.right.val>node.val){
                DLR1(node.right);
            }else{
                return false;
            }
        }
        return true;
    }
    /*
    考虑前序遍历，若为递增序列则为二叉搜索数
     */
    public boolean isValidBST1(TreeNode root) {
        if(root==null){
            return true;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        DLR(root,list);
        if(list.size()==1){
            return true;
        }
        //判断list列表中元素是否为增序
        for(int i=1;i< list.size();i++){
            if(list.get(i-1).val>=list.get(i).val){
                return false;
            }
        }
        return true;
    }
    public static void DLR(TreeNode root, List<TreeNode> list){
        TreeNode node = root;
        if(node.left!=null){
            DLR(node.left,list);
        }
        list.add(node);
        if(node.right!=null){
            DLR(node.right,list);
        }
    }
}
