import java.util.ArrayList;
import java.util.List;

public class leet155 {
    private List<Integer> list;
    private List<Integer> minlist;
    public leet155() {//MinStack
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> minlist = new ArrayList<Integer>();
        this.list = list;
        this.minlist = minlist;
    }

    public void push(int x) {//添加元素
        list.add(x);
        if(minlist.isEmpty()){
            minlist.add(x);
        }else{
            if(x<minlist.get(minlist.size()-1)){
                minlist.add(x);
            }
        }
    }

    public void pop() {//出栈
        int a = list.remove(list.size()-1);
        if(a==minlist.get(minlist.size()-1)){
            minlist.remove(minlist.size()-1);
        }
    }

    public int top() {//栈顶元素
        return list.get(list.size())-1;
    }

    public int getMin() {
        //return list;
        return minlist.get(minlist.size()-1);
    }
}
