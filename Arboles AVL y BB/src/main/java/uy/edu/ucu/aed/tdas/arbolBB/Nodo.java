package uy.edu.ucu.aed.tdas.arbolBB;


import java.util.LinkedList;

public class Nodo implements IElementoAB {

    private Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;
    private int datos;

    public Nodo(Comparable etiqueta, int datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public IElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public IElementoAB getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(IElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(IElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public IElementoAB buscar(Comparable unaEtiqueta) {
        if(this.getEtiqueta().compareTo(unaEtiqueta)==0){
            return this;
        }
        else if(unaEtiqueta.compareTo(this.getEtiqueta())<0){
            if(this.getHijoIzq()!=null){
                return this.getHijoIzq().buscar(unaEtiqueta);
            }
        }
        else if(unaEtiqueta.compareTo(this.getEtiqueta())>0){
            if(this.getHijoDer()!=null){
                return this.getHijoDer().buscar(unaEtiqueta);
            }
        }
        return null;
    }

    @Override
    public boolean insertar(IElementoAB elemento) {
        if(elemento.getEtiqueta().compareTo(this.getEtiqueta())<0){
            if(this.getHijoIzq()==null){
                this.setHijoIzq(elemento);
                return true;
            }
            else{
                return this.getHijoIzq().insertar(elemento);
            }
        }
        else if(elemento.getEtiqueta().compareTo(this.getEtiqueta())>0){
            if(this.getHijoDer()==null){
                this.setHijoDer(elemento);
                return true;
            }
            else{
                return this.getHijoDer().insertar(elemento);
            }
        }
            return false;       
    }

    @Override
    public void preOrden(LinkedList unaLista) {
        unaLista.add(this.getEtiqueta());
        if(this.getHijoIzq()!=null){
            this.getHijoIzq().preOrden(unaLista);
        }
        if(this.getHijoDer()!=null){
            this.getHijoDer().preOrden(unaLista);
        }
    }

    @Override
    public void inOrden(LinkedList unaLista) {
        if(this.getHijoIzq()!=null){
            this.getHijoIzq().preOrden(unaLista);
        }
        unaLista.add(this.getEtiqueta());
        if(this.getHijoDer()!=null){
            this.getHijoDer().preOrden(unaLista);
        }
    }

    @Override
    public void postOrden(LinkedList unaLista) {
        if(this.getHijoIzq()!=null){
            this.getHijoIzq().preOrden(unaLista);
        }
        if(this.getHijoDer()!=null){
            this.getHijoDer().preOrden(unaLista);
        }
        unaLista.add(this.getEtiqueta());
    }

    @Override
    public Integer getDatos() {
        return this.datos;
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(this.getEtiqueta())<0){
            if(this.getHijoIzq()!=null){
                this.setHijoIzq(this.getHijoIzq().eliminar(unaEtiqueta));
            }
        }
        else if(unaEtiqueta.compareTo(this.getEtiqueta())>0){
            if(this.getHijoDer()!=null){
                this.setHijoDer(this.getHijoDer().eliminar(unaEtiqueta));
            }
        }
        else{
            if(this.getHijoIzq()==null && this.getHijoDer()==null){
                return null;
            }
            else if(this.getHijoIzq()==null){
                return this.getHijoDer();
            }
            else if(this.getHijoDer()==null){
                return this.getHijoIzq();
            }
            else{
                IElementoAB elHijo = this.getHijoIzq();
                IElementoAB elPadre = this;
                while(elHijo.getHijoDer()!=null){
                    elPadre = elHijo;
                    elHijo = elHijo.getHijoDer();
                }
                if(elPadre!=this){
                    elPadre.setHijoDer(elHijo.getHijoIzq());
                    elHijo.setHijoIzq(this.getHijoIzq());
                }
                elHijo.setHijoDer(this.getHijoDer());
                return elHijo;
            }
        }
        return this;
    }

    @Override
    public int obtenerTamaño() {
        int tamaño = 1;
        if(this.getHijoIzq()!=null){
            tamaño += this.getHijoIzq().obtenerTamaño();
        }
        if(this.getHijoDer()!=null){
            tamaño += this.getHijoDer().obtenerTamaño();
        }
        return tamaño;
    }

   @Override   
    public int altura(){
        int alturaIzq = -1;
        int alturaDer = -1;
        if(this.getHijoIzq()!=null){
            alturaIzq = this.getHijoIzq().altura();
        }
        if(this.getHijoDer()!=null){
            alturaDer = this.getHijoDer().altura();
        }
        if(alturaIzq>alturaDer){
            return alturaIzq+1;
        }
        else{
            return alturaDer+1;
        }
    }
    
}
