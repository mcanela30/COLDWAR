import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class partida {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<planeta> equipo = new ArrayList<planeta>();
	static int ronda=1,N=0, equiposVivos=0,k=0;
	public static int [] vidaAtaque;

	
	public void iniciarPartida(){
		System.out.println("\n------------------------------");
		System.out.println("Creando equipos...");
		crearEquipo();
		while (N!=1) {

			vidaAtaque = new int [N];
			ronda();
			ataque();
			comprobarequiposvivos();
		}
	}

	public static void crearEquipo(){

		int i;
		//se pide por teclado el nÃºmero de coches a leer
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

			//se aÃ±ade el objeto al final del array
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
			System.out.println(equipo.get(i));  //se invoca el metodo toString de la clase Coche                  
		System.out.println("------------------------------");
	}

	public static void ataque(){
		//se tiene que poner lo de las vidas para que no superes los 200.
		int ataque=0,misilAtaque=0, misilDefensa=0,mRonda=0,vida=0;
		boolean bucleRonda=true;

		for (int w = 0; w < N; w++) {
			vidaAtaque[w] = equipo.get(w).getVidas();			
		}

		for (k = 0; k < N;k++) {			
			ataque=0; misilAtaque=0; misilDefensa=0; mRonda=0; bucleRonda=true;vida=0;
			equipo.get(k).setMisilesDefensa(0);

			System.out.println("Turno de ataque del equipo "+(k+1)+": "+equipo.get(k).getNombre());
			System.out.println("------------------------------");

			equipo.get(k).setMisiles_ronda(50);



			while(bucleRonda==true) {
				System.out.println("Misiles disponibles: "+ equipo.get(k).getMisiles_ronda());
				System.out.println("�A quien quieres atacar?");

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
					equipo.get(k).setMisilesDefensa(misilDefensa);
					//					equipo.get((k)).setVidasDefensa(misilDefensa);				
				}				
				if(mRonda==0) {
					bucleRonda=false;
				}

			}
		}

		for (int i = 0; i < (N); i++) {
			if(vidaAtaque [i] != equipo.get(i).getVidas()) {
				equipo.get((i)).quitarVida();
			}

			if(vidaAtaque [i] == equipo.get(i).getVidas()) {

			}

		}

	}

	public static void comprobarequiposvivos() {
		for (int i = 0; i < N; i++) {
			int vidas=equipo.get(i).getVidas();
			if(vidas<=0) {
				equipo.remove(i);
				N--;
			}	
			if(vidas<=0) {
				equipo.remove(i);
				N--;
			}
		}
		mostrarGanador();
	}
	
	public void finalizarPartida(){
		System.out.println("==================================");
		System.out.println("La Partida ha finalizado");
		System.out.println("==================================");
	}
	
	public static void mostrarGanador() {
		if(N==1) {
			System.out.println("-----------------------------------");
			System.out.println("-----------------------------------");
			System.out.println("EL EQUIPO GANADOR ES: "+equipo.get(0).getNombre());
			System.out.println("-----------------------------------");
			System.out.println("-----------------------------------");
			System.out.println("");
			System.out.println("");

		}
	}

	
	
	
}
