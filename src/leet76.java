import java.util.*;

//最小覆盖子串
public class leet76 {
    //考虑使用动态规划进行最小字符串查找
    //dp[i][j]表示从i到j是否包含t中所有元素
    public static void main(String[] args){
        String s= "ADOBECODEBANC";
        String t= "ABC";
        minWindow(s,t);
    }
    /*
    滑动窗口
    滑动窗口最初设置为t的长度，若滑动窗口中不包含所有元素，
    滑动窗口最右指针i+1，若包含所有元素，滑动窗口最左指针j+1，直至滑动窗口长度为t
    比较i所指元素是否在t中，若包含则在map中添加该元素，最后比较t中所有值的总和是否与t长度一致
     */
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> mapt = new HashMap<Character, Integer>();
        HashMap<Character,Integer> maps = new HashMap<Character, Integer>();
        for(int i=0;i<t.length();i++){
            mapt.put(t.charAt(i),mapt.getOrDefault(t.charAt(i),0)+1);
        }
        int left = 0;
        int right = 0;
        boolean right_flag = false;//表示right指针没移动
        //定义最小滑动窗口左右指针的位置
        int l = -1;
        int r = -1;
        int min = s.length()+1;
        maps.put(s.charAt(0),maps.getOrDefault(s.charAt(0),0)+1);
        while(right<s.length()){
            if(right_flag==true){
                maps.put(s.charAt(right),maps.getOrDefault(s.charAt(right),0)+1);
            }

            if(check(mapt,maps)){
                if(right-left+1 < min){
                    min = right - left + 1;
                    l = left;
                    r = right;
                }

                maps.put(s.charAt(left),maps.get(s.charAt(left))-1);
                left++;
                right_flag = false;
            }else{
                right++;
                right_flag = true;
            }
        }
        if(min==s.length()+1){
            return "";
        }
        return s.substring(l,r+1);
    }
    public static boolean check(HashMap<Character,Integer> mapt,HashMap<Character,Integer> maps){
        /*
        检查t中元素是否均在s的滑动窗口中出现
        包含t中存在重复元素的现象
         */
//        int numt = 0;
//        int nums = 0;
        if(mapt.size()>maps.size()){
            return false;
        }
        Iterator tvalue = mapt.entrySet().iterator();
        while(tvalue.hasNext()){
            Map.Entry map = (Map.Entry) tvalue.next();
            Character key = (Character) map.getKey();
            Integer value = (Integer) map.getValue();
            if(!maps.containsKey(key)){
                return false;
            }
            if(maps.get(key)<value){
                return false;
            }
        }
        return true;
    }
}
