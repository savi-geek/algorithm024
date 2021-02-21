import java.util.ArrayList;
import java.util.List;

/**
 * @author linaluo
 * @date 2021/2/18 6:02 下午
 */
public class GenerateParenthesis {

    /**
     * 回溯
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     *
     * @param curStr 当前递归得到的结果
     * @param left 左括号已经用了几个
     * @param right 右括号已经用了几个
     * @param n 左括号、右括号一共得用几个
     * @param res 结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if(left == n && right == n){
            res.add(curStr);
            return;
        }
        if(left < right){
            return;
        }
        if(left < n){
            dfs(curStr+"(", left++, right, n, res);
        }
        if(right < n){
            dfs(curStr+")", left, right++, n, res);
        }
    }
}
