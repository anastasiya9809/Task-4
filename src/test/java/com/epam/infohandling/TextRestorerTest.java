package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextRestorerTest {
    private static final String TEXT_STRING = " It has survived - not only (five) centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged. " +
            "It was popularised in the with the release of Letraset sheets containing Lorem " +
            "Ipsum passages, and more recently with desktop publishing software like Aldus" +
            " PageMaker including versions of Lorem Ipsum.\n" +
            " It is a long established fact that a reader will be distracted by " +
            "the readable content of a page when looking at its layout. The point of using " +
            "Ipsum is that it has a more-or-less normal distribution of letters, as opposed " +
            "to using (Content here), content here, making it look like readable English.\n" +
            " It is an established fact that a reader will be of a page " +
            "when looking at its layout.\n Bye.";
    private static final String FIRST_PARAGRAPH_STRING = "It has survived - not only (five) centuries, " +
            "but also the leap into electronic typesetting, remaining essentially unchanged. " +
            "It was popularised in the with the release of Letraset sheets containing Lorem " +
            "Ipsum passages, and more recently with desktop publishing software like Aldus" +
            " PageMaker including versions of Lorem Ipsum.";
    private static final String SECOND_PARAGRAPH_STRING = "It is a long established fact that a reader will be distracted by " +
            "the readable content of a page when looking at its layout. The point of using " +
            "Ipsum is that it has a more-or-less normal distribution of letters, as opposed " +
            "to using (Content here), content here, making it look like readable English.";
    private static final String THIRD_PARAGRAPH_STRING = "It is an established fact that a reader will be of a page " +
            "when looking at its layout.";
    private static final String FOURTH_PARAGRAPH_STRING = "Bye.";
    private static final Composite TEXT = new Composite();
    private static final Composite FIRST_PARAGRAPH = mock(Composite.class);
    private static final Composite SECOND_PARAGRAPH = mock(Composite.class);
    private static final Composite THIRD_PARAGRAPH = mock(Composite.class);
    private static final Composite FOURTH_PARAGRAPH = mock(Composite.class);
    
    @Test
    public void testRestoreShouldRestore()  {
        //given
        TEXT.add(FIRST_PARAGRAPH);
        TEXT.add(SECOND_PARAGRAPH);
        TEXT.add(THIRD_PARAGRAPH);
        TEXT.add(FOURTH_PARAGRAPH);

        ParagraphRestorer paragraphRestorer = mock(ParagraphRestorer.class);
        when(paragraphRestorer.restore(FIRST_PARAGRAPH)).thenReturn(FIRST_PARAGRAPH_STRING);
        when(paragraphRestorer.restore(SECOND_PARAGRAPH)).thenReturn(SECOND_PARAGRAPH_STRING);
        when(paragraphRestorer.restore(THIRD_PARAGRAPH)).thenReturn(THIRD_PARAGRAPH_STRING);
        when(paragraphRestorer.restore(FOURTH_PARAGRAPH)).thenReturn(FOURTH_PARAGRAPH_STRING);

        TextRestorer textRestorer = new TextRestorer(paragraphRestorer);

        //when
        String result = textRestorer.restore(TEXT);

        //then
        Assert.assertEquals(TEXT_STRING, result);
    }
}
