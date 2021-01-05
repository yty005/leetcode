//乘最多水的容器

public class leet11 {
    public int maxArea(int[] height) {
        int max=0;
        int area=0;
        for(int i=0;i<height.length;i++){
            for(int j=i;j<height.length;j++){
                area=(j-i)*Math.min(height[i],height[j]);
                if(max<area){
                    max=area;
                }
            }
        }
        return max;
    }
    public int maxArea1(int[] height) {
        int max=0;
        int area=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            area = Math.min(height[i],height[j])*(j-i);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
            if(max<area){
                max=area;
            }
        }
        return max;
    }
}
