public class leet28 {
    public static void main(String[] args){
        strStr("mississippi","issip");
    }
    public static int strStr(String haystack, String needle) {
        int len = haystack.length();
        int lennee = needle.length();
        if(lennee == 0){
            return 0;
        }
        int i=0;//表示hay的指针
        int j=0;//表示nee的指针
        while (i<len){
            if(haystack.charAt(i)!=needle.charAt(j)){
                i=i-j+1;
                j=0;
            }else{
                j++;
                i++;
            }
            if(j==lennee){
                return i-lennee;
            }
        }
        return -1;
    }
}
