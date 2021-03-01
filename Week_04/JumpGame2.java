/**
 * @author linaluo
 * @date 2021/2/28 10:22 下午
 * 45. 跳跃游戏 II
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        int maxIndex = 0;
        int end = 0;
        int steps = 0;
        for(int i=0; i< nums.length; i++){
            maxIndex = Math.max(maxIndex, nums[i]+i);
            if(i == end){
                end = maxIndex;
                steps++;
            }
        }
        return steps;
    }

}
