import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linaluo
 * @date 2021/2/3 6:23 下午
 * 94. 二叉树的中序遍历
 */
public class InorderTraversal {

    /**
     * 递归
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List list){
        if(root == null){
            return;
        }
        if(root.left != null){
            inorder(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            inorder(root.right, list);
        }
    }

    /**
     * 迭代
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
