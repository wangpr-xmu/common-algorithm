package org.worker.hnalgorithm.tree.inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 * @author peiru wang
 * @date 2021/8/16
 */
public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(null == root) {
            return new ArrayList<>(1);
        }
        List<Integer> result = new ArrayList<>();

        List<Integer> leftList = inorderTraversal(root.left);
        result.addAll(leftList);

        result.add(root.val);

        List<Integer> rightList = inorderTraversal(root.right);
        result.addAll(rightList);

        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if(null == root) {
            return new ArrayList<>(1);
        }
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            while(null != current) {
                stack.push(current);
                current = current.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            current = pop.right;
        }

        return result;
    }
}
