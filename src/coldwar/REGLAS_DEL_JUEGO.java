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
		System.out.println("1- Planeta normal\n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
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
				"	Pierde cada turno 15 vidas, al morir elige hacer 15 de daña a otro planeta\n" + 
				"8- Planeta Namek\n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
				"	Gana 25 vidas cada turno\n" + 
				"9- Planeta Escudo\n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
				"	La defensa se duplica (x2)\n" + 
				"	El ataque se divide (/2)\n" + 
				"10- Planeta Espada\n" + 
				"	200 vidas\n" + 
				"	100 misiles\n" + 
				"	El ataque se multiplica (x2)\n" + 
				"	La defensa se divide (/2)\n" + 
	"");
	}

}
