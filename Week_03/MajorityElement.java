/**
 * @author linaluo
 * @date 2021/2/20 11:17 上午
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 */
public class MajorityElement {

    /**
     * 投票法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count=1;
        for(int i=1; i<nums.length; i++){
            if(res == nums[i]){
                count++;
            }else{
                count--;
                if(count == 0){
                    res = nums[i];
                    count=1;
                }
            }
        }
        return res;
    }
}
