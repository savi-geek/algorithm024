import java.util.*;

/**
 * @author linaluo
 * @date 2021/2/7 11:24 上午
 * 429. N 叉树的层序遍历
 */
public class LevelOrder {

    public List<List<Integer>> getLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i< size; i++){
                Node node = queue.poll();
                if(node != null){
                    level.add(node.val);
                    queue.addAll(node.children);
                }
            }
            result.add(level);
        }
        return result;
    }
}
