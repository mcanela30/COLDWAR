import java.util.ArrayList;
import java.util.Scanner;

public class main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<planeta> equipo = new ArrayList<planeta>();
	static int ronda=1,N=0;

	public static void main(final String[] args) {
		// TODO Auto-generated method stub

		menu();
	}


	public static void menu() {

		boolean salir = false;
		int opcion; //Guardaremos la opcion del usuario
		while(!salir){

			System.out.println("1. JUGAR");
			System.out.println("2. REGLAS DEL JUEGO");
			System.out.println("3. INFORMACIÓN");
			System.out.println("4. APARTADO ABIERTO");
			System.out.println("0. SALIR");

			System.out.print("Escribe una de las opciones: ");
			opcion = sc.nextInt();

			switch(opcion){
			case 1:
				System.out.println("\n------------------------------");
				System.out.println("Creando equipos...");
				crearEquipo();
				ronda();
				ataque();
				System.out.println("------------------------------\n");
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
				System.out.println("\n卐-卐-卐-卐-卐-卐-卐-卐-卐-卐-卐-卐-卐-卐");
				System.out.println("A la puta calle.");
				System.out.println("卐-卐-卐-卐-卐-卐-卐-卐-卐-卐-卐-卐-卐-卐");
				salir=true;
				break;
			default:
				System.out.println("\nSolo números entre 0 y 4");
			}

		}

	}

	public static void crearEquipo(){

		//Variable auxiliar que contendrá la referencia a cada coche nuevo.
		int i;
		//se pide por teclado el número de coches a leer
		do {
			System.out.print("Número de equipos? ");
			N = sc.nextInt();
		} while (N < 0);
		sc.nextLine(); //limpiar el intro

		for (i = 1; i <= N; i++) {

			//leer datos de cada coche
			System.out.println("Equipo " + i);
			System.out.print("Nombre: ");

			//se añade el objeto al final del array
			equipo.add(new planeta(sc.nextLine(),i));
		}
	}

	public static void ronda() {
		//do {
			System.out.println("-----------");
			System.out.println("| RONDA "+ronda+" |");
			System.out.println("-----------");
			mostrarEquipos();
			ronda++;
		//} while ();

	}

	public static void mostrarEquipos() {
		System.out.println("------------------------------");
		for(int i = 0; i< equipo.size(); i++)
			System.out.println(equipo.get(i));  //se invoca el método toString de la clase Coche                  
		System.out.println("------------------------------");

	}

	public static void ataque(){
		for (int i = 0; i < N; i++) {
			System.out.println("Turno de ataque del equipo "+(i+1)+": "+equipo.get(i).getNombre());
			System.out.println("------------------------------");
			for (int j = 0; j < N; j++) {
				
				if(i!=j) {
					System.out.println("Equipo "+(j+1) +": " +equipo.get(j).getNombre());
				}
			
			}
			System.out.println("0. Misiles restantes a defensa.");
			System.out.println("------------------------------");
			System.out.println("Misiles disponibles: "+ equipo.get(i).getMisiles_ronda());
			System.out.println("¿A quién quieres atacar?");
			sc.nextLine();
			System.out.println("Introduce el número de misiles con el que quieres atacar");
			sc.nextLine();
		}

	}

	public static void reglas() {
		System.out.println("REGLAS DEL JUEGO:");
		System.out.println("1. Cada equipo tiene 50 misiles por ronda. ");
		System.out.println("2. Los misiles puden servirse de tanto de defensa como para atacar.");
		System.out.println("3. Los misiles de defensa valen el doble, es decir 25 misiles\n de defensa equivalen a 50 misiles de ataque.");
		System.out.println("4. ¡Mucha SUERTE!");
	}

	public static void informacion() {
		System.out.println("Informacion sobre el programa:");
		System.out.println("- Version : 0.1");
		System.out.println("Contacto: ");
		System.out.println("Autores: ");
	}
}





