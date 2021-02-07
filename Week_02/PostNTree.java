import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linaluo
 * @date 2021/2/7 5:35 下午
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class PostNTree {

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            Node node = deque.pollLast();
            res.addFirst(node.val);
            if(node.children != null){
                List<Node> children = node.children;
                int len = children.size();
                for(int i=0; i<len; i++){
                    deque.offer(children.get(i));
                }
            }
        }
        return res;

    }

}
