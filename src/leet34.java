public class leet34 {
    //要求时间复杂度为logn，使用二分查找
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            int[] a = {-1,-1};
            return a;
        }
        int start = 0;
        int end = nums.length-1;
//        int start1 = 0;
//        int end1 = 0;
        //找第一个元素
        while(start<=end){
            int mid = (start+end)/2;
            if(target<=nums[mid]){
                end = mid-1;
            }else if(target>nums[mid]){
                start = mid+1;
            }else if(nums[mid]==target){
                //找第一个元素,缩小区间
                end = mid;
            }
        }
        int[] sum =new int[2];
        if(start>nums.length-1||nums[start]!=target){//判断start是否超出区间，判断数组中是否存在目标值
            sum[0]=-1;
            sum[1]=-1;
            return sum;
        }else{
            sum[0]=start;
        }

        //寻找最后一个元素
        start = 0;
        end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(target<nums[mid]){
                end = mid-1;
            }else if(target>=nums[mid]){
                start = mid+1;
            }else if(nums[mid]==target){
                //找到最后一个元素
                start=mid;
            }
        }
        sum[1]=end;
        return sum;
    }
}
