import java.util.ArrayList;
import java.util.List;

/**
 * @author linaluo
 * @date 2021/2/21 9:18 下午
 *
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0){
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<len; i++){
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, path, used, res);
            used[i] = false;
            path.remove(i);
        }
    }
}
