package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TextParserTest {
    private static final String TEXT = "It has survived - not only (five) centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged. " +
            "It was popularised in the with the release of Letraset sheets containing Lorem " +
            "Ipsum passages, and more recently with desktop publishing software like Aldus" +
            " PageMaker including versions of Lorem Ipsum.        \n" +
            "            It is a long established fact that a reader will be distracted by " +
            "the readable content of a page when looking at its layout. The point of using " +
            "Ipsum is that it has a more-or-less normal distribution of letters, as opposed " +
            "to using (Content here), content here, making it look like readable English.\n" +
            "            It is an established fact that a reader will be of a page " +
            "when looking at its layout.\n" + "            Bye.     \n";
    private static final String FIRST_PARAGRAPH = "It has survived - not only (five) centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged. " +
            "It was popularised in the with the release of Letraset sheets containing Lorem " +
            "Ipsum passages, and more recently with desktop publishing software like Aldus" +
            " PageMaker including versions of Lorem Ipsum.";
    private static final String SECOND_PARAGRAPH = "It is a long established fact that a reader will be distracted by " +
            "the readable content of a page when looking at its layout. The point of using " +
            "Ipsum is that it has a more-or-less normal distribution of letters, as opposed " +
            "to using (Content here), content here, making it look like readable English.";
    private static final String THIRD_PARAGRAPH = "It is an established fact that a reader will be of a page " +
            "when looking at its layout.";
    private static final String FOURTH_PARAGRAPH = "Bye.";
    private static final Composite COMPOSITE = Mockito.mock(Composite.class);

    @Test
    public void testParseShouldParse()  {
        //given
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(COMPOSITE);
        when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(COMPOSITE);
        when(paragraphParser.parse(THIRD_PARAGRAPH)).thenReturn(COMPOSITE);
        when(paragraphParser.parse(FOURTH_PARAGRAPH)).thenReturn(COMPOSITE);

        TextParser textParser = new TextParser(paragraphParser);

        //when
        Composite expected = new Composite();
        expected.add(COMPOSITE);
        expected.add(COMPOSITE);
        expected.add(COMPOSITE);
        expected.add(COMPOSITE);
        Composite actual = textParser.parse(TEXT);

        //then
        Assert.assertEquals(expected, actual);
    }
}
