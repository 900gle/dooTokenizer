package org.doo;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.plugin.NamedComponent;
import org.elasticsearch.plugin.analysis.TokenFilterFactory;

@NamedComponent(value = "doogle_token")
public class DooTokenFilterFactory implements TokenFilterFactory {

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new DooTokenFilter(tokenStream);
    }


}
