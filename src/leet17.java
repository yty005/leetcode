//电话号码的字母组合
//回溯
import javax.jnlp.ClipboardService;
import java.util.*;

public class leet17 {
    public static void main(String []args){
        String a = "";
        System.out.print(letterCombinations(a));
    }
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        StringBuffer buff = new StringBuffer();
        String str="";
        HashMap<Character,String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits==""){
            return list;
        }
        backtrack(digits,map,0,buff,list);

        return list;
    }
    public static void backtrack(String digits, HashMap<Character,String> map, int index,StringBuffer buff,List<String> list){
        if(buff.length()==digits.length()){
            list.add(buff.toString());

            return;
        }
        char digit = digits.charAt(index);
        for(int i=0;i<map.get(digit).length();i++){//找到每个元素对应的映射字符串
            buff.append(map.get(digit).charAt(i));
            backtrack(digits,map,index+1,buff,list);
            buff.deleteCharAt(index);
        }


    }

}

