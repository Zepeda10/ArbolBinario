package ArbolBinario;

public class Nodo {
    Nodo izq;
    int datos;
    Nodo der;


    public Nodo(int numeros) {
        datos = numeros;
        izq = der = null; 
    }

    public synchronized void insertar(int numero) {
        if (numero < datos) {

            if (izq == null)
            izq = new Nodo(numero);
            else 
            izq.insertar(numero);
        }

        else if (numero > datos) {

            if (der == null)
            der = new Nodo(numero);
            else 
            der.insertar(numero);
        }
    }
}
