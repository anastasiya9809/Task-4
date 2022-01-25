package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextLogicTest {

    private static final List<Component> WORDS_AND_EXPRESSIONS = Arrays.asList(
            Lexeme.word("It"),
            Lexeme.word("has"),
            Lexeme.word("survived"),
            Lexeme.word("not"),
            Lexeme.word("only"),
            Lexeme.word("five"),
            Lexeme.word("centuries,"),
            Lexeme.word("but"),
            Lexeme.word("also"),
            Lexeme.word("the"),
            Lexeme.word("leap"),
            Lexeme.word("into"),
            Lexeme.expression("[13  2 +]"),
            Lexeme.word("electronic"),
            Lexeme.word("typesetting,"),
            Lexeme.word("remaining"),
            Lexeme.expression("[3  5 +]"),
            Lexeme.word("essentially"),
            Lexeme.expression("[15  3 /]"),
            Lexeme.word("unchanged")
            );
    private static final List<Component> WORDS = Arrays.asList(
            Lexeme.word("It"),
            Lexeme.word("has"),
            Lexeme.word("survived"),
            Lexeme.word("not"),
            Lexeme.word("only"),
            Lexeme.word("five"),
            Lexeme.word("centuries,"),
            Lexeme.word("but"),
            Lexeme.word("also"),
            Lexeme.word("the"),
            Lexeme.word("leap"),
            Lexeme.word("into"),
            Lexeme.word("15"),
            Lexeme.word("electronic"),
            Lexeme.word("typesetting,"),
            Lexeme.word("remaining"),
            Lexeme.word("8"),
            Lexeme.word("essentially"),
            Lexeme.word("5"),
            Lexeme.word("unchanged")
    );

    @Test
    public void testEvaluateExpressionsInSentenceShouldEvaluate()  {
        //given
        Composite SENTENCE_WITH_EXPRESSIONS = new Composite();
        for (Component component : WORDS_AND_EXPRESSIONS) {
            SENTENCE_WITH_EXPRESSIONS.add(component);
        }

        Composite SENTENCE_WITHOUT_EXPRESSIONS = new Composite();
        for (Component component : WORDS) {
            SENTENCE_WITHOUT_EXPRESSIONS.add(component);
        }

        ExpressionCalculator calculator = mock(ExpressionCalculator.class);
        when(calculator.calculate("13  2 +", null)).thenReturn(15.0);
        when(calculator.calculate("3  5 +", null)).thenReturn(8.0);
        when(calculator.calculate("15  3 /", null)).thenReturn(5.0);

        TextLogic logic = new TextLogic(calculator);

        //when
        Composite result = logic.evaluateExpressionsInSentence(SENTENCE_WITH_EXPRESSIONS, null);

        //then
        Assert.assertEquals(SENTENCE_WITHOUT_EXPRESSIONS, result);
    }
}
