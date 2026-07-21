package CineProyect;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Control {


    //By: Edwin Jaramillo
    public static String leerNombre(Scanner in, String msg) {
        String nombre;
        while (true) {
            System.out.println("A continuacion, ingrese su nombre...");
            nombre = in.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println(View.COLOR_ROJO_NEGRITA + "Error: No puede dejar este campo vacio..." + View.COLOR_NORMAL);
            } else if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                System.out.println(View.COLOR_ROJO_NEGRITA + "Solo se permite el ingreso de letras..." + View.COLOR_NORMAL);
            } else {
                String[] palabras = nombre.toLowerCase().split(" ");
                String nombreFormateado = "";
                for (String palabra : palabras) {
                    nombreFormateado += palabra.substring(0, 1).toUpperCase() + palabra.substring(1) + " ";
                }
                // Si en caso el usuario desea cambiar o se equivoca colocando su nombre 
                nombreFormateado = nombreFormateado.trim();
                System.out.println("\nNombre ingresado: " + nombreFormateado);
                int opcion = 0;
                do {
                    System.out.println("\n1. Confirmar");
                    System.out.println("0. Escribir nombre nuevamente");

                    System.out.print("\n" + msg);
                    opcion = validarNumero(in, msg);
                    if (opcion < 0 || opcion > 1) {
                        System.out.print(View.COLOR_ROJO_NEGRITA + "Por favor, ingrese una opcion valida." + View.COLOR_NORMAL);
                    }
                } while (opcion < 0 || opcion > 1);
                if (opcion == 1) {
                    return nombreFormateado;
                }
            }
        }
    }

    //By: Frank
    
    public static void enter(Scanner sc) {
        String entrada;
        do {
            System.out.print("\nPresione ENTER para continuar... ");
            entrada = sc.nextLine();
        } while (entrada.length() > 0);
    }

    //By: Estrella
    
    public static int validarNumero(Scanner in, String msg) {
        int numero = -1;
        boolean esValido = false;

        while (!esValido) {
            try {
                numero = in.nextInt();
                in.nextLine();
                esValido = true;
            } catch (InputMismatchException e) {
                System.out.println(View.COLOR_ROJO_NEGRITA + "Error. Ingrese solo numeros!!" + View.COLOR_NORMAL);
                in.nextLine();
                System.out.print(msg);
            }
        }
        return numero;
    }
    
    //By: Frank
    
    public static int convertirFila(String fila) {
        if (fila == null || fila.trim().length() != 1) {
            return 999; 
        }
    
        char letra = fila.trim().toUpperCase().charAt(0);
        if (letra >= 'A' && letra <= 'G') {
            return 'G' - letra; 
        }
        return 999; 
    }
    
    //By: Owen && Frank
    
    public static int[] elegirAsiento(Scanner in, Sala sala) {
        String fila = "";
        int filaConvertida;
        do {
            System.out.print("Ingrese indice de fila (A-G): ");
            fila = in.next();
            filaConvertida = convertirFila(fila);
            if (filaConvertida == 999) {
                System.out.println(View.COLOR_ROJO_NEGRITA + "Error!! Debe ser entre A y G." + View.COLOR_NORMAL);
            }
        } while (filaConvertida == 999);

        int columna;
        do {
            String msgColumna = "Ingrese indice de columna (1-" + sala.getColumnas() + "): ";
            System.out.print(msgColumna);
            columna = validarNumero(in, msgColumna);
            if (columna < 1 || columna > 10) {
                System.out.println(View.COLOR_ROJO_NEGRITA + "Columna invalida. Intente de nuevo..." + View.COLOR_NORMAL);
            }
        } while (columna < 1 || columna > 10);

        int columnaConvertida = sala.getColumnas() - columna;

        return new int[]{filaConvertida, columnaConvertida};
    }

    public static int getAsientosLibres(Sala sala) {
        int libres = 0;
        String[][] asientos = sala.getAsientos();
        for (int i = 0; i < sala.getFilas(); i++) {
            for (int j = 0; j < sala.getColumnas(); j++) {
                if (asientos[i][j].equals("O")) {
                    libres++;
                }
            }
        }
        return libres;
    }

    //By: Owen && Frank
    
    public static void reservarAsiento(Scanner in, Sala sala) {

        int asientosLibres = getAsientosLibres(sala);

        int cantidadAsientos = 0;
        do {
            String msgAsientos = "Cuantos asientos desea reservar?: ";
            System.out.print(msgAsientos);
            cantidadAsientos = validarNumero(in, msgAsientos);

            if (cantidadAsientos < 0) {
                System.out.println(View.COLOR_ROJO_NEGRITA + "Error!! Ingrese un valor positivo..." + View.COLOR_NORMAL);
            }
            if (cantidadAsientos > asientosLibres) {
                System.out.println(View.COLOR_AZUL + "Cantidad de asientos no disponible..." + View.COLOR_NORMAL);
            }
        } while (cantidadAsientos < 0 || cantidadAsientos > asientosLibres);

        View.mostrarSala(sala.getAsientos(), sala.getPrice());
        int contadorAsientos = 0;

        while (contadorAsientos < cantidadAsientos) {
            System.out.println("\n--- Reservando asiento " + (contadorAsientos + 1) + " de " + cantidadAsientos + " ---");

            int[] indices = elegirAsiento(in, sala);
            int filaConvertida = indices[0];
            int columnaConvertida = indices[1];

            switch (sala.getAsientos()[filaConvertida][columnaConvertida]) {
                case "X":
                    System.out.println(View.COLOR_AZUL + "Asiento Ocupado! Por favor, elija otro." + View.COLOR_NORMAL);
                    break;
                case "C":
                    System.out.println(View.COLOR_AZUL + "Ya tienes este asiento en tu carrito..." + View.COLOR_NORMAL);
                    break;
                default:
                    sala.getAsientos()[filaConvertida][columnaConvertida] = "C";
                    contadorAsientos++;
                    System.out.println(View.COLOR_VERDE + "Asiento agregado al carrito con exito!" + View.COLOR_NORMAL);
                    break;
            }
        }
    }
    
    public static void finalizarCompra(Sala sala) {
        String[][] asientos = sala.getAsientos();

        //Convertimos los asientos del carrito a ocupados
        for (int i = 0; i < sala.getFilas(); i++) {
            for (int j = 0; j < sala.getColumnas(); j++) {
                if (asientos[i][j].equals("C")) {
                    asientos[i][j] = "X";
                }
            }
        }
        GestorBaseDatos.guardarDatos(sala);
    }

    //By: Frank
    
    public static void borrarAsiento(Scanner in, Sala sala) {

        int[] indices = elegirAsiento(in, sala);
        int filaConvertida = indices[0];
        int columnaConvertida = indices[1];
        
        if (!sala.getAsientos()[filaConvertida][columnaConvertida].equals("C")) {
            System.out.println(View.COLOR_CELESTE + "Este asiento no esta en tu carrito!!" + View.COLOR_NORMAL);
        } else {
            sala.getAsientos()[filaConvertida][columnaConvertida] = "O";
            System.out.println(View.COLOR_VERDE + "Asiento quitado del carrito con exito!!" + View.COLOR_NORMAL);
        }
    }

}
