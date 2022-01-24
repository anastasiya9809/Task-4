package com.epam.infohandling;

import java.util.Map;
import java.util.Stack;

public class ExpressionCalculator {

    private static final String OPERATORS = "+-*/";

    public double calculate(String expression, Map<String, Double> parameters) {
        Stack<String> stack = new Stack<>();
        String[] elements = expression.split(" ");
        for (int i = elements.length - 1; i >= 0; i--) {
            stack.push(elements[i]);
        }

        String element = stack.peek();
        double firstArgument;
        double secondArgument;
        if (!OPERATORS.contains(element)) {

        }

        return 0;
    }
}
