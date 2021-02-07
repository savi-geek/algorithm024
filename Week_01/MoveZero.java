/**
 * @author linaluo
 * @date 2021/1/25 8:08 下午
 */
public class MoveZero {

    /**
     * 双指针一次遍历（最优解）
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     */
    public void method1(int[] nums){
        if(nums == null){
            return;
        }
        int j=0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0){
                //num[j]等于0的时候再交换，不等于0时num[i]与num[j]指的是同一个元素，不需交换
                if(nums[j] == 0){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                j++;
            }
        }
    }
}
