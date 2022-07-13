package dataStructure.Trie;

/**
 * A trie is a tree-like structure in which every node stores a character or a digit.
 * After building a trie, strings or substrings can be retrieved by traversing down a path of the trie.
 * Insert a word and delete a word by key all takes O(n) at the expense of the storage.
 *
 * Trie's node can be implemented with Array, Linkedlist, HashMap.
 * Array is the most intuitive implementation. The character is used as index to find the pointer to the child node.
 * However, each node needs to declare a predefined length of (number of characters) array.
 * If you use only alphabet, the size is 26, if you use specical characters such a space, the size is 128 or more.
 * This takes memory space.
 *
 * https://www.lavivienpost.net/trie-part-1/
 */
public class TrieArray {

    // don't use 26 if there is space or any other special characters
    static final int NUM_OF_CHARS = 128;

    static class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[NUM_OF_CHARS];
        boolean isEnd;

        public TrieNode(char c) {
            data = c;
        }
    }

    static class Trie {
        TrieNode root = new TrieNode(' ');

        /**
         * To search a word in the trie, loop through each character in the word.
         * When the node is at the last character of the word, return the node's isEnd value,
         * which can be true or false (deleted).
         * @param word
         */
        boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.data != c) {
                    return false;
                }

                node = node.children[c];
            }
            return node.isEnd;
        }

        /**
         * Insert a word into the trie, Iteration, Time O(s), Space O(s), s is word length.
         */
        void insert(String word) {
            if (search(word)) {
                System.out.println(word + " is already in trie.");
                return;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c] == null) {
                    node.children[c] = new TrieNode(c);
                }
                node = node.children[c];
            }
            node.isEnd = true;
        }

        /**
         * To delete a word from a trie, first check if the word exists in the trie.
         * The same as insert, loop through each character in the word.
         * When the node is at the last character of the word, mark the node's isEnd to false.
         * The word is not actually deleted from the trie but becomes invisible.
         * @param word
         */
        void delete(String word) {
            if (this.search(word) == false) {
                System.out.println(word + " does not exist in trie.");
                return;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c] == null) {
                    return;
                }

                node = node.children[c];
            }
            node.isEnd= false;
        }
    }
}
