import java.util.Arrays;
import java.util.Scanner;

//寻找两个数组的中位数,使用treemap
//找第k小的数，k是中位数 - ---特殊情况
public class leet4 {
    public static void main(String[] args){
        int num1[] = {};
        int num2[] = {1};
        System.out.println(1/2);

        int len =num1.length+num2.length;
        int[] num =new int[len];
        int i=0;
        while(i<len){
            if(i<num1.length){
                num[i]=num1[i];
            }else{
                num[i]=num2[i-num1.length];
            }
            i++;
        }
        Arrays.sort(num);
//        for (int j=0;j<len;j++){
//            System.out.println(num[j]);
//        }
        double mid;

        if(len%2==0) {//偶数
            mid =(double)(num[len/2]+num[len/2-1])/2;
        }else{
            mid = num[len/2];
        }
        System.out.println(mid);
    }
}
