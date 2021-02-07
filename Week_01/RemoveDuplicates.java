/**
 * @author linaluo
 * @date 2021/1/31 12:07 下午
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates {

    /**
     * 快慢指针法
     * @param nums
     * @return
     */
    public int removeDup(int[] nums){
        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
