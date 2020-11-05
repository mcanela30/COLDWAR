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
     // Uso del esc�ner para obtener informaci�n del usuario
        Scanner sc = new Scanner(System.in);

        JUGAR ju = null;
        do {
            System.out.println("Seleccione la opci�n\n");
            System.out.println("1� JUGAR\n"
                    + "2� REGLAS DEL JUEGO\n"
                    + "3� INFORMACI�N\n"
                    + "4� APARTADO ABIERTO\n"
                    + "0� SALIR");
            int s = sc.nextInt();
            switch (s) {
                case 1: // bloque de c�digo
                {
                    ju = new JUGAR();
                    ju.iniciarPartida();
                }
                break;
                case 2: {// bloque de c�digo
                    REGLAS_DEL_JUEGO rdj = new REGLAS_DEL_JUEGO();
                }
                break;
                case 3: // bloque de c�digo
                {
                    NFORMACI�N in = new NFORMACI�N();
                }
                break;
                case 4:// bloque de c�digo
                {
                   ju.apartadoAbierto();
                }
                break;
                case 0: // bloque de c�digo
                {
                    new SALIR().endGame();
                }
                break;
                default:// bloque de c�digo
                {
                    System.out.println("Men� incorrecto seleccionado");
                }
            }
            System.out.println("�Quiere entrar en el men�? Pulse [y]"
            		+ " si no se saldra del juego");
            check = sc.next();
        } while (check.equals("y") == true);
    }

}
