package com.epam.infohandling;

import java.util.Objects;

public class Lexeme implements Component {

    private final String value;
    private final LexemeType type;

    private Lexeme(String value, LexemeType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public LexemeType getType() {
        return type;
    }

    public static Lexeme word(String value) {
        return new Lexeme(value, LexemeType.WORD);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value, LexemeType.EXPRESSION);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lexeme lexeme = (Lexeme) o;
        return value.equals(lexeme.value) && type == lexeme.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
