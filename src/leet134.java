public class leet134 {
    public static void main(String[] args){
        int[] gas = {2};
        int[] cost = {2};
        canCompleteCircuit(gas,cost);
    }

    /*
    找到差值为正的情况，从该处计算是否可以环绕一周
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int i=0;
        for(i=0;i< gas.length;i++){
            if(gas[i]>=cost[i]){
                if(round(gas,cost,i)){
                    break;
                }
            }
        }
        if(i== gas.length){
            return -1;
        }
        return i;
    }
    //计算是否可以环绕一周
    public static boolean round(int[] gas,int[] cost,int i){
        int sum = 0;
        int length = 0;
        while(length< gas.length){//当i循环完一周，则退出循环
            if(i== gas.length){
                i=0;
            }
            sum = sum+gas[i];//到达该位置的加油量
            sum = sum-cost[i];//从该处出发所需消耗的油量
            if(sum<0){
                return false;
            }
            i++;
            length++;
        }
        if(sum<0){
            return false;
        }
        return true;
    }
}
