import java.util.*;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
public class leet94 {
    public List<Integer> inorderTraversal(TreeNode root) {//递归
        List<Integer> list = new ArrayList<>();
        mid(root,list);

        return list;
    }
    public static TreeNode mid(TreeNode root,List<Integer> list){//根左右
        list.add(root.val);
        if(root.left!=null){
            mid(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null){
            mid(root.right,list);
        }
        return root;
    }
    public List<Integer> inorderTraversal1(TreeNode root){//迭代
        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> stack = new ArrayList<TreeNode>();


        return list;
    }
}
