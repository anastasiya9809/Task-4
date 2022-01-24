package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TextLogicTest {

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

    @Test
    public void testParseShouldParse()  {
        //given
        TextLogic logic = new TextLogic();

        ChainBuilder builder = new ChainBuilder();
        Parser parser = builder.buildParser();

        //when
        Composite expected = parser.parse(TEXT);
        Composite actual = logic.parse(TEXT);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRestoreShouldRestore()  {
        //given
        TextLogic logic = new TextLogic();

        ChainBuilder builder = new ChainBuilder();
        Restorer restorer = builder.buildRestorer();

        Composite composite = logic.parse(TEXT);

        //when
        //Composite expected = parser.parse(TEXT);
        Composite actual = logic.parse(TEXT);

        //then
        //Assert.assertEquals(expected, actual);
    }
}
