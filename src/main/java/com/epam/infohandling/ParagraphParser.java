package com.epam.infohandling;

import java.util.ArrayList;

public class ParagraphParser extends AbstractParser {
    public ParagraphParser(Parser successor) {
        super(successor);
    }

    public Composite parse(String text) {
        Composite composite = new Composite(new ArrayList<>());
        String[] parts = text.split("\\. ");
        for (int i = 0; i < parts.length; i++) {
            if (i != parts.length - 1) {
                parts[i] = parts[i] + ".";
            }
            Composite sentence = successor.parse(parts[i]);
            composite.add(sentence);
        }
        return composite;
    }
}
