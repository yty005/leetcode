//利用滑动窗口来进行检测，当无重复，则滑动窗口长度加1，有重复则移动滑动窗口
import java.util.*;
public class leet3 {
    public static void main(String[] args){

    }
    public int lengthOfLongestSubstring(String s) {
        //left指针，指向滑动窗口最左端，当出现重复元素，窗口滑动一位，滑动窗口置为1

        if(s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int num = 1;
        int max = 1;
        map.put(s.charAt(0), 0);
        int left = 0;//滑动窗口中最左边的元素
        int i = 1;
        while (i < s.length()) {//s.charAt(7)
            if (map.containsKey(s.charAt(i))) {
                map.remove(s.charAt(left));
                left++;
                num = 1;
                i=left+1;
                map.clear();
                map.put(s.charAt(left), left);
            } else {
                map.put(s.charAt(i), i);
                num++;
                max = Math.max(max, num);
                i++;
            }
        }

        return max;

    }
}


//优化
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
