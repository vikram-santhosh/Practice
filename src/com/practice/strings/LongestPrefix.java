package com.practice.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPrefix {

    class Trie {
        Map<Character, Trie> children;
        boolean endOfWord;

        Trie () {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    Trie root = new Trie();
    public void insert(String word) {
        Trie curr = root;
        for (char ch : word.toCharArray()) {
            if (! curr.children.containsKey(ch)) {
                Trie node = new Trie();
                curr.children.put(ch, node);
            }
            curr = curr.children.get(ch);
        }
        curr.endOfWord = true;
    }

    public String findLongestPrefix() {
        Trie curr = root;
        StringBuffer sb = new StringBuffer();
        while (curr.children.size() == 1) {
            char ch = (char) curr.children.keySet().toArray()[0];
            sb.append(ch);
            curr = curr.children.get(ch);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        LongestPrefix obj = new LongestPrefix();
        obj.insert("aabbc");
        obj.insert("aabbc");
        obj.insert("aabaabc");
        System.out.println(obj.findLongestPrefix());
    }
}
