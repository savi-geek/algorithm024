import java.util.HashMap;
import java.util.Map;

/**
 * @author linaluo
 * @date 2021/2/3 4:23 下午
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{i, map.get(temp)};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
