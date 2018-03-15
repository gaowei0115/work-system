package com.mmc.work.arithmetic.tree;

/**
 * @packageName：com.mmc.work.arithmetic.tree
 * @desrciption: 二叉树
 * @author: gaowei
 * @date： 2018-03-15 13:23
 * @history: (version) author date desc
 */
public class BinaryTree<T extends Comparable<? super T>> {


    private TreeNode<T> root;

    public BinaryTree() {
        this.root = new TreeNode(1, "A");
    }

    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<>();
        binaryTree.creatBinaryTree();
        System.out.println("前序遍历：");
        binaryTree.preEach(binaryTree.root);
        System.out.println("中序遍历：");
        binaryTree.middleEach(binaryTree.root);
        System.out.println("后序遍历：");
        binaryTree.nextEach(binaryTree.root);
    }

    public void creatBinaryTree() {
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        TreeNode nodeG = new TreeNode(7, "G");
        TreeNode nodeH = new TreeNode(8, "H");
        TreeNode nodeI = new TreeNode(9, "I");
        TreeNode nodeJ = new TreeNode(10, "J");

        nodeD.lNode = nodeH;
        nodeD.rNode = nodeI;

        nodeE.lNode = nodeJ;

        nodeB.lNode = nodeD;
        nodeB.rNode = nodeE;

        nodeC.lNode = nodeF;
        nodeC.rNode = nodeG;

        root.rNode = nodeC;
        root.lNode = nodeB;
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preEach(TreeNode<T> node) {
        if (node == null) {
            return ;
        }
        System.out.println(node.data);
        preEach(node.lNode);
        preEach(node.rNode);
    }

    /**
     * 后序遍历
     * @param node
     */
    public void nextEach(TreeNode<T> node) {
        if (node == null) {
            return ;
        }
        nextEach(node.lNode);
        nextEach(node.rNode);
        System.out.println(node.data);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void middleEach(TreeNode<T> node) {
        if (node == null) {
            return ;
        }
        middleEach(node.lNode);
        System.out.println(node.data);
        middleEach(node.rNode);
    }

    /**
     * treeNode
     * @param <T>
     */
    static class TreeNode<T> {
        private int index;
        private T data;
        private TreeNode<T> lNode;
        private TreeNode<T> rNode;

        public TreeNode(int index, T data) {
            this.index = index;
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode<T> getlNode() {
            return lNode;
        }

        public void setlNode(TreeNode<T> lNode) {
            this.lNode = lNode;
        }

        public TreeNode<T> getrNode() {
            return rNode;
        }

        public void setrNode(TreeNode<T> rNode) {
            this.rNode = rNode;
        }
    }
}
