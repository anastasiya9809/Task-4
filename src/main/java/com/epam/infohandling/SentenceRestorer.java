package com.epam.infohandling;

import java.util.List;

public class SentenceRestorer extends AbstractRestorer {

    public SentenceRestorer(Restorer successor) {
        super(successor);
    }

    public String restore(Composite sentence) {
        StringBuilder result = new StringBuilder();
        List<Component> words = sentence.getChildren();
        for (Component component : words) {
            Lexeme lexeme = (Lexeme) component;
            String part = lexeme.getValue();
            if (part.contains("+") || part.contains("-") || part.contains("*") ||
                    part.contains("/")) {
                part = "[" + part + "]";
            }
            result.append(part + " ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
