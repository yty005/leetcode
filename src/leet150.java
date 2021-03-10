import java.util.Stack;

public class leet150 {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack1 = new Stack<Integer>();
        int i=0;
        while(i<tokens.length){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int a = stack1.pop();
                int b = stack1.pop();
                if(tokens[i]=="+")stack1.push(a+b);
                if(tokens[i]=="-")stack1.push(b-a);
                if(tokens[i]=="*")stack1.push(a*b);
                if(tokens[i]=="/")stack1.push(b/a);
            }else{
                stack1.push(Integer.valueOf(tokens[i]));
            }
            i++;
        }
        return stack1.pop();
    }

    public static void main(String[] args) {
        String[] nums = {"2","1","+","3","*"};
        evalRPN(nums);
    }
}
