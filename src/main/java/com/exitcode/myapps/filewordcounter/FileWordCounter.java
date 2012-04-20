package com.exitcode.myapps.filewordcounter;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 5:52 AM
 * General Interface for counting words counts in a file.
 */
public interface FileWordCounter {


    void printWordCountInFiles(final File file) throws FileNotFoundException;


}
