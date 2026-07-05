package CineProyect;
public class Sala{
    private final String[][] ASIENTOS;
    private final int FILAS = 7;
    private final int COLUMNAS = 10;
    private double price = 15.0;

    //Impresion de asientos vacios
    public Sala() {
        this.ASIENTOS = new String[7][10];
        for(int i = 0; i<7; i++){
            for(int j = 0; j<10; j++){
                this.ASIENTOS[i][j] = "O";
            }
        }
    }

    public String[][] getAsientos() {
        return ASIENTOS;
    }
    
    //Asientos reservados
    public int getTotalReservados() {
        int totalReservados = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (ASIENTOS[i][j].equals("X")) totalReservados++;
            }
        }
        return totalReservados;
    }
    
    public double getSubTotal() {
        return getTotalReservados() * price;
    }
    
    public double getPrice() {
        return price;
    }
}

