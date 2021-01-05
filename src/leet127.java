import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet127 {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        Collections.addAll(list,"most","fist","lost","cost","fish");
        ladderLength("lost","cost",list);
    }
    /*
    利用回溯，遍历所有可能，想象成遍历节点   超时
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //将list转为Stringbuilder
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<wordList.size();i++){
            buffer.append(wordList.get(i));
        }
        List<Integer> list = new ArrayList<Integer>();
        backtrack(beginWord,endWord,buffer,0,list);
        //找到列表的最大值
        int min = list.get(0);
        for(int i=0;i<list.size();i++){
            if(min>list.get(i)){
                min = list.get(i);
            }
        }
        return min;
    }
    //回溯
    public static void backtrack(String begin,String end,StringBuffer buffer,int count,List<Integer> list){
        if(tranfrom(begin,end)&&(buffer.indexOf(end)!=-1)){
            list.add(count);
        }
        for(int i=0;i<buffer.length();i=i+begin.length()){
            if(tranfrom(begin,buffer.substring(i,i+begin.length()))){//获取builder当前的元素，若为false，则换下一个元素，true则选定该元素
                String tmp = buffer.substring(i,i+begin.length());
                buffer.delete(i,i+begin.length());
                count = count+1;
                backtrack(tmp,end,buffer,count,list);
                count--;
                buffer.insert(i,tmp);
            }
        }
    }
    //定义一个函数，该函数表示两个单词只存在一个字符不同
    public static boolean tranfrom(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        int count = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }

    /*
    方法二：
     */
}
