
import java.util.LinkedList;

public class Nodo implements IElementoAB {

    private Comparable etiqueta;
    private IElementoAB primerHijo;
    private IElementoAB siguienteHermano;
    private int datos;

    public Nodo(Comparable etiqueta, int datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
        this.primerHijo = null;
        this.siguienteHermano = null;
    }

    

    @Override
    public IElementoAB buscar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(this.getEtiqueta())==0){
            return this;
        }
        else{
            if(this.getPrimerHijo()!=null){
                IElementoAB aux = this.getPrimerHijo().buscar(unaEtiqueta);
                if(aux!=null){
                    return aux;
                }
            }
            if(this.getSiguienteHermano()!=null){
                return this.getSiguienteHermano().buscar(unaEtiqueta);
            }
            return null;
        }
    }

    @Override
    public boolean insertar(IElementoAB elemento, Comparable etiqueta) {
        if(etiqueta.compareTo(this.etiqueta)==0){
            if(this.getPrimerHijo()==null){
                this.setPrimerHijo(elemento);
                return true;
            }
            else{
                IElementoAB aux = this.getPrimerHijo();
                while(aux.getSiguienteHermano()!=null){
                    aux = aux.getSiguienteHermano();
                }
                aux.setSiguienteHermano(elemento);
                return true;
            }
        }
        else{
            if(this.getPrimerHijo()!=null){
                if(this.getPrimerHijo().insertar(elemento, etiqueta)){
                    return true;
                }
            }
            if(this.getSiguienteHermano()!=null){
                return this.getSiguienteHermano().insertar(elemento, etiqueta);
            }
            return false;
        }
    }

    public boolean insertarSimplificado(IElementoAB elemento, Comparable etiqueta) {
        IElementoAB aux= this.buscar(etiqueta);
        if(aux!=null){
            if(aux.getPrimerHijo()==null){
                aux.setPrimerHijo(elemento);
                return true;
            }
            else{
                IElementoAB aux2 = aux.getPrimerHijo();
                while(aux2.getSiguienteHermano()!=null){
                    aux2 = aux2.getSiguienteHermano();
                }
                aux2.setSiguienteHermano(elemento);
                return true;
            }
        }
        return false;
    }
   
    //imprime la raiz, luego el primer hijo luego los hijos de este y asi sucesivamente
    @Override
    public void preOrden(LinkedList unaLista) {
        unaLista.add(this.getDatos());
        if(this.getPrimerHijo()!=null){
            this.getPrimerHijo().preOrden(unaLista);
        }
        if(this.getSiguienteHermano()!=null){
            this.getSiguienteHermano().preOrden(unaLista);
        }
    }

    //imprime primero el primer hijo, luego los hermanos luego la raiz
    @Override
    public void inOrden(LinkedList unaLista) {
        if(this.getPrimerHijo()!=null){
            this.getPrimerHijo().inOrden(unaLista);
        }
        unaLista.add(this.getDatos());
        if(this.getSiguienteHermano()!=null){
            this.getSiguienteHermano().inOrden(unaLista);
        }
    }
    //imprimer primero el ultimo de los hijos, luego los hermanos y finalmente despues de recorrer todos los hijos, la raiz
    @Override
    public void postOrden(LinkedList unaLista) {
        if(this.getPrimerHijo()!=null){
            this.getPrimerHijo().postOrden(unaLista);
        }
        if(this.getSiguienteHermano()!=null){
            this.getSiguienteHermano().postOrden(unaLista);
        }
        unaLista.add(this.getDatos());
    }

    @Override
    public Integer getDatos() {
        return this.datos;
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
       IElementoAB aux = this.buscarPadre(unaEtiqueta);
       if(aux!=null){
        if(aux.getPrimerHijo().getEtiqueta().compareTo(unaEtiqueta)==0){
            if(aux.getPrimerHijo().getSiguienteHermano()!=null){
            IElementoAB aux2=aux.getPrimerHijo().getSiguienteHermano();
            IElementoAB eliminado= aux.getPrimerHijo();
            aux.setPrimerHijo(aux2);
            return eliminado;
        }
        else{
            IElementoAB eliminado= aux.getPrimerHijo();
            aux.setPrimerHijo(null);
            return eliminado;
       }
        }
        else{
            if(aux.getSiguienteHermano().getEtiqueta().compareTo(unaEtiqueta)==0){
                if(aux.getSiguienteHermano().getSiguienteHermano()!=null){
                    IElementoAB aux2=aux.getSiguienteHermano().getSiguienteHermano();
                    IElementoAB eliminado= aux.getSiguienteHermano();
                    aux.setSiguienteHermano(aux2);
                    return eliminado;
                }
                else{
                    IElementoAB eliminado= aux.getSiguienteHermano();
                    aux.setSiguienteHermano(null);
                    return eliminado;
               }
            }
       }
    }
        return null;
    }
    public IElementoAB buscarPadre(Comparable unaEtiqueta) {
        if(this.getPrimerHijo()!=null){
            if(this.getPrimerHijo().getEtiqueta().compareTo(unaEtiqueta)==0){
                return this;
            }
            else{
                IElementoAB aux = this.getPrimerHijo().buscarPadre(unaEtiqueta);
                if(aux!=null){
                    return aux;
                }
            }
        }
        if(this.getSiguienteHermano()!=null){
            if(this.getSiguienteHermano().getEtiqueta().compareTo(unaEtiqueta)==0){
                return this;
            }
            else{
                return this.getSiguienteHermano().buscarPadre(unaEtiqueta);
            }
        }
        return null;
    }


    @Override
    public int obtenerTamaño() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override   
    public int altura(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }



public Comparable getEtiqueta() {
    return etiqueta;
}



public void setEtiqueta(Comparable etiqueta) {
    this.etiqueta = etiqueta;
}



public IElementoAB getPrimerHijo() {
    return primerHijo;
}



public void setPrimerHijo(IElementoAB primerHijo) {
    this.primerHijo = primerHijo;
}



public IElementoAB getSiguienteHermano() {
    return siguienteHermano;
}



public void setSiguienteHermano(IElementoAB siguienteHermano) {
    this.siguienteHermano = siguienteHermano;
}



public void setDatos(int datos) {
    this.datos = datos;
}
    
}
