import uy.edu.ucu.aed.tdas.TArbolTrie;

public class main {
    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        trie.insertar("holanda");
        trie.insertar("hola");
         trie.insertar("holas");

        trie.imprimir();
        System.out.println(trie.predecir("hola"));
        
    }
    
}
