package org.worker.hnalgorithm.tree.levelorder;

import java.util.List;

/**
 * @author peiru wang
 * @date 2021/8/15
 */
public class LevelOrderDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> lists = levelOrder.levelOrder(root);

        System.out.println(lists);
    }

}
