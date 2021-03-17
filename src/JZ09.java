import java.util.Stack;

public class JZ09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public JZ09() {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {//判断stack2中是否存在元素，没有则将stack1中元素存入stack2
        int value = -1;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            if(!stack2.isEmpty()){
                value = stack2.pop();
            }
        }else{
            value = stack2.pop();
        }
        return value;
    }
}
