/**
 * @author linaluo
 * @date 2021/2/28 9:43 下午
 * 55. 跳跃游戏
 */
public class JumpGame {

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for(int i=0; i<nums.length; i++){
            if(i <= maxIndex){
                maxIndex = Math.max(maxIndex, nums[i]+1);
                if(maxIndex >= n-1){
                    return true;
                }
            }
        }
        return false;
    }
}
