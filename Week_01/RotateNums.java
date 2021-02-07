/**
 * @author linaluo
 * @date 2021/1/31 12:34 下午
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateNums {

    /**
     * 使用额外的数组
     * @param nums
     * @return
     */
    public void rotate1(int[] nums, int k){
        int len = nums.length;
        int[] tempArray = new int[len];
        for(int i=0; i<len; i++){
            tempArray[(i+k)%len] = nums[i];
        }
        System.arraycopy(tempArray, 0, nums, 0, len);
    }

    /**
     * 翻转法
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k){
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int start, int end){
            while(start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end --;
            }
    }
}

