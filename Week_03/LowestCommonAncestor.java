/**
 * @author linaluo
 * @date 2021/2/21 11:47 上午
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {

    /**
     * 递归（后序遍历）
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p , q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if(leftNode == null && rightNode == null){
            return  null;
        }else if(leftNode == null){
            return rightNode;
        }else if(rightNode == null){
            return leftNode;
        }
        return root;//即当 leftNode ！= null && rightNode ！= null时
    }
}
