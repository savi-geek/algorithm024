/**
 * @author linaluo
 * @date 2021/2/26 1:22 下午
 * 367. 有效的完全平方数
 */
public class PerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1){
            return true;
        }
        long left=0, right=num;
        while (left <= right){
            long mid = (left+right)/2;
            if(mid*mid == num){
                return true;
            }else if(mid*mid < num){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return false;

    }
}
