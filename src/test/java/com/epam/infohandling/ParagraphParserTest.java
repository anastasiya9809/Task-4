package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class ParagraphParserTest {
    private static final String TEXT = "It has survived - not only (five) centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged. " +
            "It was popularised in the with the release of Letraset sheets containing Lorem " +
            "Ipsum passages, and more recently with desktop publishing software like Aldus" +
            " PageMaker including versions of Lorem Ipsum.";
    private static final String FIRST_SENTENCE = "It has survived - not only (five) centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged.";
    private static final String SECOND_SENTENCE = "It was popularised in the with the release " +
            "of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop" +
            " publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    private static final Composite COMPOSITE = Mockito.mock(Composite.class);

    @Test
    public void testParseShouldParse()  {
        //given
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(COMPOSITE);
        when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(COMPOSITE);

        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

        //when
        Composite expected = new Composite(Arrays.asList(
                COMPOSITE,
                COMPOSITE
        ));
        Composite actual = paragraphParser.parse(TEXT);

        //then
        Assert.assertEquals(expected, actual);
    }
}
