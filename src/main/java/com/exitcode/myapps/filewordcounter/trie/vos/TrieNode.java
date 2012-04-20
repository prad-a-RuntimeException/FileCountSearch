package com.exitcode.myapps.filewordcounter.trie.vos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 4:42 PM
 * TrieNode Object that represents the Node represented in the Trie.
 */
public class TrieNode<E> {

    private int wordCount;

    private final E node;

    private TrieNode<E> parent;

    private List<TrieNode<E>> childNodes;

    private TrieNode(E node) {
        this.node = node;
        this.childNodes = new ArrayList<TrieNode<E>>();
    }

    private TrieNode(E node, TrieNode<E> parent) {
        this.node = node;
        this.childNodes = new ArrayList<TrieNode<E>>();
        this.parent = parent;
    }

    public static <E> TrieNode createTrieNode(E node) {
        return new TrieNode(node, null);
    }

    public static <E> TrieNode createTrieNode(E node, TrieNode<Alphabets> parentNode) {
        return new TrieNode(node, parentNode);
    }

    public int getWordCount() {
        return wordCount;
    }


    public void addWordCount() {
        wordCount++;
    }


    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public List<TrieNode<E>> getChildNodes() {
        return childNodes;
    }

    public void addChildNodes(TrieNode<E> childNodes) {
        this.childNodes.add(childNodes);
    }

    public TrieNode<E> getParent() {
        return parent;
    }

    public void setParent(TrieNode<E> parent) {
        this.parent = parent;
    }

    public E getNode() {
        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrieNode trieNode = (TrieNode) o;
        if (node != null ? !node.equals(trieNode.node) : trieNode.node != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return node != null ? node.hashCode() : 0;
    }
}
