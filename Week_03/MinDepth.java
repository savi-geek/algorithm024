/**
 * @author linaluo
 * @date 2021/2/18 9:59 下午
 * 111. 二叉树的最小深度
 */
public class MinDepth {

    /**
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(H)，H为树的高度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null &&  root.right == null){
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if(root.left != null){
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if(root.right != null){
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth+1;

    }
}
