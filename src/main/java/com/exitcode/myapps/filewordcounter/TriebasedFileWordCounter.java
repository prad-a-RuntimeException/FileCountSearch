package com.exitcode.myapps.filewordcounter;

import com.exitcode.myapps.filewordcounter.trie.Trie;
import com.exitcode.myapps.filewordcounter.trie.TrieImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 6:20 AM
 */
public class TriebasedFileWordCounter implements FileWordCounter {


    private final Trie trie = new TrieImpl();

    @Override
    public void printWordCountInFiles(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            final String line = scanner.nextLine().toUpperCase();
            trie.addWord(line);
        }


        trie.print();

    }
}
