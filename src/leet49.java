import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//字母异位词分组
/*
建立hash表，键值对
快速查找当前字符串所处分类
key  --排序后的字符串
value --列表
 */
public class leet49 {
    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<String, List<String>>();
        if(strs.length==0){
            return new ArrayList<>();
        }
//        map.put(strs[0].toCharArray(),new ArrayList<String>());
//        map.get(strs[0].toCharArray()).add(strs[0]);
        for(int i=0;i< strs.length;i++){
            char[] s= strs[i].toCharArray();
            Arrays.sort(s);
            String str = String.valueOf(s);
            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());

            }
            map.get(str).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
