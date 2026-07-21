package CineProyect;

public class Sala {

    //By: Frank
    private final String[][] ASIENTOS;
    private final int FILAS;
    private final int COLUMNAS;
    private final double PRICE;
    private final String PELICULA;

    //Impresion de asientos vacios
    public Sala(int filas, int columnas, String pelicula, double price) {
        this.FILAS = filas;
        this.COLUMNAS = columnas;
        this.PELICULA = pelicula;
        this.PRICE = price;

        this.ASIENTOS = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.ASIENTOS[i][j] = "O";
            }
        }
    }

    public String[][] getAsientos() {
        return ASIENTOS;
    }

    public int getFilas() {
        return FILAS;
    }

    public int getColumnas() {
        return COLUMNAS;
    }
    
    public double getPrice() {
        return PRICE;
    }

    public String getPelicula() {
        return PELICULA;
    }

    //Asientos reservados
    public int getTotalReservados() {
        int totalReservados = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (ASIENTOS[i][j].equals("C")) {
                    totalReservados++;
                }
            }
        }
        return totalReservados;
    }

    public double getSubTotal() {
        return getTotalReservados() * PRICE;
    }

    /*  By: Zeta
        Método para convertir las 'X' de la matriz en texto para el ticket
     */
    public String getAsientosString() {
        String asientosTexto = "";
        int contador = 0;
        for (int i = FILAS - 1; i >= 0; i--) {
            for (int j = COLUMNAS- 1; j >= 0; j--) {
                if (ASIENTOS[i][j].equals("C")) {
                    contador++;
                    if (!asientosTexto.equals("")) {
                        if ((contador - 1) % 5 == 0) {
                            asientosTexto += "\n";
                        } else {
                            asientosTexto += ", ";
                        }
                    }
                    // 1. Convertimos el índice 'i' a su letra correspondiente (G, F, E...)
                    char letraFila = (char) ('G' - i);

                    // 2. Convertimos el índice 'j' a la columna visual (0 -> 10, 1 -> 09, etc.)
                    int numeroColumna = 10 - j;

                    // 3. Le damos formato lindo (ejemplo: G10, F09, A01)
                    if (numeroColumna < 10) {
                        asientosTexto += letraFila + "0" + numeroColumna;
                    } else {
                        asientosTexto += letraFila + "" + numeroColumna;
                    }
                }
            }
        }
        return asientosTexto;
    }
}
