package org.worker.hnalgorithm.tree.codec;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * 树的序列化与反序列化
 * @author peiru wang
 * @date 2021/8/15
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(null == root) {
            return null;
        }
        StringBuilder result = new StringBuilder();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            Stack<TreeNode> temp = new Stack<>();
            for(TreeNode node : stack) {
                if(null == node) {
                    result.append("null,");
                }else {
                    result.append(node.val+",");
                    temp.add(node.left);
                    temp.add(node.right);
                }
            }
            stack = temp;
        }
        return result.toString().substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(null == data) {
            return null;
        }
        String[] vals = data.split(",");
        Queue<String> allNodes = new ArrayDeque<>();
        allNodes.addAll(Arrays.asList(vals));

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(allNodes.poll()));
        queue.add(root);

        while(!queue.isEmpty()) {
            Queue<TreeNode> temp = new ArrayDeque<>();
            for(TreeNode node : queue) {
                if(node != null) {
                    String left = allNodes.poll();
                    if(!"null".equals(left)) {
                        node.left = new TreeNode(Integer.parseInt(left));
                        temp.add(node.left);
                    }
                    String right = allNodes.poll();
                    if(!"null".equals(right)) {
                        node.right = new TreeNode(Integer.parseInt(right));
                        temp.add(node.right);
                    }

                }
            }
            queue = temp;
        }
        return root;
    }

}
