package com.epam.infohandling;

public class TextParser extends AbstractParser {

    public TextParser(Parser successor) {
        super(successor);
    }

    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] parts = text.split("\n");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
            Composite paragraph = successor.parse(parts[i]);
            composite.add(paragraph);
        }
        return composite;
    }
}
