import java.util.HashMap;

//找到最大回文子串
public class leet5 {
    public String longestPalindrome(String s) {//去掉最边上两个元素，仍为回文串
        if(s.length()==0)
            return "";
        boolean a[][]=new boolean[s.length()][s.length()];
        int max=1;
        int left=0;
        for(int i=0;i< s.length();i++){//首先确定单个元素的取值，所以按列进行循环
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)!=s.charAt(j)){
                    a[i][j]=false;
                }else{
                    if(j-i<3){
                        a[i][j]=true;
                    }else{
                        a[i][j]=a[i+1][j-1];
                    }
                }
                if(a[i][j]&&j-i+1>max){
                    max=j-i+1;
                    left=i;
                }
            }
        }
        return s.substring(left,max+left);//取子串，包括起始位置，不包括结尾位置
    }
}
