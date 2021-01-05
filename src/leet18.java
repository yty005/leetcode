import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//四数之和
/*
四数之和，前两个数利用for循环确定，然后利用双指针
 */
public class leet18 {
    public static void main(String []args){
        int nums[]={1,0,-1,0,-2,2};
        int target = 0;
        fourSum(nums,target);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list =new ArrayList<List<Integer>>();
        int n=0;
        int len =nums.length;
        for(int i=0;i<len-3;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int min = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(min>target){
                break;
            }
            int max = nums[i]+nums[len-1]+nums[len-2]+nums[len-3];
            if(max<target){
                continue;
            }
            for(int j=i+1;j<len-2;j++){
                if(j!=i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int min1 = nums[i]+nums[j]+nums[j+1]+nums[j+2];
                if(min1>target){
                    break;
                }
                int max1 = nums[i]+nums[len-1]+nums[len-2]+nums[j];
                if(max1<target){
                    continue;
                }
                int k=j+1;
                int m=len-1;

                while(k<m){
                    n=nums[i]+nums[j]+nums[k]+nums[m];

                    if(n==target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[m]));
                        k++;
                        while(k<m&&nums[k]==nums[k-1]){
                            k++;
                        }
                        while(m>k&&m<len-1&&nums[m]==nums[m+1]){
                            m--;
                        }
                    }else if(n>target){
                        m--;
                    }else{
                        k++;
                    }


                }
            }
        }
        return list;
    }
}
