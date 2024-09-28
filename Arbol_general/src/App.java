
import java.util.List;

public class App {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar(10, 10,10);
        arbol.insertar(12, 12, 10);
        arbol.insertar(13, 13, 10);
        arbol.insertar(14, 14, 10);
        arbol.insertar(8, 8,14);
        arbol.insertar(7, 7,12);
        arbol.insertar(6, 6, 12);
        arbol.insertar(5, 5, 13);
        arbol.insertar(4, 4, 8);
        // arbol.buscar(8);
        
        // System.out.println(arbol.buscar(8));
        arbol.eliminar(10);
    }
}
