package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParagraphRestorerTest {

    private static final String TEXT = "It has survived - not only (five) centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged. " +
            "It was popularised in the with the release of Letraset sheets containing Lorem " +
            "Ipsum passages, and more recently with desktop publishing software like Aldus" +
            " PageMaker including versions of Lorem Ipsum.";
    private static final String FIRST_SENTENCE_STRING = "It has survived - not only (five) centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged.";
    private static final String SECOND_SENTENCE_STRING = "It was popularised in the with the release " +
            "of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop" +
            " publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    private static final Composite FIRST_SENTENCE = mock(Composite.class);
    private static final Composite SECOND_SENTENCE = mock(Composite.class);
    private static final Composite PARAGRAPH = new Composite(Arrays.asList(
            FIRST_SENTENCE,
            SECOND_SENTENCE
    ));

    @Test
    public void testRestoreShouldRestore()  {
        //given
        SentenceRestorer sentenceRestorer = Mockito.mock(SentenceRestorer.class);
        when(sentenceRestorer.restore(FIRST_SENTENCE)).thenReturn(FIRST_SENTENCE_STRING);
        when(sentenceRestorer.restore(SECOND_SENTENCE)).thenReturn(SECOND_SENTENCE_STRING);

        ParagraphRestorer paragraphRestorer = new ParagraphRestorer(sentenceRestorer);

        //when
        String result = paragraphRestorer.restore(PARAGRAPH);

        //then
        Assert.assertEquals(TEXT, result);
    }
}
