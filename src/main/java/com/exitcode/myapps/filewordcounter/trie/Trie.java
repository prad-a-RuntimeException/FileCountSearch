package com.exitcode.myapps.filewordcounter.trie;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 4:03 AM
 * Interface implementing Trie.
 */
public interface Trie {

    /**
     * Adds the word to the prefix trie.
     *
     * @param word
     */
    void addWord(final String word);

    /**
     * Gets the count of word from the prefix tree.
     *
     * @param word
     * @return
     */
    int countWords(final String word);


    /**
     * Prints all the words and its corresponding count in the prefix tree.
     *
     */
    void print();
}
