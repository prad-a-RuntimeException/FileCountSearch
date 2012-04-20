package com.exitcode.myapps.filewordcounter.trie.vos;

import com.google.common.base.Strings;

import java.util.EnumSet;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: pradheepraju
 * Date: 4/20/12
 * Time: 4:18 PM
 * Values for Alphabet Nodes to be populated in trie. Should be used if the Trie is limited to
 * alphabets only.
 */
public enum Alphabets {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, SPACE, ROOT_NODE, NO_EDGE;

    public static final EnumSet<Alphabets> ALL_ALPHABETS = EnumSet.range(Alphabets.A, Alphabets.C);


    public static Alphabets getValueOf(char value) {

        String strValue = String.valueOf(value);
        if (Strings.isNullOrEmpty(strValue.trim())) {
            return SPACE;
        } else {
            return Alphabets.valueOf(strValue);
        }

    }

    @Override
    public String toString() {

        if (this == SPACE) {
            return " ";
        }

        return super.toString();

    }


}





