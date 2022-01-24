package com.epam.infohandling;

public class SentenceParser extends AbstractParser {

    public SentenceParser(Parser successor) {
        super(successor);
    }

    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] parts = text.split("\\[|]");
        for (String part : parts) {
            if (part.contains("+") || part.contains("-") || part.contains("*") ||
                    part.contains("/")) {
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
