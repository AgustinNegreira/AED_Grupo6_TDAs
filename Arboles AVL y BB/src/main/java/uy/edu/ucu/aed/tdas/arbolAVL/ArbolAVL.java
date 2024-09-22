package uy.edu.ucu.aed.tdas.arbolAVL;


public class ArbolAVL<T> implements IArbolBalanceado<T> {

    private NodoAVL<T> raiz;

    public NodoAVL<T> getRaiz() {
        return raiz;
    }    

    @Override
    public boolean eliminar(Comparable clave) {
        if (raiz == null) {
            return false; // No hay elementos en el árbol
        }
        
        // Buscar el nodo a eliminar
        raiz = eliminarNodo(raiz, clave);
        
        // Se asume que si el nodo se eliminó correctamente, se retornará true
        // De lo contrario, retornará false si no se encontró el nodo con la clave especificada
        return true;
    }

    private NodoAVL<T> eliminarNodo(NodoAVL<T> nodo, Comparable clave) {
        // Caso base: si el nodo es nulo, no hay nada que eliminar
        if (nodo == null) {
            return nodo;
        }
        System.out.println("Eliminando nodo con clave: " + clave + " en nodo con clave: " + nodo.getEtiqueta());
        // Buscar el nodo con la clave especificada en el subárbol izquierdo o derecho
        if (clave.compareTo(nodo.getEtiqueta()) < 0) {
            nodo.setIzquierda(eliminarNodo(nodo.getIzquierda(), clave));
        } else if (clave.compareTo(nodo.getEtiqueta()) > 0) {
            nodo.setDerecha(eliminarNodo(nodo.getDerecha(), clave));
        } else {
            // Nodo con la clave especificada encontrado, realizar la eliminación
            
            // Caso 1: nodo con al menos un hijo nulo
            if (nodo.getIzquierda() == null || nodo.getDerecha() == null) {
               
                NodoAVL<T> temp = null;
                if (nodo.getIzquierda() == null) {
                    temp = nodo.getDerecha();
                } else {
                    temp = nodo.getIzquierda();
                }
                
                // No hay hijos
                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else { // Hay un hijo
                    nodo = temp; // Copiar el contenido del hijo no nulo al nodo actual
                }
            } else {
                // Caso 2: nodo con dos hijos
                NodoAVL<T> sucesor = obtenerSucesor(nodo.getDerecha()); // Buscar el sucesor en el subárbol derecho
                nodo.setEtiqueta(sucesor.getEtiqueta()); // Copiar la etiqueta del sucesor al nodo actual
                nodo.setDato(sucesor.getDato());
                nodo.setDerecha(eliminarNodo(nodo.getDerecha(), sucesor.getEtiqueta())); // Eliminar el sucesor
            }
        }
    
        // Si el árbol tenía solo un nodo, no se necesita el balanceo
        if (nodo == null) {
            return nodo;
        }
    
        // Actualizar la altura del nodo actual
        nodo.actualizarAltura();
    
        // Balancear el árbol
        return balancearSubArbol(nodo);
    }
    
    private NodoAVL<T> obtenerSucesor(NodoAVL<T> nodo) {
        // Encontrar el nodo más a la izquierda en el subárbol derecho (sucesor en orden)
        NodoAVL<T> actual = nodo;
        while (actual.getIzquierda() != null) {
            actual = actual.getIzquierda();
        }
        return actual;
    }

    @Override
    public T buscar(Comparable clave) {
        return buscarEnArbol(raiz, clave);
    }

    private T buscarEnArbol(NodoAVL<T> nodo, Comparable clave) {
        if (nodo == null) {
            return null; // La clave no se encontró en el árbol
        }

        // Comparamos la clave del nodo actual con la clave buscada
        int comparacion = clave.compareTo(nodo.getEtiqueta());

        if (comparacion == 0) {
            // La clave coincide con la del nodo actual, se ha encontrado el nodo
            return nodo.getDato();
        } else if (comparacion < 0) {
            // La clave buscada es menor que la del nodo actual, buscamos en el subárbol izquierdo
            return buscarEnArbol(nodo.getIzquierda(), clave);
        } else {
            // La clave buscada es mayor que la del nodo actual, buscamos en el subárbol derecho
            return buscarEnArbol(nodo.getDerecha(), clave);
        }
    }

    @Override
    public void imprimir() {
        imprimirEnOrden(raiz);
    }

    private void imprimirEnOrden(NodoAVL<T> nodo) {
        if (nodo != null) {
            imprimirEnOrden(nodo.getIzquierda());
            System.out.print(nodo.getDato() + " ");
            imprimirEnOrden(nodo.getDerecha());
        }
    }    

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    private NodoAVL<T> rotacionDerecha(NodoAVL<T> y) {
        NodoAVL<T> x = y.getIzquierda();
        NodoAVL<T> T2 = x.getDerecha();

        // Realiza la rotación
        x.setDerecha(y);
        y.setIzquierda(T2);

        // Actualiza las alturas de los nodos afectados
        y.actualizarAltura();
        x.actualizarAltura();

        // Retorna la nueva raíz
        return x;
    }

    private NodoAVL<T> rotacionIzquierda(NodoAVL<T> x) {
        NodoAVL<T> y = x.getDerecha();
        NodoAVL<T> T2 = y.getIzquierda();

        // Realiza la rotación
        y.setIzquierda(x);
        x.setDerecha(T2);

        // Actualiza las alturas de los nodos afectados
        x.actualizarAltura();
        y.actualizarAltura();

        // Retorna la nueva raíz
        return y;
    }

    private NodoAVL<T> rotacionDobleIzquierda(NodoAVL<T> x) {
        // Realiza una rotación a la derecha en el hijo derecho del nodo x
        x.setDerecha(rotacionDerecha(x.getDerecha()));
        // Realiza una rotación a la izquierda en el nodo x
        return rotacionIzquierda(x);
    }

    private NodoAVL<T> rotacionDobleDerecha(NodoAVL<T> y) {
        // Realiza una rotación a la izquierda en el hijo izquierdo del nodo y
        y.setIzquierda(rotacionIzquierda(y.getIzquierda()));
        // Realiza una rotación a la derecha en el nodo y
        return rotacionDerecha(y);
    }
    public void balancearArbol() {
        raiz = balancearSubArbol(raiz);
    }

    private NodoAVL<T> balancearSubArbol(NodoAVL<T> nodo) {
        if (nodo == null) {
            return null;
        }

        // Balancea los subárboles izquierdo y derecho
        nodo.setIzquierda(balancearSubArbol(nodo.getIzquierda()));
        nodo.setDerecha(balancearSubArbol(nodo.getDerecha()));

        // Actualiza la altura del nodo actual
        nodo.actualizarAltura();

        // Calcula el factor de balance del nodo actual
        int balance = nodo.obtenerBalance();

        // Casos de rotación para mantener el balance del árbol
        // Caso izquierda-izquierda (LL)
        if (balance > 1 && nodo.getIzquierda().obtenerBalance() >= 0) {
            return rotacionDerecha(nodo);
        }
        // Caso derecha-derecha (RR)
        if (balance < -1 && nodo.getDerecha().obtenerBalance() <= 0) {
            return rotacionIzquierda(nodo);
        }
        // Caso izquierda-derecha (LR)
        if (balance > 1 && nodo.getIzquierda().obtenerBalance() < 0) {
            nodo.setIzquierda(rotacionIzquierda(nodo.getIzquierda()));
            return rotacionDerecha(nodo);
        }
        // Caso derecha-izquierda (RL)
        if (balance < -1 && nodo.getDerecha().obtenerBalance() > 0) {
            nodo.setDerecha(rotacionDerecha(nodo.getDerecha()));
            return rotacionIzquierda(nodo);
        }

        // Si el nodo no requiere rotaciones, simplemente se devuelve el mismo nodo
        return nodo;
    }

    public void insertar(Comparable clave, T dato) {
        raiz = insertarEnArbol(raiz, clave, dato);
        this.balancearArbol();
    }

    private NodoAVL<T> insertarEnArbol(NodoAVL<T> nodo, Comparable clave, T dato) {
        if (nodo == null) {
            return new NodoAVL<>(clave, dato);
        }

        if (clave.equals(nodo.getEtiqueta())) {
            nodo.setDato(dato);
            return nodo;
        }

        if (clave.compareTo(nodo.getEtiqueta()) < 0) {
            nodo.setIzquierda(insertarEnArbol(nodo.getIzquierda(), clave, dato));
        } else {
            nodo.setDerecha(insertarEnArbol(nodo.getDerecha(), clave, dato));
        }

        nodo.actualizarAltura();

        return nodo;
    }
}
