package com.epam.infohandling;

import java.util.*;

public class TextLogic {

    private final ExpressionCalculator calculator;

    public TextLogic(ExpressionCalculator calculator) {
        this.calculator = calculator;
    }

    public Composite parse(String text) {
        ChainBuilder builder = new ChainBuilder();
        Parser parser = builder.buildParser();
        return parser.parse(text);
    }

    public String restore(Composite text) {
        ChainBuilder builder = new ChainBuilder();
        Restorer restorer = builder.buildRestorer();
        return restorer.restore(text);
    }

    public Composite evaluateExpressionsInSentence(Composite composite, Map<String, Double> parameters) {
        Composite result = new Composite(new ArrayList<>());
        List<Component> components = composite.getChildren();
        for (Component component : components) {
            Lexeme lexeme = (Lexeme) component;
            if (lexeme.getType() == LexemeType.EXPRESSION) {
                String part = lexeme.getValue();
                part = part.substring(1, part.length() - 1);
                double number = calculator.calculate(part, parameters);
                part = Double.toString(number);
                if (part.endsWith(".0")) {
                    part = part.substring(0, part.length() - 2);
                }
                result.add(Lexeme.word(part));
            } else {
                result.add(component);
            }
        }
        return result;
    }

    public Composite calculate(Composite text, Map<String, Double> parameters) {
        Composite result = new Composite(new ArrayList<>());
        List<Component> paragraphs = text.getChildren();

        for (Component paragraphComponent : paragraphs) {
            Composite paragraph = (Composite) paragraphComponent;
            List<Component> sentences = paragraph.getChildren();
            Composite newParagraph = new Composite(new ArrayList<>());

            for (Component sentenceComponent : sentences) {
                Composite sentence = (Composite) sentenceComponent;
                Composite newSentence = evaluateExpressionsInSentence(
                        sentence, parameters);
                newParagraph.add(newSentence);
            }

            result.add(newParagraph);
        }

        return result;
    }

    public Composite sortParagraphs(Composite text) {
        List<Component> paragraphs = text.getChildren();
        List<Component> sortedParagraphs = new ArrayList<>(paragraphs.size());
        Collections.copy(sortedParagraphs, paragraphs);
        Collections.sort(sortedParagraphs, new ParagraphComparator());
        return new Composite(sortedParagraphs);
    }

    public void sortWords(Composite text) {
        List<Component> paragraphs = text.getChildren();
        for (Component paragraphComponent : paragraphs) {
            Composite paragraph = (Composite) paragraphComponent;
            List<Component> sentences = paragraph.getChildren();

            for (Component sentenceComponent : sentences) {
                Composite sentence = (Composite) sentenceComponent;
                List<Component> words = sentence.getChildren();
                Collections.sort(words, new WordComparator());
            }
        }
    }
}
