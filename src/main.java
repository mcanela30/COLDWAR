import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<planeta> equipo = new ArrayList<planeta>();
	static int ronda=1,N=0, equiposVivos=0,k=0;
	public static int [] vidaAtaque;

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		menu();
	}

	public static void menu() {

		boolean salir = false;
		int opcion = 5; //Guardaremos la opcion del usuario
		while(!salir){

			System.out.println("1. JUGAR");
			System.out.println("2. REGLAS DEL JUEGO");
			System.out.println("3. INFORMACION");
			System.out.println("4. APARTADO ABIERTO");
			System.out.println("0. SALIR");
			System.out.print("Escribe una de las opciones: ");
			
			try {
				opcion=sc.nextInt();
			}catch(InputMismatchException ime) {
				System.out.println("ERROR. Està introduciendo una letra en vez de un numero. \n");
				sc.next();
			}

			switch(opcion){
			case 1:
				
			       partida partida = new partida();
				
			       partida.iniciarPartida();
				if(N==1) {
					partida.finalizarPartida();
					break;
				}
				break;
			case 2:
				System.out.println("\n------------------------------");
				reglas();
				System.out.println("------------------------------\n");
				break;
			case 3:
				System.out.println("\n------------------------------");
				informacion();
				System.out.println("------------------------------\n");
				break;
			case 4:
				System.out.println("\n------------------------------");
				System.out.println("Has seleccionado el apartado abierto.");
				System.out.println("------------------------------\n");
				System.out.println(" ");
				break;
			case 0:
				System.out.println("\nÃ¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-");
				System.out.println("A la puta calle.");
				System.out.println("Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥");
				salir=true;
				break;
			default:
				System.out.println("\nSolo numeros entre 0 y 4");
			}
		}
	}
	
	
	public static void reglas() {
		System.out.println("REGLAS DEL JUEGO:");
		System.out.println("1. Cada equipo tiene 50 misiles por ronda. ");
		System.out.println("2. Los misiles puden servirse de tanto de defensa como para atacar.");
		System.out.println("3. Los misiles de defensa valen el doble, es decir 25 misiles\n de defensa equivalen a 50 misiles de ataque.");
		System.out.println("4. Ã‚Â¡Mucha SUERTE!");
	}

	public static void informacion() {
		System.out.println("Informacion sobre el programa:");
		System.out.println("- Version : 0.1");
		System.out.println("Contacto: ");
		System.out.println("Autores: ");
	}

}





