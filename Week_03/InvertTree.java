/**
 * @author linaluo
 * @date 2021/2/18 6:38
 * 226. 翻转二叉树
 */
public class InvertTree {

    /**
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
