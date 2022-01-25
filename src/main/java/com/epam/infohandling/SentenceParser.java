package com.epam.infohandling;

import java.util.ArrayList;

public class SentenceParser extends AbstractParser {

    public SentenceParser(Parser successor) {
        super(successor);
    }

    public Composite parse(String text) {
        Composite composite = new Composite(new ArrayList<>());
        String[] parts = text.split("[\\[\\]]");
        for (String part : parts) {
            char firstCharacter = ' ';
            if (!part.isEmpty()) {
                firstCharacter = part.charAt(0);
            }
            if (Character.isDigit(firstCharacter)) {
                part = "[" + part + "]";
                Lexeme expression = Lexeme.expression(part);
                composite.add(expression);
            } else {
                part = part.trim();
                String[] words = part.split(" ");
                for (String word : words) {
                    Lexeme wordLexeme = Lexeme.word(word);
                    composite.add(wordLexeme);
                }
            }
        }

        return composite;
    }
}
