package CineProyect;
public class Sala{
    private String[][] asientos;
    private int filas = 7;
    private int columnas= 10;
    private double price = 15.0;

    //Impresion de asientos vacios
    public Sala() {
        asientos = new String[7][10];
        for(int i = 0; i<7; i++){
            for(int j = 0; j<10; j++){
                asientos[i][j] = "O";
            }
        }
    }

    public String[][] getAsientos() {
        return asientos;
    }
    
    //Asientos reservados
    public int cantidadReservados() {
        int contador = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (asientos[i][j].equals("X")) contador++;
            }
        }
        return contador;
    }

    public double subTotal() {
        return cantidadReservados() * price;
    }
    
    public double price() {
        return price;
    }
}

