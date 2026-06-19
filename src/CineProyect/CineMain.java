package CineProyect;
import java.util.Scanner;
public class CineMain {
    public static void main (String args []){
        boolean check = true;
        int fila, columna, option;
        Scanner in = new Scanner(System.in);
        
        Sala sala = new Sala();
        View vista = new View();

        vista.welcome();
        System.out.println("A continuacion, ingrese su nombre...");
        System.out.print("Hola, ");
        String name = in.next();
        in.nextLine();

        while(check){
            boolean escoger = true;
            vista.menuPrincipal();
            System.out.print("Ingrese opcion: ");
            option = in.nextInt();
            in.nextLine();
            switch(option){
                case 1: 
                    vista.asientos(sala.getAsientos());
                    System.out.println();
                    vista.enter(in);
                    do{
                        vista.menuReserva();
                        System.out.print("Ingrese opcion: ");
                        option = in.nextInt();
                        switch(option){
                            case 0: System.out.println(); break;
                            case 1:
                                vista.asientos(sala.getAsientos());
                                System.out.println("\tEntrada: S/15\n");
                                while(escoger){
                                    do{
                                        System.out.print("Ingrese numero de fila: ");
                                        fila = in.nextInt();
                                        if(fila<0 || fila>6)System.out.println("Dato Invalido");
                                    }while(fila<0 || fila>6);
                                    do{
                                        System.out.print("Ingrese numero de columna: ");
                                        columna = in.nextInt();
                                        if(columna<0 || columna>9)System.out.println("Dato Invalido");
                                    }while((columna<0 || columna>9));
                                    if (sala.getAsientos()[fila][columna].equals("X")){
                                        System.out.println("Asiento Ocupado!!");
                                    }else{
                                        sala.getAsientos()[fila][columna] = "X";
                                        escoger = false;
                                        System.out.println("");
                                        vista.enter(in);
                                        in.nextLine();
                                    }
                                }
                                break;
                            default: System.out.println("Por favor, ingrese una opcion valida..."); break;
                        }
                    }while(option>1 || option <0);
                    break;
                case 2:
                    vista.carrito(name);
                    vista.enter(in);
                    break;
                case 3:
                    check = false;
                    vista.ticket();
                    break;
                default: 
                    System.out.println("Por favor, ingrese una opcion valida..."); break;
            }
        }
    }
}
