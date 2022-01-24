package com.epam.infohandling;

public class ChainBuilder {

    public Parser buildParser() {
        return new TextParser(new ParagraphParser(new SentenceParser(null)));
    }
    
    public Restorer buildRestorer() {
        return new TextRestorer(new ParagraphRestorer(new SentenceRestorer(null)));
    }
}
