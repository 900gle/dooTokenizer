package org.doo;

import org.apache.lucene.analysis.FilteringTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.util.Arrays;

public class HelloWorldTokenFilter extends FilteringTokenFilter {

    private final CharTermAttribute term = addAttribute(CharTermAttribute.class);

    public HelloWorldTokenFilter(TokenStream input) {
        super(input);
    }

    @Override
    public boolean accept() {
        if (term.length() != 5) return false;
        return Arrays.equals(term.buffer(), 0, 4, "hello".toCharArray(), 0, 4)
                || Arrays.equals(term.buffer(), 0, 4, "world".toCharArray(), 0, 4);
    }
}
