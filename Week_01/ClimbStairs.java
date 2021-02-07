import java.util.*;

/**
 * @author linaluo
 * @date 2021/1/26 6:04 下午
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {
    Set<List<Integer>> set = new LinkedHashSet<>();
    public int method(int n){
        if(n <= 2){
            return n;
        }
        int f1=1, f2=2, f3=3;
        for ( int i=3; i<= n;i++ ){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
