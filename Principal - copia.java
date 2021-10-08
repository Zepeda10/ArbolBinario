package ArbolBinario;

import java.util.Scanner;
import java.util.Arrays;

public class Principal {
    public static Arbol arbol = new Arbol();
    public static Scanner en = new Scanner(System.in);

    public static void ingresar() {
        boolean bandera3 = false;

        while(!bandera3){
            try {
                System.out.println("\nInserte cifra: ");
                String num = en.next();

                if (num.length() >= 6) {

                    int ar[] = new int[num.length()];
                    int number = Integer.parseInt(num);
                    int[] digitos = new int[num.length()];
                    int i = digitos.length - 1;

                    while (number > 0) {
                        digitos[i] = number % 10;
                        number = number / 10;
                        i--;
                    }

                    for (int j = 0; j < digitos.length; j++) {
                        ar[j] = digitos[j];
                    }

                    Arrays.sort(ar);
                    int contador = 0;
                    int aux = ar[0];
                    boolean bandera1 = false;
                    boolean bandera2 = false;

                    for (int k = 0; k < ar.length; k++) {
                        if (aux == ar[k]) {
                            contador++;
                        } else {
                            if (contador > 1) {
                                bandera1 = true;
                            }
                            contador = 1;
                            aux = ar[k];
                        }
                    }

                    if (contador > 1) {
                        bandera2 = true;
                    }

                    if (bandera1 || bandera2) {
                        System.out.println("No debe de haber números repetidos");
                    } else {
                        bandera3 = true;
                        for (int j = 0; j < digitos.length; j++) {
                            arbol.insertarNodo(digitos[j]);
                        }

                    }

                } else {
                    System.out.println("Debes ingresar mínimo 6 digitos");
                }

            } catch (NumberFormatException ex) {
                System.out.println("Solo puedes ingresar números");
            }
        }
    }

    public static void visualizar() {
        System.out.println("\n\nRecorrido preorden");
        arbol.preorden();

        System.out.println("\n\nRecorrido inorden");
        arbol.inorden();

        System.out.println("\n\nRecorrido posorden");
        arbol.posorden();
    }

    public static void main(String args[]) {
        int opc;

        do{
            System.out.println("\nIngrese opción que desea realizar:");
            System.out.println("1) Ingresar\n2) Visualizar\n3) Salir");
            opc = en.nextInt();

            switch(opc){
                case 1:
                    ingresar();
                    break;
                case 2:
                    visualizar();
                    break;
                case 3:
                    System.out.println("\nAdiós.");
                    break;
                default:
                    System.out.println("\nOpción errónea");
                    break;

            }
        }while(opc != 3);
      

    }
}
