package CineProyect;
import java.util.Scanner;
public class CineMain {
    public static void main (String args []){
        //chek = valor logico para seguir o salir del menu principal
        boolean check = true;
        int fila, columna, option;
        Scanner in = new Scanner(System.in);
        //creacion de los obejtos de cada clase
        Sala sala = new Sala();
        View ver = new View();
        Control effect = new Control();
        //primer menu de inicio
        ver.welcome();
        System.out.println("A continuacion, ingrese su nombre...");
        System.out.print("Hola, ");
        String name = in.next();
        in.nextLine();

        while(check){
            //escoger = valor logico para seguir o salir del menu de reserva
            boolean escoger = true;
            ver.menuPrincipal();
            System.out.print("Ingrese opcion: ");
            option = in.nextInt();
            in.nextLine();
            switch(option){
                case 1: 
                    /*enviamos la matriz de asientos vacios para
                    posterior asignacion de columnas, filas, leyenda*/
                    ver.asientos(sala.getAsientos());
                    System.out.println();
                    //enter = efecto especial para dar enter antes de seguir
                    effect.enter(in);
                    do{
                        //mostrar menu de reserva
                        ver.menuReserva();
                        System.out.print("Ingrese opcion: ");
                        option = in.nextInt();
                        switch(option){
                            case 0: System.out.println(); break;
                            case 1:
                                ver.asientos(sala.getAsientos());
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
                                        effect.enter(in);
                                        in.nextLine();
                                    }
                                }
                                break;
                            default: System.out.println("Por favor, ingrese una opcion valida..."); break;
                        }
                    }while(option>1 || option <0);
                    break;
                case 2:
                    int totalReserva = sala.getTotalReservados();
                    double precio = sala.getPrice();
                    double subTotal = sala.getSubTotal();
                    if(totalReserva!=0){
                        ver.carrito(name, totalReserva, precio, subTotal);
                        effect.enter(in);
                    }else{
                        System.out.println("Su carrito esta vacio. Realice una reserva :)");
                        effect.enter(in);
                    }
                    break;
                case 3:
                    check = false;
                    ver.ticket();
                    break;
                default: 
                    System.out.println("Por favor, ingrese una opcion valida..."); break;
            }
        }
    }
}
