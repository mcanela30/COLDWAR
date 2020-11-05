package coldwar;


public class REGLAS_DEL_JUEGO {

	public REGLAS_DEL_JUEGO() {
		System.out.println("\nREGLAS DEL JUEGO");
		System.out.println("Se Preguntara el numero de equipos que se quieren crear (minimo 4)\n"
				+ "El jugador eligira el nombre de su equipo\n" + "Cada jugador tendra 200 vidas (automático)\n"
				+ "Cada equipo tendra 50 misiles que podra usar cada ronda\n"
				+ "Los miseles se podran usar para defender o para atacar\n" + "Un misil de ataque vale 1 punto\n"
				+ "Un misil de defensa vale 2 puntos\n" + "Un equipo solo puede atackar a UN equipo rival\n"
				+ "Si un equipo se equivoca se le saltara el turno"
				+ "Los misiles que sobren en la ronda se pondran en defensa en el caso de ser un numero\n"
				+ "impara este se perdera\n"
				+ "Como en el ajedrez quien empiza tiene ventaja pues si un equipo te mata i tu te podias haver defendido no se te dara esta oportunidad"
				+ "Al final de la partida se mostrará por pantalla el ganador i se guardara en el ranking\n"
				+ "En caso de haber un empate solo se mostrara que se ha empatado i en el ranking pondra\n"
				+ "que se ha empatado i los dos nombres");
	}

}
