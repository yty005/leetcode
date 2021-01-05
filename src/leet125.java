//验证字符数字是否为回文串
public class leet125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] str = s.toCharArray();
        int i=0;
        int j= str.length-1;
        while(i<j){
            //i,j所指位置均为数字或字母，若不为则跳过该位置
            if((str[i]>96&&str[i]<123)||(str[i]>=48&&str[i]<=57)){
            }else{
                i++;
                continue;
            }
            if((str[j]>96&&str[j]<123)||(str[j]>=48&&str[j]<=57)){
            }else{
                j--;
                continue;
            }
            if(str[i]==str[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
