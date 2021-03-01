import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author linaluo
 * @date 2021/2/24 7:04 下午
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrder {

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i< size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(level.size()>0){
                result.add(level);
            }
        }
        return result;
    }

}
