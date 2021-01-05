//利用竖式计算两数相乘
public class leet43 {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        if(num1.equals("1")){
            return num2;
        }else if(num2.equals("1")){
            return num1;
        }
        int[] res = new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                res[i+j+1] = res[i+j+1]+(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        StringBuffer buffer = new StringBuffer();
        for(int i=n1+n2-1;i>=0;i--){
            if(i>0){
                res[i-1] = res[i-1]+(res[i]/10);
            }
            res[i] = res[i]%10;

        }
        for(int i=0;i<n1+n2;i++){
            if((i==0)&&res[i]==0){

            }else{
                buffer.append(res[i]);
            }

        }

        return buffer.toString();
    }
}
