import java.util.LinkedList;
import java.util.List;

public class Arbol implements IArbolBB{

    private IElementoAB raiz;

    public Arbol() {
        this.raiz = null;
    }

    @Override
    public boolean insertar(Comparable etiqueta, Object unDato, Comparable etiquetaPadre) {
        if(this.raiz==null){
            this.raiz = new Nodo(etiqueta, (Integer)unDato);
            return true;
        }
        return this.raiz.insertar(new Nodo(etiqueta, (Integer)unDato),etiquetaPadre);
    }

    @Override
    public Integer buscar(Comparable unaEtiqueta) {
        if(esVacio()){
            return null;
        }
        IElementoAB resultado= this.raiz.buscar(unaEtiqueta); 
        if(resultado==null){
            return null;
        }
        return (Integer)resultado.getDatos();
        
    }
    
    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if(this.esVacio()){
            return ;
        }
        if(this.raiz.getEtiqueta().compareTo(unaEtiqueta)==0){
            this.raiz=null;
            return;
        }
        this.raiz.eliminar(unaEtiqueta);
    }

    @Override
    public List preOrden() {
        LinkedList lista = new LinkedList();
        if(this.raiz!=null){
            this.raiz.preOrden(lista);
        }
        if(lista.isEmpty()){
            return null;
        }
        return lista;
    }

    @Override
    public List inOrden() {
        LinkedList lista = new LinkedList();
        if(this.raiz!=null){
            this.raiz.inOrden(lista);
        }
        if(lista.isEmpty()){
            return null;
        }
        return lista;
    }

    @Override
    public List postOrden() {
        LinkedList lista = new LinkedList();
        if(this.raiz!=null){
            this.raiz.postOrden(lista);
        }
        if(lista.isEmpty()){
            return null;
        }
        return lista;
    }

    @Override
    public boolean esVacio() {
        if(this.raiz==null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean vaciar() {
        if(this.raiz==null){
            return false;
        }
        else{
            this.raiz=null;
            return true;
        }
    }
    public int altura(){
        if(this.raiz==null){
            return 0;
        }
        else{
            return this.raiz.altura();
        }
    }
    
}
