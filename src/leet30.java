import java.util.*;

public class leet30 {
    public static void main(String[] args){
        String[] words = {"foo","bar"};
        List<String> a = Arrays.asList(words);
        List<String> arrList = new ArrayList<String>(a);
        String s= "foobarfoobar";
        findSubstring1(s,words);

    }
    /*
    回溯，找到所有单词组合，然后与字符串进行比较，超时
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        int len = words.length * words[0].length();
        int wordlen = words[0].length();
        List<String> str = Arrays.asList(words);
        List<String> wordstr = new ArrayList<String>(str);
        StringBuffer sf = new StringBuffer();
        if(s.length()<len){
            return list;
        }
        int[] sum = new int[words.length];
        backtrack(s,list,wordstr,sf,len,sum,wordlen);
        return list;
    }
    public static void backtrack(String s,List<Integer> list,List<String> worst,StringBuffer sf,int len,int[] sum,int wordlen){
        if(sf.length() == len){
            for(int i=0;i<s.length()-len+1;i++){
                if(s.substring(i,i+len).equals(sf.toString())){
                    if(list.contains(i)){
                        break;
                    }else{
                        list.add(i);

                    }
                }
            }
        }

        for(int i = 0;i<worst.size();i++){
            if(sum[i]==0){
                sf.append(worst.get(i));
                sum[i]=1;
                backtrack(s,list,worst,sf,len,sum,wordlen);
                sf.delete(sf.length()-wordlen,sf.length());
                sum[i]=0;
            }

        }
    }
    /*
    首先将单词存入hash表，然后判断子串单词是否存在于hash表，以及出现个数是否大于hash表的值
     */
    public static List<Integer> findSubstring1(String s,String[] words){
        List<Integer> list = new ArrayList<Integer>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        //将words存入hashmap
        for(int i=0;i< words.length;i++){
            if(!map.containsKey(words[i])){
                map.put(words[i],1);
            }else{
                map.put(words[i],map.get(words[i])+1);
            }
        }
        if(words.length==0){
            return list;
        }
        int len = words[0].length();

        for(int i=0;i<s.length()-(len* words.length)+1;i++){
            int j = 0;
            HashMap<String,Integer> map1= new HashMap<String,Integer>();
            while(j<words.length*len){
                if(map.containsKey(s.substring(i+j,i+j+len))){//判断hash表中是否包含该单词
                    if(!map1.containsKey(s.substring(i+j,i+j+len))){
                        map1.put(s.substring(i+j,i+j+len),1);
                    }else{
                        map1.put(s.substring(i+j,i+j+len),map1.get(s.substring(i+j,i+j+len))+1);
                    }
                    if(map1.get(s.substring(i+j,i+j+len))>map.get(s.substring(i+j,i+j+len))){//判断该单词出现个数是否超过hash表的值
                        break;
                    }
                }
                j=j+len;

            }
            //判断map和map1是否相等
            if(map.equals(map1)){//两个hash表相等
                list.add(i);
            }
        }
        return list;
    }

}
