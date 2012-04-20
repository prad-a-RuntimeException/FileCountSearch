package com.exitcode.myapps.filewordcounter.trie;

import com.exitcode.myapps.filewordcounter.trie.vos.Alphabets;
import com.exitcode.myapps.filewordcounter.trie.vos.TrieNode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 4:06 AM
 * Default Implementation of Trie. Uses an underlying Set of Enums. Enums ensure controlled list and this particular
 * implementation only handles Alphabets and throws IllegalArgument exception if numeric or special characters are used.
 */
public class TrieImpl implements Trie {

    private static Logger logger = LoggerFactory.getLogger(TrieImpl.class);
    private final TrieNode<Alphabets> rootNode = TrieNode.createTrieNode(Alphabets.ROOT_NODE);

    @Override
    public void addWord(String word) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(word));
        addWord(rootNode, word.toCharArray(), 0);
    }


    @Override
    public int countWords(String word) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(word));
        return countWords(rootNode, word.toCharArray(), 0);

    }

    @Override
    public void print() {
        _print(rootNode);
    }

    /**
     * Recursive method to add the word to the system. This method will add the word if the word does not
     * already exists and also will update the word count.
     *
     * @param node
     * @param chars
     * @param limit
     */
    private void addWord(TrieNode<Alphabets> node, char[] chars, int limit) {
        logger.trace("Entering addWord");
        if (limit == chars.length) {
            node.addWordCount();
        } else {
            char c = Character.toUpperCase(chars[limit]);
            TrieNode<Alphabets> childNode = TrieNode.createTrieNode(Alphabets.getValueOf(c), node);
            if (!node.getChildNodes().contains(childNode)) {
                node.addChildNodes(childNode);
            }
            limit++;
            addWord(node.getChildNodes().get(node.getChildNodes().indexOf(childNode)), chars, limit);
            logger.trace("Exiting addWord");
        }
        logger.trace("Exiting addWord");

    }


    private void _print(TrieNode<Alphabets> node) {

        for (TrieNode<Alphabets> o : node.getChildNodes()) {
            if (o.getWordCount() > 0) {
                System.out.printf("Word %s and count %d \n", getWord(o), o.getWordCount());
            }
            _print(o);
        }
    }

    private String getWord(TrieNode<Alphabets> node) {
        logger.trace("Entering getWord");

        StringBuilder word = new StringBuilder();
        while (!node.equals(rootNode)) {
            word.append(node.getNode().toString());
            node = node.getParent();
        }
        logger.trace("Exiting getWord");
        return word.reverse().toString();
    }

    private int countWords(TrieNode<Alphabets> node, char[] chars, int limit) {
        logger.trace("Entering countWords");
        if (limit == chars.length) {
            return node.getWordCount();
        }

        char c = Character.toUpperCase(chars[limit]);
        TrieNode childNode = TrieNode.createTrieNode(Alphabets.getValueOf(c));
        if (!node.getChildNodes().contains(childNode)) {
            return 0;
        } else {
            limit++;
            return countWords(node.getChildNodes().get(node.getChildNodes().indexOf(childNode)), chars, limit);
        }


    }
}
