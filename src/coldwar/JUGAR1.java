package coldwar;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class JUGAR1 {

	static Scanner sc = new Scanner(System.in); //importamos el scaner
	static ArrayList<planeta> equipo = new ArrayList<planeta>(); //creamos un arraylist de los planetas, para almacenar los datos de los equipos
	static int ronda=1,N=0, equiposVivos=0,k=0,G=0,P=-1; //creamos variables globales que nos serviran para hacer bucles y generar contadores
	public static int [] vidaAtaque;//creamos un array que servira para almacenar la vida que tenian antes de ser atacados para saber si hay que sumar defensa
	static String [] ganadores = new String [50];  //creamos un aray que servira para almacenar los ganadores de todas las partidas
	static Date fecha = new Date(); //una variable que guardara la fecha que se jugo y se gano la partida
	static int contTipo=0;//  creamos variables para los equipos.
	static String nomEquip; //para guardar el nombre del equipo.


//no se guarda

	public static void iniciarPartida(){
		P++;
		limpiarPantalla();
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
			System.out.print("Quantos equipos deseas crear? ");
			N = 2;

			try {
				N=sc.nextInt();
			}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
				System.out.println("ERROR. Està introduciendo un caracter no valido. \n"
						+ "Recuerda que solo puedes introducir numeros");
				sc.next();
			}
			if(N <3) {
				System.out.println("Como minimo se tienen que crear 3 equipos.");
			}
		} while (N < 3);

		sc.nextLine(); //limpiar el intro

		limpiarPantalla();

		for (i = 1; i <= N; i++) {
			//leer datos de cada equipo
			System.out.println("Equipo " + i);
			System.out.print("Nombre: ");

			//			equipo.add(new planeta(sc.nextLine(), i, contTipo));
			nomEquip=sc.nextLine();


			contTipo=0;
			while (	contTipo<1 || contTipo>10){

				System.out.println("Hay distintos tipos de planeta:");
				REGLAS_DEL_JUEGO.explicacion_planetas();
				System.out.println("Que tipo de planeta quieres ser para el equipo "+ nomEquip +": ");

				try {
					contTipo=sc.nextInt();
					sc.nextLine(); //limpiar el intro


				}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
					System.out.println("ERROR. Està introduciendo un caracter no valido. \n"
							+ "Recuerda que solo puedes introducir numeros");
					i=i-1;
					sc.next();
				}
				if(contTipo > 10 && 1 < contTipo) {
					System.out.println("ERROR. El numero tiene que ser entre 1 y 10.");
				}

			}

			TipoPlaneta(nomEquip,contTipo,i); // pasamos a la funcion el nombre del equipo, tipo de planeta y su posicion en l'array. 
			limpiarPantalla();
			System.out.println("El equipo: '"+ nomEquip +"' del tipo planeta "+contTipo+" ha sido creado correctamente.");


		}	
	}

	public static void TipoPlaneta(String nomEquip, int contTipo, int i) {
		int  vidas=0, misiles_ronda=0; 
		if(contTipo==2||contTipo==3||contTipo==4||contTipo==8||contTipo==9||contTipo==10) {// las mismas vidas.
			vidas=200;
			misiles_ronda=100;
		}else if(contTipo==5) {//planeta gigante
			vidas=400;
			misiles_ronda=10;
		}else if(contTipo==6) {//planta enano
			vidas=100;
			misiles_ronda=100;
		}else if(contTipo==7){//planeta bomba numero 7
			vidas=200;
			misiles_ronda=150;
		} else{//planeta normal 
			vidas=200;
			misiles_ronda=50;
		}
		equipo.add(new planeta(nomEquip, vidas, misiles_ronda, i, contTipo)); //lo ponemos en el arraylist. 

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

		for (k = 0; k < N;k++) {//bucle de los ataques	
			ataque=0; misilAtaque=0; misilDefensa=0; mRonda=0; bucleRonda=true;vida=0; //ponemos los valores a 0 para evitar fallos
			equipo.get(k).setMisilesDefensa(0);

			System.out.println("Turno de ataque del equipo "+(k+1)+": "+equipo.get(k).getNombre()); //imprimimos de quien es turno
			System.out.println("------------------------------");


			resetmisiles();

			while(bucleRonda==true) {//bucle para decidir si continuar en el bucle o no dependiendo de los valores que asignemos en la variable boolean
				System.out.println("Misiles disponibles: "+ equipo.get(k).getMisiles_ronda());
				System.out.println("¿A que equipo quieres atacar?");
				REGLAS_DEL_JUEGO.RecuerdaExplicacion_planetas(equipo.get(k).setTipo());
				for (int j = 0; j < N; j++) {//imprimimos los equipos disponibles
					if(k!=j) {//esto sierve para imprimir todos los equipos menos el atacante
						System.out.println("Pulsa: "+(j+1) +" para atacar a " +equipo.get(j).getNombre()+", es un pleneta tipo "+equipo.get(j).setTipo());
						
					}
				}
				ataque=5;

				System.out.println("Pulsa: 0 para tener todos los misiles restantes van a defensa.");

				try {
					ataque=sc.nextInt();
				}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
					System.out.println("ERROR. Està introduciendo un caracter no valido. \n"
									 + "Recuerda que solo puedes introducir numeros");
					sc.next();
				}



				while(ataque<0 || ataque>N || ataque==(k+1)) {//evitar fallos
					System.out.println("ERROR. Introduce de nuevo a quien desea atacar");
					try {
						ataque=sc.nextInt();
					}catch(InputMismatchException ime) {// en caso que introducza una letra le va ha salir este error gracias a este catch.
						System.out.println("ERROR. Està introduciendo un caracter no valido. \n"
								+ "Recuerda que solo puedes introducir numeros");
						sc.next();
					}
				}
				if(ataque!=0) {
					System.out.println("Introduce el numero de misiles con el que quieres atacar");
					misilAtaque=sc.nextInt();//guardamos quantos misiles ha lanzado

					while(misilAtaque>equipo.get(k).getMisiles_ronda()) {
						System.out.println("ERROR. No tienes tantos misiles disponibles.\n "
								+ "Introduce el numero de misiles con el que quieres atacar\n"
								+ "Tienes "+equipo.get(k).getMisiles_ronda()+" misiles restantes");
						misilAtaque=sc.nextInt();	
					}
					mRonda=equipo.get(k).getMisiles_ronda()-misilAtaque; //calculamos cuantos misiles quedan
					equipo.get(k).setMisiles_ronda(mRonda); //guardamos al usuario los misiles que le quedan
					vida=equipo.get(ataque-1).getVidas(); //guardamos la vida del usuario
					ataqueP(ataque, misilAtaque, vida);// llamamos la funcions ataqueP() para restar el ataque
					
				}
				else { //en caso de ser la opcion 0
					defensaP(misilDefensa, mRonda);
				}					
				if(mRonda==0) {
					bucleRonda=false; //cuando los misiles sean 0 pasara al siguiente jugador
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

	public static void resetmisiles() {
		if(equipo.get(k).getTipo()==2||equipo.get(k).getTipo()==3||equipo.get(k).getTipo()==4||equipo.get(k).getTipo()==8||equipo.get(k).getTipo()==9||equipo.get(k).getTipo()==10 || equipo.get(k).getTipo()==6) {// las mismas vidas.
			equipo.get(k).setMisiles_ronda(100);
		}else if(equipo.get(k).getTipo()==5) {//planeta gigante
			equipo.get(k).setMisiles_ronda(ronda*10-10);
			//para cada ronda que pase se suma +10 en los misiles que es li mismo que multiplicarlo por 10 el num de rondas. se le resta 10 ya que despues de printar la ronda se suma 1
		} else if (equipo.get(k).getTipo()==7){//planeta bomba numero 7
			equipo.get(k).setMisiles_ronda(150);
		}else {
			equipo.get(k).setMisiles_ronda(50); //planeta normal numero 1
		}
		
	}

	public static void ataqueP( int ataque, int misilAtaque, int vida) {
		int ale=3;
		ataque=ataque-1;
		if((equipo.get(k).getTipo()==2&& equipo.get(ataque).getTipo()==4)||(equipo.get(k).getTipo()==3&& equipo.get(ataque).getTipo()==2)||(equipo.get(k).getTipo()==4&& equipo.get(ataque).getTipo()==3)||equipo.get(k).getTipo()==10) {
			//ataque x2
			misilAtaque=misilAtaque*2;
			System.out.println("El ataque se multiplica x2");
			equipo.get((ataque-1)).setVidas(misilAtaque,vida); 
		} else if((equipo.get(k).getTipo()==2&& equipo.get(ataque).getTipo()==3)||(equipo.get(k).getTipo()==3&& equipo.get(ataque).getTipo()==4)||(equipo.get(k).getTipo()==4&& equipo.get(ataque).getTipo()==2)||equipo.get(k).getTipo()==9) {
			//ataque %2
			misilAtaque=misilAtaque/2;
			System.out.println("El ataque se divide /2");
			equipo.get((ataque-1)).setVidas(misilAtaque,vida); 
		} else if(equipo.get(ataque).getTipo()==6) {
			Random aleatorio = new Random();
			ale=aleatorio.nextInt(2);
			 if(ale==0) {
				 equipo.get((ataque-1)).setVidas(misilAtaque,vida); 		
			 } else {
				 System.out.println("El planeta ha esquivado el ataque.");
			 }

		} else {
			//ataque normal
			equipo.get((ataque-1)).setVidas(misilAtaque,vida); 
		}
		
		
	}
	
	public static void defensaP(int misilDefensa, int mRonda) {

		//		misilDefensa=equipo.get(k).getMisiles_ronda()/2; //dividimos en dos los misiles que lanzan
		//		mRonda=equipo.get(k).getMisiles_ronda()-misilDefensa*2; //multiplicamos por 2 los misiles enviados para calcular el valor de los misiles
		//		equipo.get(k).setMisiles_ronda(mRonda); //guardamos los valores de los misiles
		//		equipo.get(k).setMisilesDefensa(misilDefensa); //guardamos los misiles de defensa

		if(equipo.get(k).setTipo()==9) {//el planeta escudo cada misil que use en defensa equivale a un punto por eso no se resta
			misilDefensa=equipo.get(k).getMisiles_ronda();
			mRonda=equipo.get(k).getMisiles_ronda()-misilDefensa;

		} else if(equipo.get(k).setTipo()==10) {// el planeta espada por cada punto de defensa tiene que pagar 4 misiles
			misilDefensa=equipo.get(k).getMisiles_ronda()/4;
			mRonda=equipo.get(k).getMisiles_ronda()-misilDefensa*4;

		} else {
			misilDefensa=equipo.get(k).getMisiles_ronda()/2; //dividimos en dos los misiles que lanzan
			mRonda=equipo.get(k).getMisiles_ronda()-misilDefensa*2; //multiplicamos por 2 los misiles enviados para calcular el valor de los misiles

		}
		//esto se repite en todos los casos
		equipo.get(k).setMisiles_ronda(mRonda); //guardamos los valroes de los misiles
		equipo.get(k).setMisilesDefensa(misilDefensa); //guardamos los misiles de defensa
	}

	public static void comprobarequiposvivos() { //comprobamos equipos vivos
		for (int i = 0; i < N; i++) { //corremos un bucle de N (numero de equipos
			int vidas=equipo.get(i).getVidas();
			if(vidas<=0) { //en caso de tener menos o igual a 0 en vidas, este equipo es expulsado de la array y se resta unn Equipo del contador
				System.out.println("El equipo "+i+" se ha quedado sin vidas");
				equipo.remove(i);
				N--;
				//				for (int j = 0; j < N ; j++) { MIRAR PER PLANETA 7 BOMBA
				//					equipo.get((i)).setVidas(-10, j);
				//				}
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

	public static void limpiarPantalla() {
		for (int i = 0; i < 70; i++) {
			System.out.println("");
		}
	}

	/*
	 * Prova de mirar que no es repeteixin els noms dels equips
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
			//do {
			//leer datos de cada equipo
			System.out.println("Equipo " + i);
			System.out.print("Nombre: ");


			eq=sc.nextLine();
			for (int c=0;c<equipo.size();c++) {
			      if(eq==equipo[c]) { ///MIRARRRRRRRRRRRRR
			    	  System.out.print("El equipo "+equipo.get(k).getNombre()+" ya esta elegido porfavor eliga otro");
			    	  NomEquip=false;
			      }

			    }


			}while(NomEquip==true);

			//se aÃƒÂ±ade el objeto al final del array
			equipo.add(new planeta(eq,i));

			equiposVivos++;
		}

	 */	
}