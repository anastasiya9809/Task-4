package com.epam.infohandling;

import java.util.List;

public class TextRestorer extends AbstractRestorer {

    public TextRestorer(Restorer successor) {
        super(successor);
    }

    public String restore(Composite text) {
        StringBuilder result = new StringBuilder();
        List<Component> paragraphs = text.getChildren();
        if (paragraphs.size() != 0) {
            result.append(" ");
        }
        for (Component component : paragraphs) {
            Composite composite = (Composite) component;
            String paragraph = successor.restore(composite);
            result.append(paragraph).append("\n ");
        }
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }
}
