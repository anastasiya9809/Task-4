package com.epam.infohandling;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<Component> {

    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        Composite firstComposite = (Composite) firstComponent;
        int firstSentenceNumber = firstComposite.getChildren().size();

        Composite secondComposite = (Composite) secondComponent;
        int secondSentenceNumber = secondComposite.getChildren().size();

        return Integer.compare(firstSentenceNumber, secondSentenceNumber);
    }
}
