import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author linaluo
 * @date 2021/2/5 1:30 下午
 * 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {

    /**
     * 优先队列
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0]? pair2[0]-pair1[0]:pair2[1]-pair1[1];
            }
        });
        for(int i=0; i<k; i++){
            queue.offer(new int[]{nums[i], i});
        }
        int[] result = new int[n-k+1];
        result[0] = queue.peek()[0];
        for(int i=k; i<n; i++){
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i-k){
                queue.poll();
            }
            result[i-k+1] = queue.peek()[0];
        }
        return result;
    }

}
