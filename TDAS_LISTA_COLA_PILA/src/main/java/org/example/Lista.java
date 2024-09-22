package org.example;

public class Lista<T> implements ILista<T> {

    public class Nodo<T> {

        private final Comparable etiqueta;
        public T dato;
        public Nodo<T> siguiente = null;

        public Nodo(Comparable etiqueta, T dato ) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }
    }

    public Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo<T> nuevoNodo = new Nodo<T>(clave, dato);
        if (primero != null){
            primero = nuevoNodo;
            nuevoNodo.siguiente = null;
        }
        else{
            nuevoNodo.siguiente = primero;
            primero = nuevoNodo;
        }
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> nodo = primero;
        while (nodo != null){
            if (clave.equals(nodo.etiqueta)){
                return nodo.dato;
            }
            nodo = nodo.siguiente;
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public String imprimir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }

    @Override
    public String imprimir(String separador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }

    @Override
    public int cantElementos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantElementos'");
    }

    @Override
    public boolean esVacia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esVacia'");
    }
}
