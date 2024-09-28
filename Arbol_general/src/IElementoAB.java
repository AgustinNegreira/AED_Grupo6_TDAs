
import java.util.LinkedList;

/**
 * Interfaz para el elemento de un árbol binario.
 *
 * @param <T> Tipo de los datos almacenados en el elemento.
 */
@SuppressWarnings({"rawtypes"})
public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();



    /**
     * Busca un elemento dentro del árbol con la etiqueta indicada.
     *
     * @param unaEtiqueta Etiqueta del nodo a buscar.
     * @return Elemento encontrado. Si no se encuentra, retorna nulo.
     */
    public IElementoAB<T> buscar(Comparable unaEtiqueta);
    public IElementoAB<T> buscarPadre(Comparable unaEtiqueta);

    /**
     * Inserta un elemento en el árbol.
     *
     * @param elemento Elemento a insertar.
     * @return Éxito de la operación.
     */
    public boolean insertar(IElementoAB<T> elemento, Comparable etiqueta);
    public boolean insertarSimplificado(IElementoAB<T> elemento, Comparable etiqueta);

    /**
     * Agrega las etiquetas del recorrido en preorden a una lista enlazada.
     *
     * @param unaLista Lista en la cual se deben agregar las etiquetas.
     */
    public void preOrden(LinkedList<T> unaLista);
    
    /**
     * Agrega las etiquetas del recorrido en inorden a una lista enlazada.
     *
     * @param unaLista Lista en la cual se deben agregar las etiquetas.
     */
    public void inOrden(LinkedList<T> unaLista);
    
    /**
     * Agrega las etiquetas del recorrido en postorden a una lista enlazada.
     *
     * @param unaLista Lista en la cual se deben agregar las etiquetas.
     */
    public void postOrden(LinkedList<T> unaLista);

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return Los datos del elemento.
     */
    public T getDatos();
   
    /**
     * Elimina un elemento dado una etiqueta.
     *
     * @param unaEtiqueta Etiqueta del elemento a eliminar.
     * @return Elemento que fue eliminado. Si no se encuentra, retorna nulo.
     */
    public IElementoAB<T> eliminar(Comparable unaEtiqueta);
    
    /**
     * Obtiene el tamaño del árbol (número de elementos).
     *
     * @return Tamaño del árbol.
     */
    public int obtenerTamaño();

    public int altura();
    public IElementoAB getPrimerHijo();
    public IElementoAB getSiguienteHermano();
    public void setPrimerHijo(IElementoAB<T> elemento);
    public void setSiguienteHermano(IElementoAB<T> elemento);
}