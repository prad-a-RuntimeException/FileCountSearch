package com.exitcode.myapps.filewordcounter.trie;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 4:50 AM
 *
 */
public class TrieImplTest {

    private static Logger logger = LoggerFactory.getLogger(TrieImplTest.class);
    private Trie trie;

    @Before
    public void setup() {

        trie = new TrieImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWord_EmptyString() throws Exception {
        trie.addWord("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWord_NullString() throws Exception {

        trie.addWord(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWord_InvalidCharacter() throws Exception {

        trie.addWord("&&");
    }

    @Test
    public void testAddWordAndCount_IntialAddition() throws Exception {

        trie.addWord("Prad");
        // Case Insensitive. Hence Prad count should be 2.
        trie.addWord("prad");
        trie.addWord("prad");
        trie.addWord("pray");
        trie.addWord("prey");
        trie.addWord("prayer");
        trie.addWord("prayer");
        trie.addWord("Pra");
        trie.addWord("brad");
        int count = trie.countWords("Prad");
        assertEquals(3, count);

        count = trie.countWords("Pra");
        assertEquals(1, count);

        count = trie.countWords("brad");
        assertEquals(1, count);

        count = trie.countWords("pray");
        assertEquals(1, count);

        count = trie.countWords("prayer");
        assertEquals(2, count);

        //Although the word prefix exists, the exact word is not available.
        count = trie.countWords("bra");
        assertEquals(0, count);
        logger.info(trie.toString());
    }


    @Test
    public void testAddWordAndCount_IntialAddition1() throws Exception {

        trie.addWord("Richard");
        trie.addWord("Richard");
        trie.addWord("richard");
        trie.addWord("richerd");
        int count = trie.countWords("richard");
        assertEquals(3, count);


    }


    @Test(expected = IllegalArgumentException.class)
    public void testCountwords_EmptyString() throws Exception {
        trie.countWords("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountWords_NullString() throws Exception {

        trie.countWords(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountWords_InvalidCharacter() throws Exception {

        trie.countWords("&&");
    }

    @Test
    public void testCountWords_UnAvailableNode() throws Exception {

        final int count = trie.countWords("Mango");
        assertEquals(0, count);

    }


    @Test
    public void testPrint() throws Exception {

        trie.addWord("Prad");
        // Case Insensitive. Hence Prad count should be 2.
        trie.addWord("prad");
        trie.addWord("Pra");
        trie.addWord("brad");
        trie.addWord("rambo");
        trie.addWord("Rambo");
        trie.addWord("rambo");
        trie.addWord("pray");
        trie.addWord("prey");
        trie.addWord("prayer");
        trie.addWord("prayer");
        trie.addWord("Pra");

        trie.print();

    }


}
