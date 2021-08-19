package org.worker.hnalgorithm.tree.postorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后续遍历
 * @author peiru wang
 * @date 2021/8/16
 */
public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>(1);
        }

        List<Integer> result = new ArrayList<>();

        List<Integer> leftList = postorderTraversal(root.left);
        result.addAll(leftList);

        List<Integer> rightList = postorderTraversal(root.right);
        result.addAll(rightList);

        result.add(root.val);

        return result;

    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        if(null == root) {
            return new ArrayList<>(1);
        }

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if(peek.left == null && null == peek.right) {
                result.add(stack.pop().val);
            }
            if(peek.right != null) {
                stack.push(peek.right);
                peek.right = null;
            }
            if(peek.left != null) {
                stack.push(peek.left);
                peek.left = null;
            }
        }
        return result;
    }
}
