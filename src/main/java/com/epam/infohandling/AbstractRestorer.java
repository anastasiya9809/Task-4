package com.epam.infohandling;

public abstract class AbstractRestorer implements Restorer {
    protected Restorer successor;

    public AbstractRestorer(Restorer successor) {
        this.successor = successor;
    }
}
