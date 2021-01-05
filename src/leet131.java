import java.util.ArrayList;
import java.util.List;

public class leet131 {
    public static void main(String[] args){
        String s = "aab";
        partition(s);
    }
    /*
    返回所有的可能的分割方案 利用回溯
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<List<String>>();
        StringBuffer buffer = new StringBuffer();
        List<String> list1 = new ArrayList<String>();
        backtrack(s,0,buffer,list1,list);
        return list;
    }
    public static void backtrack(String s,int start,StringBuffer buffer,List<String> list1,List<List<String>> list){
        if(buffer.length()==s.length()){
            list.add(new ArrayList<>(list1));
        }
        for(int i=start;i<s.length();i++){
            if(!huiwen(s,start,i+1)){
                continue;
            }
            buffer.append(s.substring(start,i+1));
            list1.add(s.substring(start,i+1));
            backtrack(s,i+1,buffer,list1,list);
            buffer.delete(start,i+1);
            list1.remove(list1.size()-1);
        }
    }
    public static boolean huiwen(String s,int start,int end){
        int i=start;
        int j=end-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
