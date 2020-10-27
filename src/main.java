import java.util.ArrayList;
import java.util.Scanner;

public class main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<planeta> equipo = new ArrayList<planeta>();
	static int ronda=1,N=0, equiposVivos=0,k=0;

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
			System.out.println("3. INFORMACION");
			System.out.println("4. APARTADO ABIERTO");
			System.out.println("0. SALIR");
			System.out.print("Escribe una de las opciones: ");
			opcion = sc.nextInt();

			switch(opcion){
			case 1:
				System.out.println("\n------------------------------");
				System.out.println("Creando equipos...");
				crearEquipo();
				while (equiposVivos!=50) {
					comprobarequiposvivos();
					ronda();
					ataque();
					
				}
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
				System.out.println("\nÃ¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½");
				System.out.println("A la puta calle.");
				System.out.println("Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½-Ã¥ï¿½ï¿½");
				salir=true;
				break;
			default:
				System.out.println("\nSolo numeros entre 0 y 4");
			}
		}
	}

	public static void crearEquipo(){

		int i;
		//se pide por teclado el nÃƒÂºmero de coches a leer
		do {
			System.out.print("Numeros de equipos? ");
			N = sc.nextInt();
			if(N <3) {
			System.out.println("Como minimo se tienen que crear 3 equipos.");
			}
		} while (N < 3);
	
		sc.nextLine(); //limpiar el intro

		

		for (i = 1; i <= N; i++) {

			//leer datos de cada coche
			System.out.println("Equipo " + i);
			System.out.print("Nombre: ");

			//se aÃƒÂ±ade el objeto al final del array
			equipo.add(new planeta(sc.nextLine(),i));
			equiposVivos++;
		}
	}

	public static void ronda() {
		System.out.println("-----------");
		System.out.println("| RONDA "+ronda+" |");
		System.out.println("-----------");
		mostrarEquipos();
		ronda++;
	}

	public static void mostrarEquipos() {
		System.out.println("------------------------------");
		for(int i = 0; i< equipo.size(); i++)
			System.out.println(equipo.get(i));  //se invoca el mÃƒÂ©todo toString de la clase Coche                  
		System.out.println("------------------------------");
	}

	public static void ataque(){
		//se tiene que poner lo de las vidas para que no superes los 200.
		int ataque=0,misilAtaque=0, misilDefensa=0,mRonda=0,vida=0;
		boolean bucleRonda=true;

		for (k = 0; k < N;k++) {

			ataque=0; misilAtaque=0; misilDefensa=0; mRonda=0; bucleRonda=true;vida=0;

			System.out.println("Turno de ataque del equipo "+(k+1)+": "+equipo.get(k).getNombre());
			System.out.println("------------------------------");

			equipo.get(k).setMisiles_ronda(50);



			while(bucleRonda==true) {
				System.out.println("Misiles disponibles: "+ equipo.get(k).getMisiles_ronda());
				System.out.println("¿A quien quieres atacar?");

				for (int j = 0; j < N; j++) {
					if(k!=j) {
						System.out.println((j+1) +". " +equipo.get(j).getNombre());
					}
				}

				System.out.println("0. Misiles restantes a defensa.");
				ataque=sc.nextInt();

				while(ataque<0 || ataque>N || ataque==(k+1)) {
					System.out.println("ERROR. Introduce de nuevo a quien desea atacar");
					ataque=sc.nextInt();	
				}
				if(ataque!=0) {
					System.out.println("Introduce el numero de misiles con el que quieres atacar");
					misilAtaque=sc.nextInt();

					while(misilAtaque>equipo.get(k).getMisiles_ronda()) {
						System.out.println("ERROR. No tienes tantos misiles disponibles.\n Introduce el numero de misiles con el que quieres atacar");
						misilAtaque=sc.nextInt();	
					}
					mRonda=equipo.get(k).getMisiles_ronda()-misilAtaque;
					equipo.get(k).setMisiles_ronda(mRonda);
					vida=equipo.get(ataque-1).getVidas();
					equipo.get((ataque-1)).setVidas(misilAtaque,vida);
				}

				else {
										
					misilDefensa=equipo.get(k).getMisiles_ronda()/2;
					mRonda=equipo.get(k).getMisiles_ronda()-misilDefensa*2;
					equipo.get(k).setMisiles_ronda(mRonda);
					equipo.get((k)).setVidasDefensa(misilDefensa);				
				}				
				if(mRonda==0) {
					bucleRonda=false;
				}
				
			}
		}
		
		for (k = 0; k < N;k++) {
			vida=equipo.get(k).getVidas();


		}


	}

	public static void comprobarequiposvivos() {
		for (int i = 0; i < N; i++) {
			int vidas=equipo.get(i).getVidas();
		if(vidas<=0) {
	         equipo.remove(i);
	         N--;
		}			
		}
		System.out.println(equiposVivos);
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





