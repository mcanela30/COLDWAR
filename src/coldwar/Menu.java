package coldwar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
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
     // Uso del esc�ner para obtener informaci�n del usuario
        Scanner sc = new Scanner(System.in);
        JUGAR ju = null;
		int opcion = 5; //la inicializamos a 5 porque de esta forma si pone un caracter que no sea entre el 0 o el 4 le salga otra vex el menu
		boolean salir = false;
		while(!salir){
        	System.out.println("Seleccione una opci�n:\n");
            System.out.println("1� JUGAR\n"
                    + "2� REGLAS DEL JUEGO\n"
                    + "3� INFORMACI�N\n"
                    + "4� APARTADO ABIERTO\n"
                    + "0� SALIR");
			try {
				opcion=sc.nextInt();
			}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
				System.out.println("\nERROR. Est� introduciendo una letra en vez de un numero.");
				sc.next();
			}
            switch (opcion) {
                case 1: // bloque de c�digo
                {
                    ju = new JUGAR();
                    ju.iniciarPartida();
                }
                break;
                case 2: {// bloque de c�digo
    				System.out.println("\n------------------------------");
                    REGLAS_DEL_JUEGO rdj = new REGLAS_DEL_JUEGO();
    				System.out.println("------------------------------\n");
                }
                break;
                case 3: // bloque de c�digo
                {
    				System.out.println("\n------------------------------");
                    NFORMACI�N in = new NFORMACI�N();
    				System.out.println("------------------------------\n");
                }
                break;
                case 4:// bloque de c�digo
                {
    				System.out.println("\n------------------------------");
                   ju.apartadoAbierto();
   				System.out.println("------------------------------\n");
                }
                break;
                case 0: // bloque de c�digo
                {
    				System.out.println("\n------------------------------");
                    new SALIR().endGame();
    				System.out.println("------------------------------\n");
                }
                break;
                default:// bloque de c�digo                            	
    				System.out.println("Solo numeros entre 0 y 4\n");// en caso que el usuario ponga otro numero que no sea del 0 al 4 entra aqui. 
               
            }
        } 
    }

}
