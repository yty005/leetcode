public class leet136 {
    /*
    1.
    利用hash表进行查找
     */

    /*2.
    使用位运算，利用异或对重复元素进行处理
    两个相同元素异或为0
    0与其他元素异或为其他元素
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum  ^ nums[i];
        }
        return sum;
    }
}
