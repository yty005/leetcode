public class JZ05 {
    //剑指 Offer 05. 替换空格

    public String replaceSpace(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(i!=s.length()-1){
                    s = s.substring(0,i)+"%20"+s.substring(i+1);
                }else{
                    s = s.substring(0,i)+"%20";
                }

            }
        }
        return "";
    }
}
