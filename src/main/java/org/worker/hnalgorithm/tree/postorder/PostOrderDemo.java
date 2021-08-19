package org.worker.hnalgorithm.tree.postorder;

import javafx.geometry.Pos;

import java.util.List;

/**
 * @author peiru wang
 * @date 2021/8/15
 */
public class PostOrderDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        PostOrder postOrder = new PostOrder();
        List<Integer> list = postOrder.postorderTraversal(root);
        List<Integer> list2 = postOrder.postorderTraversal2(root);

        System.out.println(list2);

    }

}
