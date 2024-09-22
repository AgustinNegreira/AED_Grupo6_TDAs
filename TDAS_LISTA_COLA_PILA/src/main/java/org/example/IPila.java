package org.example;

public interface IPila<T> {
    public T pop();

    public void push(T elemento);

    public T peek();
}