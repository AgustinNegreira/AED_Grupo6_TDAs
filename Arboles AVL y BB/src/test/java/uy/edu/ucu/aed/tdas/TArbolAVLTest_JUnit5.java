package uy.edu.ucu.aed.tdas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uy.edu.ucu.aed.tdas.arbolAVL.*;

import static org.junit.jupiter.api.Assertions.*;

class TArbolAVLTest_JUnit5 {

    private ArbolAVL arbolAVL;

    @BeforeEach
    public void setUp() {
        arbolAVL = new ArbolAVL<>();
    }

    @Test
    public void testInicializacion() {
        assertTrue(arbolAVL.esVacio());
    }

    @Test
    public void testInsertar() {
        arbolAVL.insertar(10, 10);
        assertFalse(arbolAVL.esVacio());
        assertEquals(10, arbolAVL.getRaiz().getDato());
    }

    @Test
    public void testInsertarYBalancear() {
        arbolAVL.insertar(10, 10);
        arbolAVL.insertar(20, 20);
        arbolAVL.insertar(30, 30); // This should cause a rotation
        assertEquals(20, arbolAVL.getRaiz().getDato());
        assertEquals(10, arbolAVL.getRaiz().getIzquierda().getDato());
        assertEquals(30, arbolAVL.getRaiz().getDerecha().getDato());
    }

    @Test
    public void testEliminar() {
        arbolAVL.insertar(10, 10);
        arbolAVL.insertar(20, 20);
        arbolAVL.insertar(30, 30);
        arbolAVL.eliminar(20);
        assertNull(arbolAVL.buscar(20));
        assertEquals(1, arbolAVL.getRaiz().obtenerBalance());
    }

    @Test
    public void testBuscar() {
        arbolAVL.insertar(10, 10);
        arbolAVL.insertar(20, 20);
        arbolAVL.insertar(30, 30);
        assertEquals(20, arbolAVL.buscar(20));
        assertNull(arbolAVL.buscar(40));
    }

    @Test
    public void testEsVacio() {
        assertTrue(arbolAVL.esVacio());
        arbolAVL.insertar(10, 10);
        assertFalse(arbolAVL.esVacio());
    }

    @Test
    public void testImprimir() {
        arbolAVL.insertar(10, 10);
        arbolAVL.insertar(20, 20);
        arbolAVL.insertar(30, 30);
        arbolAVL.insertar(5, 5);
        arbolAVL.insertar(15, 15);
        arbolAVL.insertar(25, 25);
        arbolAVL.insertar(35, 35);
        // Expected in-order traversal: 5 10 15 20 25 30 35
        arbolAVL.imprimir(); // This should print the values in order
    }
}