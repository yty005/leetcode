//搜索旋转排序数组
public class leet33 {
    public static void main(String[] args) {
        int[] nums={0,1,2,4,5,6,7};
        int target = 1;
        search(nums,target);
    }
    public static int search(int[] nums, int target) {
        //比较首尾两个元素，即可知道是否发生旋转
        //int flag = -1;
//        if(nums.length>1){
//            flag = binarysearch(0,nums.length,target,nums);
//
//        }
        if(nums==null||nums.length==0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        int mid=0;
        while(start<=end){
            mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[start]<=nums[mid]){
                if(target>=nums[start]&&target<nums[mid]){//有序
                    end = mid-1;
                }else{//无序
                    start = mid + 1;
                }
            }else{
                if(target<=nums[end]&&target>nums[mid]){//有序
                    start = mid + 1;
                }else{//无序
                    end = mid - 1;
                }

            }
        }


        return -1;
    }
    public static int binarysearch(int begin,int leave,int target,int[] num){//二分查找
        int mid = (begin+leave)/2;
        int flag = -1 ;
        if(num[mid] == target){
            return mid;
        }else if(num[mid]>target){
            flag = binarysearch(begin,mid-1,target,num);
        }else{
            flag = binarysearch(mid+1,leave,target,num);
        }
        return flag;
    }

}

