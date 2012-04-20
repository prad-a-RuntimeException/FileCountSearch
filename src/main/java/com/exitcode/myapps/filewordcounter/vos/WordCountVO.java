package com.exitcode.myapps.filewordcounter.vos;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 5:55 AM
 * Object that stores word count information,
 */
public class WordCountVO implements Comparable<WordCountVO> {

    private final String word;
    private final int count;

    private WordCountVO(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public static WordCountVO createWordCountVO(String word, int count) {
        return new WordCountVO(word, count);
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(WordCountVO wordCountVO) {
        return new Integer(wordCountVO.getCount()).compareTo(this.getCount());
    }

    @Override
    public String toString() {
        return
                "word='" + word + '\'' +
                        ", count=" + count
                ;
    }
}
