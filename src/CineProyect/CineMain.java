package CineProyect;

import java.util.Scanner;

public class CineMain {

    public static void main(String args[]) {
        //chek = valor logico para seguir o salir del menu principal
        boolean check = true;
        int option;
        String msgOpcion = "Ingrese opcion: ";
        Scanner in = new Scanner(System.in);
        //Creacion de una sala
        Sala sala = new Sala(7, 10, "Spider-Man: Un nuevo Dia", 15.0);
        GestorBaseDatos.cargarDatos(sala);
        //primer menu de inicio
        View.bienvenida();
        String name = Control.leerNombre(in, msgOpcion);
        System.out.println("\nHola, " + name);
        //By: Frank
        while (check) {
            View.menuPrincipal();
            System.out.print(msgOpcion);
            option = Control.validarNumero(in, msgOpcion);
            switch (option) {
                case 1:
                    /*enviamos la matriz de asientos vacios para
                    posterior asignacion de columnas, filas, leyenda*/
                    View.mostrarSala(sala.getAsientos(),sala.getPrice());
                    //enter = efecto especial para dar enter antes de seguir
                    Control.enter(in);
                    do {
                        //mostrar menu de reserva
                        View.subMenuReserva();
                        System.out.print(msgOpcion);
                        option = Control.validarNumero(in, msgOpcion);
                        switch (option) {
                            case 0:
                                System.out.println();
                                break;
                            //By: Owen && Frank
                            case 1:
                                Control.reservarAsiento(in, sala);
                                Control.enter(in);
                                break;
                            default:
                                System.out.println("Por favor, ingrese una opcion valida...");
                                break;
                        }
                    } while (option > 1 || option < 0);
                    break;
                //By: Danilo - Carrito
                case 2:
                    do{
                        int totalReserva = sala.getTotalReservados();
                        double precio = sala.getPrice();
                        double subTotal = sala.getSubTotal();
                        if (totalReserva != 0) {
                            String asientosAsignados = sala.getAsientosString();
                            View.mostrarCarrito(name, asientosAsignados, sala.getPelicula(), totalReserva, precio, subTotal);
                            Control.enter(in);
                        } else {
                            System.out.println("Su carrito esta vacio. Por favor, realice una reserva :)");
                            Control.enter(in);
                            break;
                        }
                        //By: Frank
                        do{
                        View.subMenuEditar();
                        System.out.print(msgOpcion);
                        option = Control.validarNumero(in, msgOpcion);

                            switch(option){
                                case 0:
                                    System.out.println();
                                    break;
                                case 1:
                                    Control.borrarAsiento(in, sala);
                                    Control.enter(in);
                                    break;
                                default:
                                    System.out.println("Por favor, ingrese una opcion valida..."); 
                                    break;
                            }
                        }while(option > 2 || option < 0);
                    }while(option!=0);
                    break;
                //By: Zeta
                case 3:
                    check = false;
                    // Aquí extraemos las variables dinámicas de la clase Sala
                    int cantTickets = sala.getTotalReservados();
                    double precioTicket = sala.getPrice();
                    double totalTicket = sala.getSubTotal();
                    if(cantTickets!=0){
                    String asientosAsignados = sala.getAsientosString();

                    // Se las enviamos al método de la clase View
                    View.imprimirTicket(name, asientosAsignados,sala.getPelicula(), cantTickets, precioTicket, totalTicket);
                    Control.finalizarCompra(sala);
                    }else{
                        System.out.println("Vuelva pronto y vea una pelicula en nuestro cine :)");
                    }
                    break;
                default:
                    System.out.println("Por favor, ingrese una opcion valida...");
                    break;
            }

        }
    }
}
