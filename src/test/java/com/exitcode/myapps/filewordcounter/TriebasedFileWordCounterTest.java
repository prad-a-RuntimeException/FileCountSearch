package com.exitcode.myapps.filewordcounter;

import org.junit.Test;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 6:31 AM
 * ${END}$
 */
public class TriebasedFileWordCounterTest {
    @Test
    public void testPrintWordCountInFiles() throws Exception {

        FileWordCounter triebasedFileWordCounter = new TriebasedFileWordCounter();
        final String file = this.getClass().getResource(NaiveFileWordCounterTest.TEST_FILE).getFile();
        triebasedFileWordCounter.printWordCountInFiles(new File(file));

    }
}
