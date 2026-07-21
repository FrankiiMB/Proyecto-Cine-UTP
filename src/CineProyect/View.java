package CineProyect;

public class View {

    public static final String COLOR_NORMAL = "\u001B[0m";
    public static final String COLOR_VERDE = "\u001B[32m";
    public static final String COLOR_AMARILLO = "\u001B[33m";
    public static final String COLOR_CELESTE = "\u001B[36m";
    public static final String COLOR_ROJO = "\u001B[31m";
    public static final String COLOR_AZUL = "\u001B[34m";
    public static final String COLOR_MORADO = "\u001B[35m";
    public static final String NEGRITA = "\u001B[1m";
    public static final String COLOR_AZUL_NEGRITA = COLOR_AZUL + NEGRITA;
    public static final String COLOR_CELESTE_NEGRITA = COLOR_CELESTE + NEGRITA;
    public static final String COLOR_ROJO_NEGRITA = COLOR_ROJO + NEGRITA;

    //By: Frank
    public static void mostrarSala(String[][] array, double precio) {
        //Pantalla
        System.out.println(COLOR_ROJO_NEGRITA + "\n    SPIDER-MAN: UN NUEVO DIA" + COLOR_NORMAL);
        System.out.print("\t" + "Entrada: S/" + precio +"\n");
        System.out.printf("\n%s%20s%s\n", COLOR_CELESTE, "PANTALLA", COLOR_NORMAL);
        System.out.print(COLOR_CELESTE + "   |" + COLOR_NORMAL);
        for (int i = 1; i < 25; i++) {
            System.out.print(COLOR_CELESTE + "_" + COLOR_NORMAL);
        }
        System.out.print(COLOR_CELESTE + "|" + COLOR_NORMAL);
        System.out.println("\n");

        //Asignación de letras a las filas
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                switch (array[i][j]) {
                    case "X":
                        System.out.print(COLOR_ROJO + "[X]" + COLOR_NORMAL); // Rojo = Vendido / Ocupado
                        break;
                    case "C":
                        System.out.print(COLOR_VERDE + "[C]" + COLOR_NORMAL); // Verde = En tu Carrito
                        break;
                    default:
                        System.out.print("[O]"); // Blanco = Libre
                        break;
                }
            }
            char letter = (char) ('G' - i);
            System.out.println(COLOR_AZUL + " " + letter + COLOR_NORMAL);
        }
        //Numero de columnas 10, 09, 08,....
        for (int i = 10; i > 0; i--) {
            System.out.print(COLOR_AZUL + " " + (i >= 10 ? i : "0" + i) + COLOR_NORMAL);
        }

        System.out.println("\n" + COLOR_CELESTE + "  C = En carrito   X = Ocupado" + COLOR_NORMAL);
        System.out.println(COLOR_CELESTE + "            O = Libre" + COLOR_NORMAL);
        
    }

    public static void bienvenida() {
        String welcome = ("""
                        * _______________CINESTAR ______________
                        *|                                      |
                        *|    BIENVENIDO A CINESTAR CHIMBOTE    |
                        *|______________________________________|
                           """);
        System.out.println(welcome.replace("*", COLOR_AZUL_NEGRITA) + COLOR_NORMAL);
    }

    public static void menuPrincipal() {
        String menuPrincipal = ("""
                           
                           * ____________CINESTAR ____________
                           *|                                 |
                           *|    1. Ver Asientos Disponibles  |
                           *|    2. Mi Carrito                |   
                           *|    3. Finalizar Compra          |
                           *|_________________________________|
                           """);
        System.out.println(menuPrincipal.replace("*", COLOR_MORADO) + COLOR_NORMAL);
    }

    public static void subMenuReserva() {
        System.out.println("""
                           
                            __________ CINESTAR _________
                           |                             |
                           |    1. Reservar Asientos     |
                           |    0. Menu Principal        |   
                           |_____________________________|
                           """);
    }

    public static void subMenuEditar() {
        System.out.println("""
                          
                         _________CINESTAR _______
                        |                         |
                        |    1. Borrar Asiento    |
                        |    0. Menu Principal    |
                        |_________________________|
                           """);
    }

    //By: Danilo
    public static void mostrarCarrito(String cliente, String asientos, String pelicula, int asientosReservados, double price, double subTotal) {
        System.out.printf("\nHola, %s!\n", cliente);
        System.out.println("\nRESUMEN DE TU COMPRA");
        System.out.println("_________________________________");
        System.out.print("\n" + pelicula);
        System.out.println("\nAsientos Reservados:");
        System.out.printf("%32s%d\n", "Cant.", asientosReservados);
        System.out.printf("%s\n", asientos);
        System.out.println("---------------------------------");
        System.out.printf("Precio: S/%.2f\n", price);
        System.out.printf("Sub-Total: S/%.2f\n", subTotal);
        System.out.println("_________________________________\n");
    }

    //By: Zeta
    public static void imprimirTicket(String cliente, String asientos, String pelicula, int cantidad, double precio, double total) {
        System.out.println("_____________________________________\n");
        System.out.println("CINESTAR\n");
        System.out.print(pelicula);
        System.out.println("\nCine: Cinestar Chimbote");
        System.out.printf("Cliente: %s\n", cliente);
        System.out.printf("Asientos: \n%s\n", asientos);
        System.out.println("_____________________________________\n");
        System.out.println("Cantidad     Precio        Total");
        System.out.printf("%02d           S/%-10.2f  S/%-9.2f \n", cantidad, precio, total);
        System.out.println("------------------------------------- ");
        System.out.printf("TOTAL A PAGAR: S/%-20.2f \n\n", total);
        System.out.println("Gracias por su compra.\nDisfrute su pelicula :)");
        System.out.println("______________________________________\n");
    }

}
