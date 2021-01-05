//有重复数字的有序数组的二分查找
public class NC105 {
    public static void main(String[] args){
        int[] a = {2,3,4,4,4,7,7,8,10,10,11,12,13,14,15,15,17,18,19,23,24,24,24,24,25,26,26,26,27,27,28,29,29,30,33,36,38,38,40,40,41,43,43,43,44,46,46,47,51,52,52,53,54,56,57,57,57,58,58,61,61,61,62,64,64,66,66,67,67,67,70,72,74,74,74,75,75,78,78,78,79,79,80,83,83,83,83,84,84,86,88,89,89,90,91,91,92,93,93,96};
        upper_bound_(100,1,a);
    }
    public static int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int end = n-1;
        int start = 0;
        int mid = -1;
        while(start<end){
            mid = (start+end)/2;
            if(a[mid]==v){//找到第一个，重复的舍去
                end = mid;
                continue;
            }else if(v<a[mid]){
                end = mid - 1;
            }else if(v>a[mid]){
                start = mid + 1;
            }
        }
        if(a[start]==v){
            return start+1;
        }
        return n+1;
    }
}
