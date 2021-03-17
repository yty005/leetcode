import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class JZ07 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < preorder.length; i++) {
            list.add(preorder[i]);
        }
        return tree(list,inorder,0, inorder.length-1);

    }
    public static TreeNode tree(List<Integer> list,int[] ino,int start,int end){
        if(list.size()==0||start>end){
            return null;
        }
        TreeNode node = new TreeNode(list.get(0));

        if(start==end){
            list.remove(0);
            return node;
        }
        int i=0;
        for(i=start;i<=end;i++){
            if(ino[i]==list.get(0)){
                break;
            }
        }
        list.remove(0);
        node.left = tree(list, ino,start,i-1);

        node.right = tree(list, ino,i+1,end);
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,1,20,15,7};
        int[] ino = {1,9,3,15,20,7};
        buildTree(pre,ino);
    }
}
