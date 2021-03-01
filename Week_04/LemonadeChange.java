/**
 * @author linaluo
 * @date 2021/2/27 10:13 下午
 * 860. 柠檬水找零
 */
public class LemonadeChange {

    /**
     * 贪心算法
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five=0, ten=0;
        for(int bill : bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else if(bill == 20){
                if(five>0 && ten >0){
                    five--;
                    ten--;
                }else if(five>=3){
                    five = five-3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
