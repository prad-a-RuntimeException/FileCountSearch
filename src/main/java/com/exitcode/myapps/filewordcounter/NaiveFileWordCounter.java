package com.exitcode.myapps.filewordcounter;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 6:58 AM
 * This is an implementation of FileWordCounter using hash map.
 */
public class NaiveFileWordCounter implements FileWordCounter {

    private final Map<String, Integer> wordCountMap = Maps.newHashMap();
    private static Logger logger = LoggerFactory.getLogger(NaiveFileWordCounter.class);


    @Override
    public void printWordCountInFiles(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            final String line = scanner.nextLine().toUpperCase();
            if (wordCountMap.containsKey(line)) {
                wordCountMap.put(line, wordCountMap.get(line) + 1);
            } else {
                wordCountMap.put(line, 1);
            }
        }

        for (String s : wordCountMap.keySet()) {

            System.out.printf("Word %s and count %d \n", s, wordCountMap.get(s));
        }

        // Only Needed if we need to print in order of occurrence
        /*List<WordCountVO> wordCountVOs = Lists.newArrayList();
        for (String s : wordCountMap.keySet()) {

            wordCountVOs.add(WordCountVO.createWordCountVO(s, wordCountMap.get(s)));

        }

        Collections.sort(wordCountVOs);

        for (WordCountVO wordCountVO : wordCountVOs) {
            logger.info(wordCountVO.toString());
        }
*/


    }
}
