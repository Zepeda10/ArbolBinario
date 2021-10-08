package ArbolBinario;

public class Arbol {
    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public synchronized void insertarNodo(int numero) {
        if (raiz == null) {
            raiz = new Nodo(numero); 
        } else {
            raiz.insertar(numero); 
        }

    }


    public synchronized void preorden() {
        auxPreorden(raiz);
    }

    private void auxPreorden(Nodo nodo) {
        if (nodo == null)
            return;

        System.out.print(nodo.datos + " "); 
        auxPreorden(nodo.izq); 
        auxPreorden(nodo.der); 
    }


    public synchronized void inorden() {
        auxInorden(raiz);
    }


    private void auxInorden(Nodo nodo) {
        if (nodo == null)
            return;

            auxInorden(nodo.izq);
        System.out.print(nodo.datos + " ");
        auxInorden(nodo.der);
    }


    public synchronized void posorden() {
        auxPosorden(raiz);
    }

    private void auxPosorden(Nodo nodo) {
        if (nodo == null)
            return;

            auxPosorden(nodo.izq);
            auxPosorden(nodo.der);
        System.out.print(nodo.datos + " ");
    }
}
