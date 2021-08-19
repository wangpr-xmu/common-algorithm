package org.worker.hnalgorithm.tree.codec;

import org.worker.hnalgorithm.tree.inorder.InOrder;

/**
 * @author peiru wang
 * @date 2021/8/15
 */
public class CodecDemo {
    public static void main(String[] args) {

        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialize = codec.serialize(root);

        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);

        System.out.println(deserialize);

    }

}
