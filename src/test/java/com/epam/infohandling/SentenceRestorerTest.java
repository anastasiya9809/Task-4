package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SentenceRestorerTest {

    private static final Composite SENTENCE = new Composite();
    private static final List<Lexeme> LEXEMES = Arrays.asList(
            Lexeme.word("It"),
            Lexeme.word("is"),
            Lexeme.word("a"),
            Lexeme.expression("[1200  5 /]"),
            Lexeme.word("established"),
            Lexeme.word("fact."));
    private static final String TEXT = "It is a [1200  5 /] established fact.";

    @Test
    public void testRestoreShouldRestore()  {
        //given
        SentenceRestorer restorer = new SentenceRestorer(null);
        for (Lexeme lexeme : LEXEMES) {
            SENTENCE.add(lexeme);
        }

        //when
        String result = restorer.restore(SENTENCE);

        //then
        Assert.assertEquals(TEXT, result);
    }
}
