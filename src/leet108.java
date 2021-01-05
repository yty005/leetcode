import java.util.ArrayList;
import java.util.List;

public class leet108 {
    public static void main(String[] args){
        int[] nums = {-10,-3,0,2,9};
        sortedArrayToBST(nums);
    }

    /*
    构建二叉搜索数
    找出数组最中心的元素（若最中心为两个元素，则选择左边元素），递归
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i< nums.length;i++){
            list.add(nums[i]);
        }
        BinarySearch(list);
        return null;
    }
    public static TreeNode BinarySearch(List<Integer> list){
        int mid = list.size()/2;
        TreeNode node = new TreeNode(list.get(mid));
        if(mid!=0){
            node.left = BinarySearch(list.subList(0,mid));
        }
        if(mid!=list.size()-1){
            node.right = BinarySearch(list.subList(mid+1,list.size()));
        }
        return node;
    }
}
