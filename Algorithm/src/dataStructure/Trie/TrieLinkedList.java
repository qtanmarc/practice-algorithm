package dataStructure.Trie;

import java.util.LinkedList;

/**
 * In array implementation, the character in the node will be used as index to find the pointer of the child.
 * Array takes space.
 * Linkedlist overcomes this problem by creating nodes only for the next character in the word.
 * However a method is called to find the child by search each node in the list.
 * So this implementation uses time to trade the space.
 */
public class TrieLinkedList {

    static class TrieNode {
        char data;
        LinkedList<TrieNode> children = new LinkedList<>();
        boolean isEnd = false;

        TrieNode(char c) {
            data = c;
        }

        TrieNode getChild(char c) {
            for (TrieNode node : children) {
                if (node.data == c) {
                    return node;
                }
            }
            return null;
        }
    }

    static class Trie {
        TrieNode root = new TrieNode(' ');

        boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.data != c) {
                    return false;
                }
                node = node.getChild(c);
            }
            return node.isEnd;
        }

        void insert(String word) {
            if (search(word)) {
                System.out.println(word + " is already in trie.");
                return;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.getChild(c) == null) {
                    node.children.add(new TrieNode(c));
                }
                node = node.getChild(c);
            }
            node.isEnd = true;
        }

        void delete(String word) {
            if (!search(word)) {
                System.out.println(word + " does not exist in trie.");
                return;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.getChild(c) == null) {
                    return;
                }
                node = node.getChild(c);
            }
            node.isEnd = false;
        }
    }
}
