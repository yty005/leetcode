//最接近的三数之和
public class leet16 {
    public static void main(String []args){
        int num[]={-1,2,1,-4};
        threeSumClosest(num,1);
    }
    public static int threeSumClosest(int[] nums, int target) {
        int n=nums[0]+nums[1]+nums[2];
        int min=10000;//最接近的值和target之间的差值
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int k=j+1;
                while(k<nums.length){
                    if(min>Math.abs(target-nums[i]-nums[j]-nums[k])){
                        min=Math.abs(target-nums[i]-nums[j]-nums[k]);
                        n=nums[i]+nums[j]+nums[k];
                    }
                    k++;
                }
            }
        }
        return n;
    }
}
