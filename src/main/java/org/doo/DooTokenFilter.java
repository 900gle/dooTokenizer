package org.doo;

import org.apache.lucene.analysis.FilteringTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.util.Arrays;

public class DooTokenFilter extends FilteringTokenFilter {

    private final CharTermAttribute term = addAttribute(CharTermAttribute.class);

    public DooTokenFilter(TokenStream input) {
        super(input);
    }

    @Override
    public boolean accept() {
        if (term.length() != 5) return false;
        return Arrays.equals(term.buffer(), 0, 4, "doooo".toCharArray(), 0, 4)
                || Arrays.equals(term.buffer(), 0, 4, "coooo".toCharArray(), 0, 4);
    }
}
