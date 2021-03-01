/**
 * @author linaluo
 * @date 2021/2/26 6:40 下午
 * 33. 搜索旋转排序数组
 */
public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        if(n ==1 ){
            return (nums[0] == target)? 0:-1;
        }
        int l=0, r=n-1;
        while (l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[l] <= nums[mid]){
                if(nums[l]<=target && target<nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(nums[mid] <target && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
