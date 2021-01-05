import java.util.*;
//括号生成
//回溯 ---找出全部解
public class leet22 {
    public static void main(String []args){
        int n=3;
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {//遍历完成前 右括号的数量小于等于左括号的数量，左括号最多n个
        //将括号看成1 2，
        List<String> list =new ArrayList<>();
        StringBuffer str =new StringBuffer();
        int len = 0;//记录左括号个数
        int len1 = 0;//记录右括号个数
        backtrack(n,list,str,len,len1);
        return list;
    }
    public static void backtrack(int n,List<String> list,StringBuffer str,int len,int len1){
        if(str.length() == n *2){
            list.add(str.toString());
            return;
        }

        if(len<n){
            str.append('(');
            backtrack(n,list,str,len+1,len1);
            str.deleteCharAt(str.length()-1);
        }
        if(len1<len){

            str.append(')');
            backtrack(n,list,str,len,len1+1);
            str.deleteCharAt(str.length()-1);


        }

    }


}
