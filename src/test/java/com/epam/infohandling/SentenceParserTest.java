package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SentenceParserTest {

    private static final List<Component> LEXEMES = Arrays.asList(
            Lexeme.word("It"),
            Lexeme.word("is"),
            Lexeme.word("a"),
            Lexeme.expression("[1200  5 /]"),
            Lexeme.word("well-established"),
            Lexeme.word("fact.")
    );
    private static final String TEXT = "It is a [1200  5 /] well-established fact.";

    @Test
    public void testParseShouldParse()  {
        //given
        SentenceParser parser = new SentenceParser(null);

        //when
        Composite expected = new Composite(LEXEMES);
        Composite actual = parser.parse(TEXT);

        //then
        Assert.assertEquals(expected, actual);
    }
}
