/**
 * @author linaluo
 * @date 2021/2/19 12:39 下午
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Pow {

    /**
     * 方法一：快速幂 + 递归
     * 快速幂算法」的本质是分治算法。
     * 时间复杂度：O(logn)，即为递归的层数。
     * 空间复杂度：O(logn)，即为递归的层数
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return (n>0)?quikMul(x,n):1.0/quikMul(x,n);
    }

    private double quikMul(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        double y = quikMul(x, n);
        return n%2==0?y*y: y*y*x;
    }
}
