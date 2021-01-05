import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//从前序与中序遍历构造二叉树
public class leet105 {
    public static void main(String[] args){
        int[] pre = {0,-121,248,-88};
        int[] ino = {-121,-88,248,0};
        buildTree1(pre,ino);
    }

    /*
    构建二叉树：
    首先遍历LDR，确定当前节点，判断当前节点在根节点的左边还是右边，以此确定进行构建
     */
    //错误
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();//存值
        Stack<Integer> stack_num = new Stack<Integer>();//存坐标
        TreeNode[] node = new TreeNode[preorder.length];
        for(int i=0;i<preorder.length;i++){
            node[i] = new TreeNode(0);
        }
        int pre = 0;//记录上一个元素的位置坐标
        node[0].val = preorder[0];
        stack.push(node[0]);
        for(int i=0;i<inorder.length;i++){
            if(preorder[0]==inorder[i]){
                stack_num.push(i);
                break;
            }
        }
        int k=1;
        for(int i=1;i< preorder.length;i++){
            for(int j=0;j< inorder.length;j++){//找存入元素的坐标位置
                if(preorder[i]==inorder[j]){
                    node[k].val = preorder[i];
                    if(stack_num.size()>1){
                        for(int a = 0;a<stack.size();a++) {
                            if(stack_num.elementAt(a)==stack_num.size()-a-1){
                                int sum = stack_num.size()-1;
                                while(sum<stack_num.elementAt(a)){
                                    stack.pop();
                                    stack_num.pop();
                                    sum++;
                                }

                            }
                        }
                    }
                    if(j<stack_num.peek()){
                        stack.peek().left = node[k];
                    }else{
                        stack.peek().right = node[k];
                    }
                    stack.push(node[k]);
                    stack_num.push(j);
                    k++;
                    break;
                }
            }

        }
        return node[0];
    }
    /*
    构建二叉树
    设置一个列表，列表中存入当前子树的所有节点
     */
    public static TreeNode buildTree1(int[] preorder,int[] inorder){
        if(preorder.length==0){
            return null;
        }
        List<Integer> list_pre = new ArrayList<Integer>();
        for(int i=0;i< preorder.length;i++){
            list_pre.add(preorder[i]);
        }
        List<Integer> list_ino = new ArrayList<Integer>();
        for(int i=0;i< inorder.length;i++){
            list_ino.add(inorder[i]);
        }
        return binaryTree(list_pre,list_ino);

    }
    public static TreeNode binaryTree(List<Integer> list_pre,List<Integer> list_ino){
        TreeNode node = new TreeNode(list_pre.get(0));
        int i=0;
        for(i=0;i< list_ino.size();i++){
            //System.out.println(list_pre.get(0));
            if(list_ino.get(i).equals(list_pre.get(0))){
                break;
            }
        }
        list_pre.remove(0);
        if(i!=0){
            List<Integer> left = list_ino.subList(0,i);
            node.left = binaryTree(list_pre,left);//左子树
        }
        if(i!=list_ino.size()-1){
            List<Integer> right = list_ino.subList(i+1,list_ino.size());
            node.right = binaryTree(list_pre,right);//右子树
        }
        return node;
    }
}
