import java.util.*;

/**
 * @author linaluo
 * @date 2021/1/27 2:23 下午
 * 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组
 */
public class ThreeSum {
    public List<List<Integer>> method(int[] nums){
        if(nums == null || nums.length<=2){
            return Collections.emptyList();
        }
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0; i< nums.length-2; i++){
            //如果c大于0，就不能满足a+b+c=0了，因为数组已经是从小到大排序了，后面的数也都是大于0的。
            if(nums[i] > 0){
                return res;
            }
            //跳过相同的数字，同时避免重复
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int head = i+1;
            int tail = nums.length-1;
            while (head < tail){
                int sum = nums[i] + nums[head] + nums[tail];
                if(sum == 0){
                    List<Integer> childList = Arrays.asList(nums[i],nums[head], nums[tail]);
                    res.add(childList);
                    //跳过相同的数字，同时避免重复
                    while (head < tail && nums[head] == nums[head+1]){
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail-1]){
                        tail--;
                    }
                    head++;
                    tail--;
                }else if( sum < 0){
                    head++;
                }
                if(sum > 0){
                    tail--;
                }
            }

        }
        return res;
    }
}
