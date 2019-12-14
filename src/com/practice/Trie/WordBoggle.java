package com.practice.Trie;

import java.util.*;

/**
 * Created by Flinstone on 16-Nov-19.
 */
public class WordBoggle {
    class Solution {


        class TrieNode {
            Map<Character, TrieNode> children;
            boolean endOfWord;

            TrieNode() {
                children = new HashMap<>();
                endOfWord = false;
            }
        }


        public TrieNode buildTrie(List<String> words) {
            TrieNode root = new TrieNode();
            for( String word : words) {
                insert(root, word);
            }
            return root;
        }

        public void insert(TrieNode curr, String word) {
            for (char c : word.toCharArray()) {
                TrieNode node = curr.children.get(c);
                if (node == null) {
                    node = new TrieNode();
                    curr.children.put(c, node);
                }
                curr = node;
            }
            curr.endOfWord = true;
        }

        public boolean searchPrefix(String prefix, TrieNode root) {
            for (char c : prefix.toCharArray()) {
                root = root.children.get(c);
                if (root == null) return false;
            }
            return true;
        }
        public List<String> findWords(char[][] board, String[] words) {
            int n = board.length;
            int m = board[0].length;

            int max_word_size = 0;

            Set<String> found = new HashSet<>();
            //Set<Character> start = new HashSet<>();

            //for(int i=0; i<words.length; i++) start.add(words[i].charAt(0));

            //for(int i=0; i<words.length; i++) max_word_size = Math.max(words[i].length(), max_word_size);

            TrieNode trieRoot = buildTrie(Arrays.asList(words));

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    //if (start.contains(board[i][j])) {
                    boolean visited[][] = new boolean[n][m];
                    StringBuffer sb = new StringBuffer();
                    solve(board, Arrays.asList(words), i, j, n, m, visited, sb, found, trieRoot);
                    //}

                }
            }

            return new ArrayList<>(found);
        }

        public void solve(char[][] board, List<String> words, int i, int j, int n, int m,
                          boolean visited[][], StringBuffer sb, Set<String> found, TrieNode trieRoot) {
            if ( i < n && i >=0 && j < m && j >=0 && !visited[i][j] ) {
                sb.append(board[i][j]);
                visited[i][j] = true;
                if ( words.contains(sb.toString()) ) found.add(sb.toString());
                if (searchPrefix(sb.toString(), trieRoot)) {
                    solve(board, words, i+1, j, n, m, visited, sb, found, trieRoot);
                    solve(board, words, i-1, j, n, m, visited, sb, found, trieRoot);
                    solve(board, words, i, j+1, n, m, visited, sb, found, trieRoot);
                    solve(board, words, i, j-1, n, m, visited, sb, found, trieRoot);
                }

                sb.deleteCharAt(sb.length()-1);
                visited[i][j] = false;
            }
        }
    }
}
