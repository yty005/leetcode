public class leet300 {
    public static void main(String[] args){
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS1(nums);
    }
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max =1;
        for(int i=1;i< nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            if(max<dp[i]){
                max = dp[i];
            }
        }
        return max;
    }

    public static int lengthOfLIS1(int[] nums) {
        int[] stack= new int[nums.length];
        stack[0] = nums[0];
        int n=0;//表示stack栈顶
        int i=1;
        while(i<nums.length){
            if(nums[i]>stack[n]){
                n++;
                stack[n] = nums[i];
            }else{
                for(int j=0;j<=n;j++){
                    if(nums[i]<stack[j]){
                        stack[j] = nums[i];
                        break;
                    }
                }
            }
            i++;
        }
        return n+1;
    }
}
