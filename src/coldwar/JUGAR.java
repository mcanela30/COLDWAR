package coldwar;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JUGAR {

	static Scanner sc = new Scanner(System.in); //importamos el scaner
	static ArrayList<planeta> equipo = new ArrayList<planeta>(); //creamos un arraylist de los planetas, para almacenar los datos de los equipos
	static int ronda=1,N=0, equiposVivos=0,k=0,G=0,P=-1; //creamos variables globales que nos serviran para hacer bucles y generar contadores
	public static int [] vidaAtaque;//creamos un array que servira para almacenar la vida que tenian antes de ser atacados para saber si hay que sumar defensa
	static String [] ganadores = new String [50];  //creamos un aray que servira para almacenar los ganadores de todas las partidas
	static Date fecha = new Date(); //una variable que guardara la fecha que se jugo y se gano la partida
	static int contTipo=0; // contador para elegir el tipo de planeta en la funciona crearEquipo().

	

	
	public static void iniciarPartida(){
		P++;
		System.out.println("\n------------------------------");
		System.out.println("Creando equipos...");
		crearEquipo();//llamamos al metodo para generar equipos
		while (N!=1) { // N es la variable que indica el numero de equipoc vivos, haremos un bucle mientras los equipos vivos no sean 1

			vidaAtaque = new int [N]; //asignasmos la longitud del array
			ronda(); //llamamos al metodo ronda para printar la ronda en la que estamos
			ataque(); //printams el metodo ataque para hacer ataques
			comprobarequiposvivos(); //comprovamos los equipos vivos
		}
	}

	public static void crearEquipo(){
		int i;
		do { //preguntamos cuantos equipos quieren
			System.out.print("Numeros de equipos? ");
			N = 2;
			
			try {
				N=sc.nextInt();
			}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
				System.out.println("ERROR. Està introduciendo una letra en vez de un numero. \n");
				sc.next();
			}
			if(N <3) {
				System.out.println("Como minimo se tienen que crear 3 equipos.");
			}
		} while (N < 3);

		sc.nextLine(); //limpiar el intro



		for (i = 1; i <= N; i++) {
			//leer datos de cada equipo
			System.out.println("Equipo " + i);
			System.out.print("Nombre: ");
			
			//se añade el objeto al final del array
//			equipo.add(new planeta(sc.nextLine(),i));

			contTipo=0;
		while (	contTipo<1 || contTipo>10){
		
		System.out.println("Hay distintos tipos de planeta:");
		REGLAS_DEL_JUEGO.explicacion_planetas();
		System.out.println("Que tipo de planeta quieres ser para el equipo "+ equipo.get((k++)).getNombre()+": ");
		
		try {
			contTipo=sc.nextInt();
			sc.nextLine(); //limpiar el intro

		
		}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
			System.out.println("ERROR. Està introduciendo una caracter no correcto en vez de un numero. \n");
			i=i-1;
			sc.next();
		}
		if(contTipo > 10 && 1 < contTipo) {
			System.out.println("ERROR. Tiene que ser entre 1 y 10.");
		}
		
		}		
	}
		

		
		
	}

	public static void ronda() {
		System.out.println("-----------");
		System.out.println("| RONDA "+ronda+" |");
		System.out.println("-----------");
		mostrarEquipos();//mostramos los equipos
		ronda++;
	}

	public static void mostrarEquipos() {
		System.out.println("------------------------------");
		for(int i = 0; i< equipo.size(); i++)
			System.out.println(equipo.get(i));  //se invoca el metodo toString de la clase planeta                  
		System.out.println("------------------------------");
	}

	public static void ataque(){
		//se tiene que poner lo de las vidas para que no superes los 200.
		int ataque=0,misilAtaque=0, misilDefensa=0,mRonda=0,vida=0;
		boolean bucleRonda=true;

		for (int w = 0; w < N; w++) {
			vidaAtaque[w] = equipo.get(w).getVidas(); //hacemos un bucle antes de realizar ataques para guardar la vida de acda uno de los equipos, para despues comparar y decidir si sumar la defensa
		}

		for (k = 0; k < N;k++) {		//bucle de los ataques	
			ataque=0; misilAtaque=0; misilDefensa=0; mRonda=0; bucleRonda=true;vida=0; //ponemos los valores a 0 para evitar fallos
			equipo.get(k).setMisilesDefensa(0);

			System.out.println("Turno de ataque del equipo "+(k+1)+": "+equipo.get(k).getNombre()); //imprimimos de quien es turno
			System.out.println("------------------------------");

			equipo.get(k).setMisiles_ronda(50); //seteamos los misiles a 50



			while(bucleRonda==true) {//bucle para decidir si continuar en el bucle o no dependiendo de los valores que asignemos en la variable boolean
				System.out.println("Misiles disponibles: "+ equipo.get(k).getMisiles_ronda());
				System.out.println("¿A quien quieres atacar?");

				for (int j = 0; j < N; j++) {//imprimimos los equipos disponibles
					if(k!=j) {//esto sierve para imprimir todos los equipos menos el atacante
						System.out.println((j+1) +". " +equipo.get(j).getNombre());
					}
				}
				ataque=5;

				System.out.println("0. Misiles restantes a defensa.");
				
				try {
					ataque=sc.nextInt();
				}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
					System.out.println("ERROR. Està introduciendo una letra en vez de un numero. \n");
					sc.next();
				}



				while(ataque<0 || ataque>N || ataque==(k+1)) {//evitar fallos
					System.out.println("ERROR. Introduce de nuevo a quien desea atacar");
					try {
						ataque=sc.nextInt();
					}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
						System.out.println("ERROR. Està introduciendo una letra en vez de un numero. \n");
						sc.next();
					}
				}
				if(ataque!=0) {
					System.out.println("Introduce el numero de misiles con el que quieres atacar");
					misilAtaque=sc.nextInt();//guardamos quantos misiles ha lanzado

					while(misilAtaque>equipo.get(k).getMisiles_ronda()) {
						System.out.println("ERROR. No tienes tantos misiles disponibles.\n Introduce el numero de misiles con el que quieres atacar");
						misilAtaque=sc.nextInt();	
					}
					mRonda=equipo.get(k).getMisiles_ronda()-misilAtaque; //calkculamos cuantos misiles qquedan
					equipo.get(k).setMisiles_ronda(mRonda); //guardamos al usuario los misiles que le quedan
					vida=equipo.get(ataque-1).getVidas(); //guardamos la vida del usuario
					equipo.get((ataque-1)).setVidas(misilAtaque,vida); //restamos el ataque
				}
				else { //en caso de ser la opcion 0

					misilDefensa=equipo.get(k).getMisiles_ronda()/2; //dividimos en dos los misiles que lanzan
					mRonda=equipo.get(k).getMisiles_ronda()-misilDefensa*2; //multiplicamos por 2 los misiles enviados para calcular el vvalor de los misiles
					equipo.get(k).setMisiles_ronda(mRonda); //guardamos los valroes de los misiles
					equipo.get(k).setMisilesDefensa(misilDefensa); //guardamos los misiles de defensa
				}					
				if(mRonda==0) {
					bucleRonda=false; //cuanod los misiles sean 0 pasara al siguiente jugador
				}

			}
		}

		for (int i = 0; i < (N); i++) { //en este bucle comparamos la vida de los jugadores antes de la ronda, a el fiinal de la ronda, para asi poder saber si hay que sumar defensa o no
			if(vidaAtaque [i] != equipo.get(i).getVidas()) {
				equipo.get((i)).quitarVida(); //suma la defensa al jugador en caso de ser atacado
			}

			if(vidaAtaque [i] == equipo.get(i).getVidas()) {
				//no pasa nada, se mantiene igual
			}

		}

	}

	public static void comprobarequiposvivos() { //comprobamos equipos vivos
		for (int i = 0; i < N; i++) { //corremos un bucle de N (numero de equipos
			int vidas=equipo.get(i).getVidas();
			if(vidas<=0) { //en caso de tener menos o igual a 0 en vidas, este equipoc es expulsado de la array y se resta unn Equipo del contador
				equipo.remove(i);
				N--;
			}	
			if(vidas<=0) { //no se porque pero nos arregla un fallo
				equipo.remove(i);
				N--;
			}
		}
		mostrarGanador(); //mostramos ganador
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
			System.out.println("EL EQUIPO GANADOR ES: "+equipo.get(0).getNombre()); //coje el nombre del ultimo equipo en pie
			System.out.println("-----------------------------------");
			System.out.println("-----------------------------------");
			G++; //G guarda el numero de ganadores
				ganadores[P] = equipo.get(0).getNombre(); //guarda g en la array de ganadores
			
			
			for (int l = 0; l < N; l++) {
				equipo.remove(l);
			}
		}
	}
	
	//Funciona para printar los ganadores que han jugado al iniciar el juego. 
	public static void apartadoAbierto() {
		System.out.println("Los Ganadores de las partidas a partir del "+ fecha + " son:"); //imprime fecha actual

		for (int i = 0; i < G; i++) {
			System.out.println("Partida -> "+ (i+1) +" Equipo Ganador: " + ganadores[i]); //imprime los ganadores del juego
		}
	}
		
}