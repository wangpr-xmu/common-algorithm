package org.worker.hnalgorithm.tree.inorder;

import java.util.List;

/**
 * @author peiru wang
 * @date 2021/8/15
 */
public class InOrderDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        InOrder inOrder = new InOrder();
        List<Integer> list = inOrder.inorderTraversal(root);
        List<Integer> list2 = inOrder.inorderTraversal2(root);

        System.out.println(list2);
    }


    private static void inOrder() {

    }
}
