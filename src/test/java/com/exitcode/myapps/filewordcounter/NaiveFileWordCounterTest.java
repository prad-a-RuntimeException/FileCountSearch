package com.exitcode.myapps.filewordcounter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 7:00 AM
 * Test class for general WordCounter.
 */
public class NaiveFileWordCounterTest {

    protected static final String TEST_FILE = "/samplewordcount.txt";
    private static Logger logger = LoggerFactory.getLogger(NaiveFileWordCounterTest.class);

    @Test
    public void testCountWordsInFiles() throws Exception {

        FileWordCounter naiveFileWordCounter = new NaiveFileWordCounter();
        final String file = this.getClass().getResource(TEST_FILE).getFile();
        naiveFileWordCounter.printWordCountInFiles(new File(file));


    }
}
