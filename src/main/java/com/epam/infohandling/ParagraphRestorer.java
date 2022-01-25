package com.epam.infohandling;

import java.util.List;

public class ParagraphRestorer extends AbstractRestorer {

    public ParagraphRestorer(Restorer successor) {
        super(successor);
    }

    public String restore(Composite paragraph) {
        StringBuilder result = new StringBuilder();
        List<Component> sentences = paragraph.getChildren();
        for (Component component : sentences) {
            Composite composite = (Composite) component;
            String sentence = successor.restore(composite);
            result.append(sentence).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
