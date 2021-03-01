/**
 * @author linaluo
 * @date 2021/3/1 1:25 下午
 * 74. 搜索二维矩阵
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix[0].length;
        for(int i=0; i<matrix.length; i++){
            int begin = matrix[i][0];
            int end = matrix[i][rowLen-1];
            if(begin == target || end == target){
                return true;
            }
            if(begin < target && target < end){
                return search(target, matrix[i]);
            }
        }
        return false;
    }

    /**
     * 二分查找
     * @param target
     * @param nums
     * @return
     */
    private boolean search(int target, int nums[]) {
        int left =0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] <= target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
