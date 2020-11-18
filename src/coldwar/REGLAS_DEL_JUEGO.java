package coldwar;


public class REGLAS_DEL_JUEGO {

	public REGLAS_DEL_JUEGO() {
		System.out.println("\nREGLAS DEL JUEGO:");
		System.out.println("- Cada equipo tiene que elegir un tipo de planeta con el que desee jugar. ");
		System.out.println("- Los planetas son los siguientes:");
		explicacion_planetas();
		System.out.println("- Los misiles puden servirse de tanto de defensa como para atacar.");
		System.out.println("- Los misiles de defensa valen dos misiles normales, es decir 25 misiles\n de defensa equivalen a 50 misiles de ataque.");
		System.out.println("¡Mucha SUERTE!");
	}
	
	public static void explicacion_planetas() {
		System.out.println("1- Planeta normal:\n" + 
				"	200 vidas\n" + 
				"	50 misiles\n" + 
				"2- Planeta rojo:\n" + 
				"	Ataca el doble al verde (x2)\n" + 
				"	Ataca la mitad al azul (/2)\n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
				"3- Planeta azul:\n" + 
				"	Ataca el doble al rojo (x2)\n" + 
				"	Ataca la mitad al verde (/2)\n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
				"4- Planeta verde:\n" + 
				"	Ataca el doble al azul (x2)\n" + 
				"	Ataca la mitad al rojo (/2) \n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
				"5- Gigante gaseoso:\n" + 
				"	400 vidas\n" + 
				"	Empieza solo con 10 misiles, va aumentando 10 más cada ronda que pasa\n" + 
				"6- Planeta enano:\n" + 
				"	100 vidas\n" + 
				"	100 misiles\n" + 
				"	Probabilidad de esquivar del 50%\n" + 
				"7- Planeta Bomba\n" + 
				"	200 vidas\n" + 
				"	150 misiles\n" + 
				"	Pierde cada turno 10 vidas, al morir hace 15 de daño a los equipos restantes\n" + 
				"8- Planeta Namek\n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
				"	Gana 25 vidas cada turno\n" + 
				"9- Planeta Escudo\n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
				"	El ataque se divide (/2)\n" + 
				"	La defensa se duplica (x2)\n" + 
				"10- Planeta Espada\n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
				"	El ataque se multiplica (x2)\n" + 
				"	La defensa se divide (/2)\n" + 
	"");
	}
	
	public static void RecuerdaExplicacion_planetas(int contTipo) {
		System.out.println("Requerda que ventajas tiene tu tipo de problema\n" );
		if(contTipo==1) { 
			 explicacion_planeta1();
		}else if(contTipo==2) {
			 explicacion_planeta2();
		}else if(contTipo==3) {
			 explicacion_planeta3();
		}else if(contTipo==4){
			 explicacion_planeta4();
		}else if(contTipo==5) {
			 explicacion_planeta5();
		}else if(contTipo==6) {
			 explicacion_planeta6();
		}else if(contTipo==7){ 
			 explicacion_planeta7();
		}else if(contTipo==8) {
			 explicacion_planeta8();
		}else if(contTipo==9) {
			 explicacion_planeta9();
		} else{//10
			 explicacion_planeta10();
		}
		
	}
	//explicacion por separado para mostrar en ataque
	public static void explicacion_planeta1() {
		System.out.println("-- Planeta normal --\n" + 
				"200 vidas\n" + 
				"50 misiles\n") ;
	}
	public static void explicacion_planeta2() {
		System.out.println("-- Planeta rojo --\n" + 
				"Ataca el doble (x2) al verde (numero 4)\n" + 
				"Ataca la mitad (/2) al azul (numero 3)\n" + 
				"200 vidas\n" + 
				"100 misiles\n") ;
	}
	public static void explicacion_planeta3() {
		System.out.println("-- Planeta azul --\n" + 
				"Ataca el doble (x2) al rojo (numero 2) \n" + 
				"Ataca la mitad (/2) al verde (numero 4) \n" + 
				"200 vidas\n" + 
				"100 misiles\n") ;
	}
	public static void explicacion_planeta4() {
		System.out.println("-- Planeta verde --\n" + 
				"Ataca el doble (x2) al azul (numero 3)\n" + 
				"Ataca la mitad (/2) al rojo (numero 2) \n" + 
				"200 vidas\n" + 
				"100 misiles\n" ) ;
	}
	public static void explicacion_planeta5() {
		System.out.println("-- Gigante gaseoso --\n" + 
				"400 vidas\n" + 
				"Empieza solo con 10 misiles, va aumentando 10 más cada ronda que pasa\n") ;
	}
	public static void explicacion_planeta6() {
		System.out.println("-- Planeta enano --\n" + 
				"100 vidas\n" + 
				"100 misiles\n" + 
				"Probabilidad de esquivar del 50%\n") ;
	}
	public static void explicacion_planeta7() {
		System.out.println("-- Planeta Bomba --\n" + 
				"200 vidas\n" + 
				"150 misiles\n" + 
				"Pierde cada turno 10 vidas, al morir hace 15 de daño a los equipos restantes\n") ;
	}
	public static void explicacion_planeta8() {
		System.out.println("-- Planeta Namek --\n" + 
				"200 vidas\n" + 
				"100 misiles\n" + 
				"Gana 25 vidas cada turno\n") ;
	}
	public static void explicacion_planeta9() {
		System.out.println("-- Planeta Escudo --\n" + 
				"200 vidas\n" + 
				"100 misiles\n" + 
				"El ataque se divide (/2)\n" + 
				"La defensa se duplica (x2)\n") ;
	}
	public static void explicacion_planeta10() {
		System.out.println("-- Planeta Espada --\n" + 
				"200 vidas\n" + 
				"100 misiles\n" + 
				"El ataque se multiplica (x2)\n" + 
				"La defensa se divide (/2)\n") ;
	}

}
