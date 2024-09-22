package uy.edu.ucu.aed.tdas.arbolAVL;


public class NodoAVL<T> implements INodo<T> {

    private Comparable etiqueta;
    private T dato;
    private NodoAVL<T> siguiente = null;
    private NodoAVL<T> izquierda; // Hijo izquierdo
    private NodoAVL<T> derecha;   // Hijo derecho
    private int altura;        // Altura del nodo

    public NodoAVL(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;

    }

    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    public NodoAVL<T> getIzquierda() {
        return this.izquierda;
    }

    public void setIzquierda(NodoAVL<T> nodo) {
        this.izquierda = nodo;
    }

    public NodoAVL<T> getDerecha() {
        return this.derecha;
    }

    public void setDerecha(NodoAVL<T> nodo) {
        this.derecha = nodo;
    }

    public void imprimir() {
        System.out.println(dato.toString());
    }

    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    public NodoAVL<T> clonar() {
        return new NodoAVL<>(this.etiqueta, this.dato);
    }

    /**
     *
     * @param unNodoAVL
     * @return
     */

    public boolean equals(NodoAVL unNodoAVL) {
        return this.dato.equals(unNodoAVL.getDato());
    }

    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

    public NodoAVL<T> getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodoAVL<T> nodo) {
        this.siguiente = nodo;
    }

    public void actualizarAltura() {
        int alturaIzquierda = (izquierda != null) ? izquierda.altura : 0;
        int alturaDerecha = (derecha != null) ? derecha.altura : 0;
        altura = 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    public int obtenerBalance() {
        int alturaIzquierda = (izquierda != null) ? izquierda.altura : 0;
        int alturaDerecha = (derecha != null) ? derecha.altura : 0;
        return alturaIzquierda - alturaDerecha;
    }
    
}