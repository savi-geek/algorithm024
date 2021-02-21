import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author linaluo
 * @date 2021/2/19 11:36 上午
 * 297. 二叉树的序列化与反序列化
 */
public class SerializeTree {

    /**
     * DFS方式
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append('X').append(',');
            return sb.toString();
        }else{
            sb.append(root.val).append(",");
            sb.append(serialize(root.left));
            sb.append(serialize(root.right));
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Deque<String> queue = new LinkedList<>(Arrays.asList(arr));
        return buildNode(queue);
    }

    private TreeNode buildNode(Deque<String> queue) {
        String nodeStr = queue.poll();
        TreeNode node = null;
        if("X".equals(nodeStr)){
            return null;
        }else{
            node = new TreeNode(Integer.parseInt(nodeStr));
            node.left = buildNode(queue);
            node.right = buildNode(queue);
        }
        return node;
    }

}
