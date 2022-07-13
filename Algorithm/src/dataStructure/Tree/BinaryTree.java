package dataStructure.Tree;

/**
 * A tree is a hierarchical data structure.
 * It consists of nodes with a root node at the top and subtree of children nodes.
 * The nodes are connected by edges. Each parent node can point to null, one or
 * multiple nodes.
 * It has no cycle.
 *
 * A binary tree has at most two children.
 * Each node has a value associated to it. They are not in particular order.
 * The time complexity of most binary tree operations is O(n) in the worst case.
 *
 * https://www.lavivienpost.net/binary-tree/
 */
public class BinaryTree<T> {

    TreeNode<T> root;

    public void addChild(TreeNode<T> p, TreeNode<T> left, TreeNode<T> right) {
        p.left = left;
        p.right = right;
    }

    public TreeNode<T> getRoot() {
        return root;
    }
}
