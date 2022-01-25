package com.epam.infohandling;

import java.util.List;
import java.util.Objects;

public class Composite implements Component {

    private final List<Component> children;

    public Composite(List<Component> children) {
        this.children = children;
    }

    public void add(Component child) {
        children.add(child);
    }

    public List<Component> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return children.equals(composite.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children);
    }
}
