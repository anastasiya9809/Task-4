package com.epam.infohandling;

import java.util.ArrayDeque;
import java.util.Map;

public class ExpressionCalculator {

    private static final String OPERATORS = "+-*/";

    public double calculate(String expression, Map<String, Double> parameters) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        fillStack(expression, stack);
        return evaluateStack(stack, parameters);
    }

    public void fillStack(String expression, ArrayDeque<String> stack) {
        String[] elements = expression.split(" +");
        for (int i = elements.length - 1; i >= 0; i--) {
            stack.push(elements[i]);
        }
    }

    private double evaluateStack(ArrayDeque<String> stack, Map<String, Double> parameters) {
        double firstArgument = Double.NaN;
        double secondArgument = Double.NaN;
        while (true) {
            String element = stack.pop();
            if (OPERATORS.contains(element)) {
                double result = evaluateSingleExpression(element, firstArgument, secondArgument);
                if (stack.size() == 0) {
                    return result;
                }

                String resultString = Double.toString(result);
                stack.push(resultString);
                firstArgument = Double.NaN;
                secondArgument = Double.NaN;
            } else {
                double argument = setArgument(element, parameters);
                if (Double.isNaN(firstArgument)) {
                    firstArgument = argument;
                } else {
                    secondArgument = argument;
                }
            }
        }
    }

    public double setArgument(String element, Map<String, Double> parameters) {
        try {
            return Double.parseDouble(element);
        }
        catch(NumberFormatException e) {
            return parameters.get(element);
        }
    }

    public double evaluateSingleExpression(String operator, double firstArgument, double secondArgument) {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstArgument + secondArgument;
                break;
            case "-":
                result = firstArgument - secondArgument;
                break;
            case "*":
                result = firstArgument * secondArgument;
                break;
            case "/":
                result = firstArgument / secondArgument;
        }
        return result;
    }
}
