import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linaluo
 * @date 2021/2/21 10:08 下午
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>(len);
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, res, used);
        return res;
    }

    private void dfs(int[] nums, int len, int index, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i< len; i++){
            if(used[i] || (i>0 && nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, index+1, path, res, used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
