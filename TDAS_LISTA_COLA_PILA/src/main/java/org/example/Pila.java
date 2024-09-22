package org.example;

public class Pila<T> extends Lista<T> implements IPila<T>{

    public void push(T dato) {
        Nodo<T> nuevoNodo = new Nodo<T>(null, dato); // La clave no es necesaria aquí
        nuevoNodo.siguiente = primero; // El nuevo nodo apunta al actual "primero"
        primero = nuevoNodo; // Ahora, el nuevo nodo es el "primero" en la pila
    }

    public T pop() {
        if (primero == null) {
            return null; // Si la pila está vacía, devolver null o lanzar una excepción
        }
        T dato = primero.dato; // Guarda el dato del nodo "primero"
        primero = primero.siguiente; // Mueve el puntero 'primero' al siguiente nodo
        return dato; // Devuelve el dato del nodo que se removió de la pila
    }

    public T peek(){
        if (primero == null) {
            return null;
        }
        return primero.dato;
    }
}
