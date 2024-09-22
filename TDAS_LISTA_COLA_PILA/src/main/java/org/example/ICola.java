package org.example;

public interface ICola<T> {
    public T desencolar();

    public void encolar(T valor);

    public T queuePeek();
}
