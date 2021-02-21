/**
 * @author linaluo
 * @date 2021/2/18 9:45 下午
 * 104. 二叉树的最大深度
 */
public class MaxDepth {

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }
}
