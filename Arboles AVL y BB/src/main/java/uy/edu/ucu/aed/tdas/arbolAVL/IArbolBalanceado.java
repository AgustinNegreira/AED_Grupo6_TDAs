package uy.edu.ucu.aed.tdas.arbolAVL;


public interface IArbolBalanceado<T> {

    /**
     * Método encargado de insertar un nuevo nodo en el árbol.
     *
     * @param clave La clave del nodo a insertar.
     * @param dato  El dato asociado al nodo a insertar.
     */
    void insertar(Comparable clave, T dato);

    /**
     * Método encargado de eliminar un nodo del árbol.
     *
     * @param clave La clave del nodo a eliminar.
     * @return True si se logró eliminar el nodo, false en caso contrario.
     */
    boolean eliminar(Comparable clave);

    /**
     * Método encargado de buscar un nodo en el árbol dado su clave.
     *
     * @param clave La clave del nodo a buscar.
     * @return El dato asociado a la clave buscada, null si la clave no existe en el árbol.
     */
    T buscar(Comparable clave);

    /**
     * Método encargado de imprimir en orden el contenido del árbol.
     */
    void imprimir();

    /**
     * Método que indica si el árbol está vacío o no.
     *
     * @return True si el árbol está vacío, false en caso contrario.
     */
    boolean esVacio();
}