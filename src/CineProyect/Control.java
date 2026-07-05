package CineProyect;
import java.util.Scanner;
public class Control {
 
    public void enter(Scanner sc) {
        String entrada;
        do {
            System.out.print("Presione ENTER para continuar... ");
            entrada = sc.nextLine();
        } while (entrada.length() > 0);
    }
}