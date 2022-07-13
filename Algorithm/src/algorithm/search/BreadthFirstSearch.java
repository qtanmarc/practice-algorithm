package algorithm.search;

import dataStructure.Tree.BinaryTree;
import dataStructure.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> {

    /**
     * Breadth First Search starts from root, and explores its children before going to the next level.
     * BFS is usually implemented with Queue.
     * @param tree
     * @param value
     * @return
     */
    public TreeNode<T> search(BinaryTree<T> tree, T value) {
        TreeNode<T> root = tree.getRoot();

        if (root == null) {
            return null;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();

            if (current.getData().equals(value)) {
                return current;
            }

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return null;
    }
}
