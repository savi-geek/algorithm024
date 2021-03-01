/**
 * @author linaluo
 * @date 2021/2/26 12:45 下午
 * 69. x 的平方根
 */
public class MySqrt {

    /**
     * 二分查找
     * 时间复杂度log(N)
     * 空间复杂度log(N)
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        int res = -1;
        long left = 0, right=x;
        while (left<=right){
            long mid = (left+right)/2;
            if(mid*mid == x){
                return (int)mid;
            }else if(mid*mid <x){
                res = (int)mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return res;
    }

}
