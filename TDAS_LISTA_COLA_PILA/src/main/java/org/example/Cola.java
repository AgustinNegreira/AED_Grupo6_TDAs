package org.example;

public class Cola<T> extends Lista<T> implements ICola<T> {

    public Nodo<T> ultimo;

    public T desencolar(){
        if (primero == null) {
            return null; // Si la pila está vacía, devolver null o lanzar una excepción
        }
        T dato = primero.dato; // Guarda el dato del nodo "primero"
        primero = primero.siguiente; // Mueve el puntero 'primero' al siguiente nodo
        return dato;
    }

    public void encolar(T valor){
        Nodo<T> nuevoNodo = new Nodo<T>(null, valor);

        if (primero == null){
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        }
        else{
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }

    }

    public T queuePeek(){
        if (primero == null) {
            return null;
        }
        return primero.dato;
    }
}
