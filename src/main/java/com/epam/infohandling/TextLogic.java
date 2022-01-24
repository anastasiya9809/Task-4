package com.epam.infohandling;

import java.util.List;
import java.util.Map;

public class TextLogic {

    public Composite parse(String text) {
        ChainBuilder builder = new ChainBuilder();
        Parser parser = builder.buildParser();
        return parser.parse(text);
    }

    public Composite calculate(Composite text, Map<String, Double> parameters) {
        return null;
    }

    public Composite reverse(Composite text) {
        return null;
    }

    public String restore(Composite text) {
        ChainBuilder builder = new ChainBuilder();
        Restorer restorer = builder.buildRestorer();
        return restorer.restore(text);
    }
}
