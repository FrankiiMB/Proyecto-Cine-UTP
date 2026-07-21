package CineProyect;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class GestorBaseDatos {

    private static final String BASE_DATOS_LOCAL = "datos.txt";

    public static void guardarDatos(Sala sala) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(BASE_DATOS_LOCAL))) {
            for (int i = 0; i < sala.getFilas(); i++) {
                for (int j = 0; j < sala.getColumnas(); j++) {
                    if (sala.getAsientos()[i][j].equals("X")) {
                        writer.print("X");
                    } else {
                        writer.print("O");
                        
                    }
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println(View.COLOR_ROJO_NEGRITA + "Error al guardar el archivo..." + View.COLOR_NORMAL);
        }
    }

    public static void cargarDatos(Sala sala) {
        File archivo = new File(BASE_DATOS_LOCAL);
        if (!archivo.exists()) {
            // Si es la primera vez que ejecutamos el programa y el archivo no existe entonces no hace nada
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int fila = 0;
            while ((linea = reader.readLine()) != null && fila < sala.getFilas()) {
                for (int j = 0; j < sala.getColumnas() && j < linea.length(); j++) {
                    char estado = linea.charAt(j);
                    if (estado == 'X') {
                        sala.getAsientos()[fila][j] = "X";
                    } else {
                        sala.getAsientos()[fila][j] = "O";
                    }
                }
                fila++;
            }
        } catch (IOException e) {
            System.out.println(View.COLOR_ROJO_NEGRITA + "Error al cargar el archivo de la sala..." + View.COLOR_NORMAL);
        }
    }
}
