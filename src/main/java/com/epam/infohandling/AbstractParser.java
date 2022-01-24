package com.epam.infohandling;

public abstract class AbstractParser implements Parser {

    protected Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }
}
