package com.epam.infohandling;

import java.util.List;
import java.util.Map;

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

    public Composite evaluateExpressionsInSentence(Composite composite, Map<String, Double> parameters) {
        Composite result = new Composite();
        List<Component> components = composite.getChildren();
        for (int i = 0; i < components.size(); i++) {
            Component component = components.get(i);
            Lexeme lexeme = (Lexeme) component;
            String part = lexeme.getValue();
            if (part.contains("+") || part.contains("-") || part.contains("*") ||
                    part.contains("/")) {
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
        List<Component> paragraphs = text.getChildren();
        for (Component paragraph : paragraphs) {
            Composite paragraphComposite = (Composite) paragraph;
            List<Component> sentences = paragraphComposite.getChildren();

            for (Component sentence : sentences) {
                Composite sentenceComposite = (Composite) sentence;
                evaluateExpressionsInSentence(sentenceComposite, parameters);
            }
        }

        return text;
    }

    public String restore(Composite text) {
        ChainBuilder builder = new ChainBuilder();
        Restorer restorer = builder.buildRestorer();
        return restorer.restore(text);
    }
}
