public class leet162 {
    /*
    利用二分法查找峰值
     */
    public static int findPeakElement(int[] nums) {
//        if(nums.length==1){
//            return 0;
//        }

        return binarysearch(0, nums.length-1,nums);
    }
    public static int binarysearch(int start,int end,int[] nums){
        if(end-start<=1){
            return (nums[start] >= nums[end]) ? start : end;
        }
        int mid = (start+end)/2;
        if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]){
            return mid;
        }else if(nums[mid]<nums[mid-1]){
            return binarysearch(start,mid-1,nums);
        }else if(nums[mid]<nums[mid+1]){
            return binarysearch(mid+1,end,nums);
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        int a= findPeakElement(nums);
        System.out.println(a);
    }

}
