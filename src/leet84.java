public class leet84 {
    //内存溢出
    public int largestRectangleArea(int[] heights) {
        //设置dp，dp[i][j] 表示 第i个到第j个的最大面积
        int[][] dp = new int[heights.length][heights.length];
        int max = heights[0];
        for(int i=0;i<heights.length;i++){
            int min = heights[i];
            for(int j=i;j<heights.length;j++){
                if(min>heights[j]){
                    min = heights[j];
                }
                dp[i][j] = (j-i+1) * min;
                if(max<dp[i][j]){
                    max = dp[i][j];
                }
            }
        }

        return max;
    }
    //设置dp[i] 表示 前i个元素的最大面积
    //回溯
    public int largestRectangleArea1(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        int[] dp = new int[heights.length];
        dp[0] = heights[0];
        int area = heights[0];//记录循环过程中的面积
        int min = 0;//记录之间的最小高度
        //设置指针i，j表示区间   设置min表示区间内的最小值
        return 0;
    }
}
