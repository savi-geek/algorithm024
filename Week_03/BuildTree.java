import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linaluo
 * @date 2021/2/21 12:21 下午
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0,  length, inorder, 0, length, map);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map) {
        if(pStart == pEnd){
            return null;
        }
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int iRootIndex = map.get(rootVal);
        int leftNum = iRootIndex-iStart;
        root.left = buildTree(preorder, pStart+1, pStart+leftNum+1, inorder, iStart, iRootIndex, map);
        root.right = buildTree(preorder, pStart+leftNum+1, pEnd, inorder, iRootIndex, iEnd, map);
        return root;
    }

}
