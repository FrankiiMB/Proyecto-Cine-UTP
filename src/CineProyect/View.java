package CineProyect;
import java.util.Scanner;
public class View {
    private char word;

    public void asientos(String[][] array) {
        word = 'G';
        System.out.printf("\n%20s\n", "PANTALLA");
        System.out.print("   |");
        for (int i = 1; i < 25; i++) System.out.print("_");
        System.out.print("|");
        System.out.println("\n");
        
        //Impresion de asientos vacios y asignación de letras a las columnas
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(array[i][j] + "  ");
            }
            word = (char) ('G' - i);
            System.out.println(word);
        }
        //Numero de columna
        for (int i = 10; i > 0; i--) {
            System.out.print((i >= 10 ? i : "0" + i) + " ");
        }
        System.out.println("\nX = Seleccionada    O = Libre");
    }

    public void welcome() {
        System.out.println("""
                           _______________CINESTAR ______________
                          |                                      |
                          |    BIENVENIDO A CINESTAR CHIMBOTE    |
                          |______________________________________|
                           """);
    }

    public void menuPrincipal() {
        System.out.println("""
                           
                            ____________CINESTAR ____________
                           |                                 |
                           |    1. Ver Asientos Disponibles  |
                           |    2. Mi Carrito                |   
                           |    3. Finalizar Compra          |
                           |_________________________________|
                           """);
    }

    public void menuReserva() {
        System.out.println("""
                           
                            __________ CINESTAR _________
                           |                             |
                           |    1. Reservar Asientos     |
                           |    0. Menu Principal        |   
                           |_____________________________|
                           """);
    }
    
    public void menu3(){
        System.out.println("""
                           
                            _______________ CINESTAR _____________
                           |                                      |
                           |    1. Continuar Reservando           |
                           |    2. Editar Selección               |
                           |    0. Menu Principal                 |   
                           |______________________________________|
                           """);
    }

    public void enter(Scanner sc) {
        String entrada;
        do {
            System.out.print("Presione ENTER para continuar... ");
            entrada = sc.nextLine();
        } while (entrada.length() > 0);
    }

    public void carrito(String cliente){
        System.out.printf("\nHola, %s!\n", cliente);
        System.out.println("\nRESUMEN DE TU COMPRA");
        System.out.println("_______________________________");
        System.out.println("\nAsientos Reservados" );
        System.out.println("A01, A02                Cant.2 ");
        System.out.println("-------------------------------");
        System.out.println("Precio: S/15");
        System.out.println("Sub-Total: S/");
        System.out.println("_______________________________\n");
    }
    
    public void ticket(){
        System.out.println(" _______________________________________ ");
        System.out.println("|                                       |");
        System.out.println("| CINESTAR                              |");
        System.out.println("|                                       |");
        System.out.println("| Cine: Cinestar Chimbote               |");
        System.out.println("| Cliente:                              |");
        System.out.println("| Asientos: A01, A02                    |");
        System.out.println("| _____________________________________ |");
        System.out.println("|                                       |");
        System.out.println("| Cantidad     Precio        Total      |");
        System.out.println("| 02           S/15          S/30       |");
        System.out.println("| ------------------------------------- |");
        System.out.println("| TOTAL A PAGAR: S/30                   |");
        System.out.println("|                                       |");
        System.out.println("| Gracias por su compra :)              |");
        System.out.println("|_______________________________________|");
        System.out.println();
    }
}
