package algorithm.search;

import dataStructure.Tree.BinaryTree;
import dataStructure.Tree.TreeNode;

import java.util.Stack;

public class DepthFirstSearch<T> {

    /**
     * Depth First Search starts from the root, and explores the child nodes as far as possible before
     * backtracking.
     * DFS is usually implemented with recursion or stack.
     * @param tree
     * @param value
     * @return
     */
    public TreeNode<T> searchIterative(BinaryTree<T> tree, T value) {
        Stack<TreeNode<T>> stack = new Stack<>();

        TreeNode<T> root = tree.getRoot();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode<T> current = stack.pop();
            if (current.getData().equals(value)) {
                return current;
            }

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
        }

        return null;
    }

    public TreeNode<T> searchRecursive(BinaryTree<T> tree, T value) {
        return searchRecursive(tree.getRoot(), value);
    }

    public TreeNode<T> searchRecursive(TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (node.getData().equals(value)) {
            return node;
        }

        TreeNode<T> left = searchRecursive(node.getLeft(), value);
        TreeNode<T> right = searchRecursive(node.getRight(), value);
        return left != null ? left : right;
    }
}
