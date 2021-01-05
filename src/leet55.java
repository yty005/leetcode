//跳跃游戏
/*
从后像前推，若某位置需要到达，dp[i][j]表示第i个元素能否到达第j个元素
 */
public class leet55 {
    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};
        canJump(nums);
    }
    //动态规划
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0]=true;
        for(int i=1;i< nums.length;i++){
            for(int j=0;j< i;j++){
                if(nums[j]+j>=i&&dp[j]==true){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
    //贪心算法
    public static boolean canJump1(int[] nums){
        int max = 0;
        for(int i=0;i< nums.length;i++){
            if(i<=max){
                max = Math.max(max,nums[i]+i);
            }
            if(max>= nums.length-1){
                return true;
            }
        }
        return false;
    }

}
