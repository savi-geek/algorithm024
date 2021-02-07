import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author linaluo
 * @date 2021/2/7 4:42 下午
 * 347. 前 K 个高频元素
 */
public class TopKFrequent {

    /**
     * 小顶堆
     * 时间复杂度：O(Nlogk)
     * 空间复杂度：O(N)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            }else{
                queue.offer(new int[]{num, count});
            }
        }

        for(int i=0; i<k; i++){
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
