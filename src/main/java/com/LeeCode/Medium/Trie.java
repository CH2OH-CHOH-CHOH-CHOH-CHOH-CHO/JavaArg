package com.LeeCode.Medium;
//208
public class Trie {
    private Trie[] child;
    private boolean isEnd;


    public Trie() {
        child = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie nowTrie = this;
        for(int i = 0;i<word.length();i++){
            int ch = word.charAt(i)-'a';
            if(nowTrie.child[ch]==null) {
                nowTrie.child[ch] = new Trie();
            }
            nowTrie = nowTrie.child[ch];
        }
        nowTrie.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.child[index] == null) {
                return null;
            }
            node = node.child[index];
        }
        return node;
    }
}
