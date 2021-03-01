/**
 * @author linaluo
 * @date 2021/3/1 2:12 下午
 * 153. 寻找旋转排序数组中的最小值
 */
public class MinNumRotated {

    public static int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length -1;
        if(nums[0] < nums[right]){
            return nums[0];
        }
        while(left <= right){
            int mid=(left + right)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            if(nums[left] <= nums[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1};
        findMin(nums);
    }
}
