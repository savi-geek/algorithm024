import java.util.ArrayList;
import java.util.List;

/**
 * @author linaluo
 * @date 2021/2/21 4:26 下午
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        backTrack( n, k, 1, subSet, res);
        return res;
    }

    private void backTrack(int n, int k, int begin, List subSet, List<List<Integer>> res) {
        if(subSet.size() == k ){
            res.add(new ArrayList<>(subSet));
            return;
        }
        for(int i=begin; i<=n-(k-subSet.size())+1; i++){
            subSet.add(i);
            backTrack(n, k, i+1, subSet, res);
            subSet.remove(subSet.size()-1);
        }

    }


}
