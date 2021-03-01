import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linaluo
 * @date 2021/2/19 5:57 下午
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 */
public class Subsets {

    /**
     * 递归
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        dfs2(0, subSet, nums, res);
        return res;
    }

    private void dfs(int n, List<Integer> subSet, int[] nums, List<List<Integer>> res) {
        if(n == nums.length){
            res.add(new ArrayList<>(subSet));
        }
        subSet.add(nums[n]);
        dfs(n+1, subSet, nums, res);
        subSet.remove(subSet.size()-1);
        dfs(n+1, subSet, nums, res);
    }

    private void dfs2(int n, List<Integer> subSet, int[] nums, List<List<Integer>> res) {
        res.add(new ArrayList<>(subSet));
        for(int i=n; i< nums.length; i++){
            System.out.println("i====="+i);
            subSet.add(nums[i]);
            System.out.println("subset before dfs:"+ Arrays.toString(subSet.toArray()));
            dfs2(i+1, subSet, nums, res);
            System.out.println("subset after dfs:"+ Arrays.toString(subSet.toArray()));
            subSet.remove(subSet.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets.subsets(nums);
        System.out.println("res:"+Arrays.toString(res.toArray()));
    }

}
