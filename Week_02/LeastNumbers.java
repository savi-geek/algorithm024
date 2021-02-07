import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author linaluo
 * @date 2021/2/5 12:42 下午
 * 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class LeastNumbers {

    /**
     * 堆
     * 时间复杂度
     * 空间复杂度
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if(k == 0){
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2- num1 ;
            }
        });
        for(int i =0; i<k; i++){
            queue.offer(arr[i]);
        }
        for(int i=k; i< arr.length; i++){
            if(queue.peek()>arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i=0; i<k; i++){
            result[i]=queue.poll();
        }
        return result;
    }
}
