package org.worker.hnalgorithm.tree.preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树先序遍历
 * @author peiru wang
 * @date 2021/8/15
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(null == root) {
            return new ArrayList<>(1);
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);

        List<Integer> leftList = preorderTraversal(root.left);
        List<Integer> rightList = preorderTraversal(root.right);

        result.addAll(leftList);
        result.addAll(rightList);

        return result;
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root == null) {
            return new ArrayList<>(1);
        }
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if(null != node.right) {
                stack.push(node.right);
            }
            if(null != node.left) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
