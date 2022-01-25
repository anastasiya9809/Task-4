package com.epam.infohandling;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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
            Lexeme.word("unchanged.")
    );
    private static final Composite SENTENCE_WITH_EXPRESSIONS = new Composite(WORDS_AND_EXPRESSIONS);
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
            Lexeme.word("unchanged.")
    );
    private static final Composite SENTENCE = new Composite(WORDS);

    private static final List<Component> WORDS_AND_EXPRESSIONS_IN_FIRST_SENTENCE = Arrays.asList(
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
            Lexeme.word("unchanged.")
    );
    private static final List<Component> WORDS_AND_EXPRESSIONS_IN_SECOND_SENTENCE = Arrays.asList(
            Lexeme.word("It"),
            Lexeme.word("was"),
            Lexeme.word("popularised"),
            Lexeme.word("in"),
            Lexeme.word("the"),
            Lexeme.expression("[5 x *]"),
            Lexeme.word("with"),
            Lexeme.word("the"),
            Lexeme.word("release"),
            Lexeme.word("of"),
            Lexeme.word("Letraset"),
            Lexeme.word("sheets.")
    );
    private static final List<Component> SENTENCES_WITH_EXPRESSIONS_IN_FIRST_PARAGRAPH = Arrays.asList(
            new Composite(WORDS_AND_EXPRESSIONS_IN_FIRST_SENTENCE),
            new Composite(WORDS_AND_EXPRESSIONS_IN_SECOND_SENTENCE)
    );
    private static final Composite FIRST_PARAGRAPH_WITH_EXPRESSIONS = new Composite(SENTENCES_WITH_EXPRESSIONS_IN_FIRST_PARAGRAPH);
    private static final List<Component> WORDS_AND_EXPRESSIONS_IN_THIRD_SENTENCE = Arrays.asList(
            Lexeme.word("It"),
            Lexeme.word("is"),
            Lexeme.word("a"),
            Lexeme.word("fact"),
            Lexeme.word("that"),
            Lexeme.word("a"),
            Lexeme.word("reader"),
            Lexeme.word("will"),
            Lexeme.word("be"),
            Lexeme.word("distracted"),
            Lexeme.word("by"),
            Lexeme.word("the"),
            Lexeme.word("readable"),
            Lexeme.word("content"),
            Lexeme.word("of"),
            Lexeme.word("a"),
            Lexeme.word("page.")
    );
    private static final List<Component> WORDS_AND_EXPRESSIONS_IN_FOURTH_SENTENCE = Arrays.asList(
            Lexeme.word("The"),
            Lexeme.word("point"),
            Lexeme.word("of"),
            Lexeme.word("using"),
            Lexeme.expression("[2 3 * y +]"),
            Lexeme.word("Ipsum"),
            Lexeme.word("is"),
            Lexeme.word("that"),
            Lexeme.word("it"),
            Lexeme.word("has"),
            Lexeme.word("a"),
            Lexeme.word("normal"),
            Lexeme.word("distribution"),
            Lexeme.word("of"),
            Lexeme.word("letters.")
    );
    List<Component> SENTENCES_WITH_EXPRESSIONS_IN_SECOND_PARAGRAPH = Arrays.asList(
            new Composite(WORDS_AND_EXPRESSIONS_IN_THIRD_SENTENCE),
            new Composite(WORDS_AND_EXPRESSIONS_IN_FOURTH_SENTENCE)
    );
    Composite SECOND_PARAGRAPH_WITH_EXPRESSIONS = new Composite(SENTENCES_WITH_EXPRESSIONS_IN_SECOND_PARAGRAPH);
    List<Component> PARAGRAPHS_WITH_EXPRESSIONS = Arrays.asList(
            FIRST_PARAGRAPH_WITH_EXPRESSIONS,
            SECOND_PARAGRAPH_WITH_EXPRESSIONS
    );
    Composite TEXT_WITH_EXPRESSIONS = new Composite(PARAGRAPHS_WITH_EXPRESSIONS);
    private static final List<Component> WORDS_IN_FIRST_SENTENCE = Arrays.asList(
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
            Lexeme.word("unchanged.")
    );
    private static final List<Component> WORDS_IN_SECOND_SENTENCE = Arrays.asList(
            Lexeme.word("It"),
            Lexeme.word("was"),
            Lexeme.word("popularised"),
            Lexeme.word("in"),
            Lexeme.word("the"),
            Lexeme.word("50"),
            Lexeme.word("with"),
            Lexeme.word("the"),
            Lexeme.word("release"),
            Lexeme.word("of"),
            Lexeme.word("Letraset"),
            Lexeme.word("sheets.")
    );
    private static final List<Component> SENTENCES_IN_FIRST_PARAGRAPH = Arrays.asList(
            new Composite(WORDS_IN_FIRST_SENTENCE),
            new Composite(WORDS_IN_SECOND_SENTENCE)
    );
    private static final Composite FIRST_PARAGRAPH = new Composite(SENTENCES_IN_FIRST_PARAGRAPH);
    private static final List<Component> WORDS_IN_THIRD_SENTENCE = Arrays.asList(
            Lexeme.word("It"),
            Lexeme.word("is"),
            Lexeme.word("a"),
            Lexeme.word("fact"),
            Lexeme.word("that"),
            Lexeme.word("a"),
            Lexeme.word("reader"),
            Lexeme.word("will"),
            Lexeme.word("be"),
            Lexeme.word("distracted"),
            Lexeme.word("by"),
            Lexeme.word("the"),
            Lexeme.word("readable"),
            Lexeme.word("content"),
            Lexeme.word("of"),
            Lexeme.word("a"),
            Lexeme.word("page.")
    );
    private static final List<Component> WORDS_IN_FOURTH_SENTENCE = Arrays.asList(
            Lexeme.word("The"),
            Lexeme.word("point"),
            Lexeme.word("of"),
            Lexeme.word("using"),
            Lexeme.word("26"),
            Lexeme.word("Ipsum"),
            Lexeme.word("is"),
            Lexeme.word("that"),
            Lexeme.word("it"),
            Lexeme.word("has"),
            Lexeme.word("a"),
            Lexeme.word("normal"),
            Lexeme.word("distribution"),
            Lexeme.word("of"),
            Lexeme.word("letters.")
    );
    List<Component> SENTENCES_IN_SECOND_PARAGRAPH = Arrays.asList(
            new Composite(WORDS_IN_THIRD_SENTENCE),
            new Composite(WORDS_IN_FOURTH_SENTENCE)
    );
    Composite SECOND_PARAGRAPH = new Composite(SENTENCES_IN_SECOND_PARAGRAPH);
    List<Component> PARAGRAPHS = Arrays.asList(
            FIRST_PARAGRAPH,
            SECOND_PARAGRAPH
    );
    Composite TEXT = new Composite(PARAGRAPHS);

    @Test
    public void testEvaluateExpressionsInSentenceShouldEvaluate()  {
        //given
        ExpressionCalculator calculator = mock(ExpressionCalculator.class);
        when(calculator.calculate("13  2 +", null)).thenReturn(15.0);
        when(calculator.calculate("3  5 +", null)).thenReturn(8.0);
        when(calculator.calculate("15  3 /", null)).thenReturn(5.0);

        TextLogic logic = new TextLogic(calculator);

        //when
        Composite result = logic.evaluateExpressionsInSentence(SENTENCE_WITH_EXPRESSIONS, null);

        //then
        Assert.assertEquals(SENTENCE, result);
    }
    
    @Test
    public void testCalculateShouldCalculate()  {
        //given
        Map<String, Double> parameters = new HashMap<>();
        parameters.put("x", 10.0);
        parameters.put("y", 20.0);

        ExpressionCalculator calculator = mock(ExpressionCalculator.class);
        when(calculator.calculate("13  2 +", parameters)).thenReturn(15.0);
        when(calculator.calculate("3  5 +", parameters)).thenReturn(8.0);
        when(calculator.calculate("15  3 /", parameters)).thenReturn(5.0);
        when(calculator.calculate("5 x *", parameters)).thenReturn(50.0);
        when(calculator.calculate("2 3 * y +", parameters)).thenReturn(26.0);

        TextLogic logic = new TextLogic(calculator);

        //when
        Composite result = logic.calculate(TEXT_WITH_EXPRESSIONS, parameters);

        //then
        Assert.assertEquals(TEXT, result);
    }
}
