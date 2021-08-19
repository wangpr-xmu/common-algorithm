package org.worker.hnalgorithm.tree.levelorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树层序遍历
 * @author peiru wang
 * @date 2021/8/16
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>(1);
        }

        List<List<Integer>> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Stack<TreeNode> temp = new Stack<>();
            List<Integer> list = new ArrayList<>();
            for(TreeNode node : stack) {
                list.add(node.val);
                if(node.left != null) {
                    temp.add(node.left);
                }
                if(node.right != null) {
                    temp.add(node.right);
                }
            }
            stack = temp;
            result.add(list);
        }

        return result;
    }
}
