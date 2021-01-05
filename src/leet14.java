//找最长公共前缀
//横向扫描
public class leet14 {
    public static void main(String []args){
        String strs[]={"aaa","aa","aaa"};
        String a=longestCommonPrefix(strs);
        System.out.println(a);
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }else{
            String s=strs[0];
            for(int i=1;i< strs.length;i++){
                String tmp="";
                if(s.length()==0){
                    return "";
                }
                for(int j=0;j<Math.min(strs[i].length(),s.length());j++){
                    if(s.charAt(j)==strs[i].charAt(j)){
                        tmp = tmp+s.charAt(j);
                    }else{
                        break;
                    }
                }
                s=tmp;
            }



            return s;
        }
    }
}
