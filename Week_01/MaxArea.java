/**
 * @author linaluo
 * @date 2021/1/26 5:26 下午
 * 盛水最多的容器
 */
public class MaxArea {

    /**
     * 双指针，每次移动数字较小的指针
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public int method1(int[] height){
        int maxArea = 0;
        for(int i=0,j=height.length-1; i<j;){
            int minHeight = height[i] < height[j] ? height[i++]: height[j--];
            //因为此时i或者j已经移动了一个格，所以长度为j-i+！
            maxArea = Math.max(maxArea, minHeight * (j-i+1));
        }
        return maxArea;
    }
}
