package com.epam.infohandling;

import java.util.Comparator;

public class WordComparator implements Comparator<Component> {
    
    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        Lexeme firstLexeme = (Lexeme) firstComponent;
        int firstWordLength = firstLexeme.getValue().length();

        Lexeme secondLexeme = (Lexeme) secondComponent;
        int secondWordLength = secondLexeme.getValue().length();

        return Integer.compare(firstWordLength, secondWordLength);
    }
}
