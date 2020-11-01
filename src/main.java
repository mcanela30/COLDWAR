//Coldwar - MAIN 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

public class main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<planeta> equipo = new ArrayList<planeta>();
	static int ronda=1,N=0, equiposVivos=0,k=0;
	public static int [] vidaAtaque;
	static Date fecha = new Date();

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		menu();//llamamos al menu
	}

	//esta funcion sirve para prinatar el menu
	public static void menu() {

		boolean salir = false;
		int opcion = 5; //la inicializamos a 5 porque de esta forma si pone un caracter que no sea entre el 0 o el 4 le salga otra vex el menu
		while(!salir){

			System.out.println("1. JUGAR");
			System.out.println("2. REGLAS DEL JUEGO");
			System.out.println("3. INFORMACION");
			System.out.println("4. APARTADO ABIERTO");
			System.out.println("0. SALIR");
			System.out.print("Escribe una de las opciones: ");

			try {
				opcion=sc.nextInt();
			}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
				System.out.println("ERROR. Està introduciendo una letra en vez de un numero. \n");
				sc.next();
			}
			partida partida = new partida();//llamamos a la clase partida.
			switch(opcion){//menu
			case 1:
				partida.iniciarPartida();//llamamos a la funcion inciarPartida() de la clase Partida.
				if(N==1) {// en caso que sea igual que la variable N sea igual que 1 llamaremos a la siguiente funcion.
					partida.finalizarPartida();
					break;
				}
				break;
			case 2:
				System.out.println("\n------------------------------");
				reglas();//llamamos a la funcion reglas
				System.out.println("------------------------------\n");
				break;
			case 3:
				System.out.println("\n------------------------------");
				informacion();//llamamos a la funcion informacion
				System.out.println("------------------------------\n");
				break;
			case 4:
				System.out.println("\n------------------------------");
				partida.apartadoAbierto();
				System.out.println("------------------------------\n");
				System.out.println(" ");
				break;
			case 0:
				System.out.println("\nÃ¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-");
				System.out.println("A la puta calle."); // salimos del juego
				System.out.println("Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥");
				salir=true; // ponemos el boolean a true para que no vuleva a entrar al while y no printe el menu. 
				break;
			default:
				System.out.println("\nSolo numeros entre 0 y 4");// en caso que el usuario ponga otro numero que no sea del 0 al 4 entra aqui. 
			}
		}
	}

	//Esta funcion printa las reglas del juego.
	public static void reglas() {
		System.out.println("REGLAS DEL JUEGO:");
		System.out.println("1. Cada equipo tiene 50 misiles por ronda. ");
		System.out.println("2. Los misiles puden servirse de tanto de defensa como para atacar.");
		System.out.println("3. Los misiles de defensa valen el doble, es decir 25 misiles\n de defensa equivalen a 50 misiles de ataque.");
		System.out.println("4. Ã‚Â¡Mucha SUERTE!");
	}

	//Funciona para printar la informacion del juego.
	public static void informacion() {
		System.out.println("Informacion sobre el programa:");
		System.out.println("- Version : 1.0");
		System.out.println("Contacto: manda@unaayuda.com");
		System.out.println("Autores: Gabriel Gomez y Marti Canela");
	}

}





