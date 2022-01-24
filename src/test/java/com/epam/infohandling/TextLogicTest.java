package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TextLogicTest {

    private static final String TEXT = "It has survived - not only (five) centuries, " +
            "but also the leap into [13  2 +] electronic typesetting, remaining [3  5 +]" +
            " essentially [15  3 /] unchanged.";

    @Test
    public void testEvaluateExpressionsInSentence()  {
        //given
        TextLogic logic = new TextLogic(new ExpressionCalculator());

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
        //TextLogic logic = new TextLogic();

//        ChainBuilder builder = new ChainBuilder();
//        Restorer restorer = builder.buildRestorer();
//
//        Composite composite = logic.parse(TEXT);
//
//        //when
//        //Composite expected = parser.parse(TEXT);
//        Composite actual = logic.parse(TEXT);

        //then
        //Assert.assertEquals(expected, actual);
    }
}
