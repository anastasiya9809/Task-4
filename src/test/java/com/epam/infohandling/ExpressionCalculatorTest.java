package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class ExpressionCalculatorTest {

    private static final String FIRST_EXPRESSION = "2 3 * 5 +";
    private static final String SECOND_EXPRESSION = "2 3 * x +";
    private static final HashMap<String, Double> VARIABLE_VALUE_PAIRS = new HashMap<>();

    @Test
    public void testCalculateShouldCalculateWhenNoVariables()  {
        //given
        ExpressionCalculator calculator = new ExpressionCalculator();

        //when
        double result = calculator.calculate(FIRST_EXPRESSION, null);

        //then
        Assert.assertEquals(11, result, 0);
    }

    @Test
    public void testCalculateShouldCalculateWhenVariablePresent()  {
        //given
        ExpressionCalculator calculator = new ExpressionCalculator();
        VARIABLE_VALUE_PAIRS.put("x", 4.0);

        //when
        double result = calculator.calculate(SECOND_EXPRESSION, VARIABLE_VALUE_PAIRS);

        //then
        Assert.assertEquals(10, result, 0);
    }
}
