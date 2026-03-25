package org.saturnclient.common.ref.render;

public interface MatrixStackRef {
    public void translate(float x, float y);

    public void scale(float x, float y);

    public void push();

    public void pop();
}
