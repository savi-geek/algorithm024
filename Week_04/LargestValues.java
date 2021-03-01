import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author linaluo
 * @date 2021/2/25 10:52 上午
 * 515. 在每个树行中找最大值
 */
public class LargestValues {

    /**
     * BFS广度优先
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(root.left != null){
                    queue.add(node.left);
                }
                if(root.right != null ){
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    /**
     * dfs
     * @param root
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int level, List<Integer> res) {
        if(root == null){
            return;
        }
        if(level == res.size()) {
            res.add(level, root.val);
        }else{
            res.set(level, Math.max(res.get(level), root.val));
        }
        dfs(root.left, level +1, res);
        dfs(root.right, level+1, res);
    }

}
