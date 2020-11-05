package coldwar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {

    public void WriteResult() throws IOException {
    	// Crear objeto de archivo
        File f = new File("C:\\Users\\Admin\\Downloads\\ColdWar\\ColdWar\\src\\coldwar\\Result.txt");

     // Comprobar que el archivo ya existe o no si no existe crear un nuevo archivo
        if (!f.exists()) {
            f.createNewFile();
        }

     // Crear objeto de escritor del archivo creado
        PrintWriter writer = new PrintWriter(f);
     // Eliminar todos los datos del archivo
        writer.print("");

     // cierra el archivo
        writer.close();
    }

    public Menu() {
        String check;
     // Uso del escáner para obtener información del usuario
        Scanner sc = new Scanner(System.in);

        JUGAR ju = null;
        do {
            System.out.println("Seleccione la opción\n");
            System.out.println("1º JUGAR\n"
                    + "2º REGLAS DEL JUEGO\n"
                    + "3º INFORMACIÓN\n"
                    + "4º APARTADO ABIERTO\n"
                    + "0º SALIR");
            int s = sc.nextInt();
            switch (s) {
                case 1: // bloque de código
                {
                    ju = new JUGAR();
                    ju.iniciarPartida();
                }
                break;
                case 2: {// bloque de código
                    REGLAS_DEL_JUEGO rdj = new REGLAS_DEL_JUEGO();
                }
                break;
                case 3: // bloque de código
                {
                    NFORMACIÓN in = new NFORMACIÓN();
                }
                break;
                case 4:// bloque de código
                {
                   ju.apartadoAbierto();
                }
                break;
                case 0: // bloque de código
                {
                    new SALIR().endGame();
                }
                break;
                default:// bloque de código
                {
                    System.out.println("Menú incorrecto seleccionado");
                }
            }
            System.out.println("¿Quiere entrar en el menú? Pulse [y]"
            		+ " si no se saldra del juego");
            check = sc.next();
        } while (check.equals("y") == true);
    }

}
