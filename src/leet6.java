//z字形变换
public class leet6 {
    public static void main(String []args) {
        String s="LEETCODEISHIRING";
        int numRows = 3;
        char a[][]=new char[numRows][s.length()];
        boolean flag=true;//true向下  false向上
        int num=0;//标记存储元素位置
        int i=0;
        int j=0;
        while(num<s.length()) {
            if (i == 0) {
                flag = true;
            } else if (i == numRows - 1) {
                flag = false;
            }
            a[i][j] = s.charAt(num);
            if (flag) {
                i++;
            } else {
                i--;
                j++;
            }
            num++;
        }
        String s1="";
        for(int i1=0;i1<numRows;i1++){
            for(int j1=0;j1<s.length();j1++){
                s1=s1+a[i1][j1];
            }
        }
        System.out.println(s1);
    }



        //return s1;

}
