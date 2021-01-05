//整数转罗马数字
public class leet12 {
    public String intToRoman(int num) {
        String s[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int b[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int a[]=new int[4];
        for(int i=0;i<4;i++){
            a[i]=num%10;
            num=num/10;
        }
        int j=0;
        while(j<4){
        }
        return "";
    }
}
