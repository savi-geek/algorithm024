import java.util.*;

/**
 * @author linaluo
 * @date 2021/2/6 11:48 上午
 * 589. N叉树的前序遍历
 */
public class PreorderNTree {

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            list.add(root.val);
            getChildren(root, list);
        }
        return list;
    }

    public void getChildren(Node root, List list) {
        if(root!= null && root.children != null){
            for(Node node: root.children){
                list.add(node.val);
                getChildren(node, list);
            }
        }
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            List<Node> children = node.children;
            int size = children.size();
            if(children != null){
                for(int i= size-1; i>=0; i--){
                    Node child =  children.get(i);
                    if(child != null){
                        stack.push(child);
                    }
                }
            }
        }
        return list;
    }

}
