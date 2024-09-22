
import java.util.List;

import uy.edu.ucu.aed.tdas.arbolBB.*;

import uy.edu.ucu.aed.tdas.arbolAVL.*;


public class main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar("T", "T");
        arbol.insertar("P", "P");
        arbol.insertar("Y", "Y");
        arbol.insertar("L", "L");
        arbol.insertar("S", "S");
        arbol.insertar("U", "U");
        arbol.insertar("Z", "Z");
        arbol.insertar("X", "X");
        arbol.insertar("K", "K");
        arbol.insertar("N", "N");

        System.out.println(arbol.buscar("U"));
        System.out.println(arbol.altura());
        // arbol.eliminar("P");
        // List a= arbol.preOrden();
        // for(int i=0;i<a.size();i++){
        //     System.out.println(a.get(i));
        // }   
        ArbolAVL<Integer> arbolAVL = new ArbolAVL<>();
        arbolAVL.insertar(20, 20);
        arbolAVL.insertar(10, 10);
        arbolAVL.insertar(15, 15);
        arbolAVL.insertar(5, 5);
        arbolAVL.insertar(40, 40);
        arbolAVL.insertar(30, 30);
        arbolAVL.insertar(25, 25);
        arbolAVL.insertar(35, 35);
        arbolAVL.insertar(45, 45);
        arbolAVL.insertar(50, 50);
        arbolAVL.insertar(60,60);
        // arbolAVL.buscar(20);
        arbolAVL.eliminar(15);
         arbolAVL.eliminar(45);
         arbolAVL.eliminar(40);
         arbolAVL.imprimir();
    }
}
