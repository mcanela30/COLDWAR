package coldwar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class APARTADO_ABIERTO {

	private boolean flag = false;
	private int[] points = null;
	private Planet[] teams = null;
	private String winner = "";
	private int tied = 0;
	private int number = 0;
	private Planet tmp2;
	private String winner1, winner2;

	public APARTADO_ABIERTO(JUGAR ju) {

		if (ju != null) {
			number = ju.nnnn;

			teams = ju.getTeams();
			sortArrays2();
			showWinner();
		} else {
			System.out.println("Deberías jugar el juego primero para mostrar al ganador");
		}
	}

	public int getGreater() {
		int large = points[0];
		int index = 0;
		for (int i = 1; i < points.length; i++) {
			if (large < points[i]) {
				large = points[i];
				index = i;
			}
		}

		System.out.println();
		return large;
	}

	public void showWinner() {
		if (tied > 1) {
			System.out.println("El juego está atado Así que hay más de 1 ganador \n");
		} else {
			System.out.println("El ganador es ::::::::\n" + teams[0].getName());
		}
		try {
			WriteResult();
		} catch (IOException ex) {
			System.out.println("Errorcito en el manejo de archivos");
		}
	}

	// El método que escribe toda la información del método en el archivo de texto
	// toma la lista de puntos como parámetro
	public void WriteResult() throws IOException {
		// Crear objeto de archivo
		File f = new File("src\\coldwar\\Result.txt");

		// Comprobar que el archivo ya existe o no si no existe crear un nuevo archivo
		if (!f.exists()) {
			f.createNewFile();
		}

		// Crear objeto de escritor del archivo creado
		PrintWriter writer = new PrintWriter(f);
		// Eliminar todos los datos del archivo
		writer.print("");
		writer.append("equipo Rank          equipo Name          Team Lives");
		// Ahora escribe nuevos datos en el archivo
		String space1 = "";
		int no = 0;
		for (int i = number - 1; i > -1; i--) {
			no++;
			for (int j = 0; j < 19 - teams[i].getName().length(); j++) {
				space1 = space1 + " ";
			}

			writer.append("\n   " + no + "               " + teams[i].getName() + "                       "
					+ teams[i].getLives());

			space1 = "";
		}
		writer.append("\n\nNote: It's Not Result of 1 Round It's overall Result of All Rounds");
		// Cerrar el archivo
		writer.close();
	}

	// Función para ordenar el pointay
	// usando un solo bucle
	public void sortArrays2() {

		// Encontrar la longitud de los puntos, diga 'puntos'
		int length = number;

		// Ordenar usando un solo bucle
		for (int j = 0; j < length - 1; j++) {

			// Comprobando la condición para dos
			// elementos simultáneos del pointay
			if (teams[j].getLives() > teams[j + 1].getLives()) {

				// Intercambio de elementos.
				int temp = teams[j].getLives();
				teams[j].setLives(teams[j + 1].getLives());
				teams[j + 1].setLives(temp);

				// actualizando el valor de j = -1
				// así que después de actualizarse para j ++
				// en el bucle se convierte en 0 y
				// el ciclo comienza desde el principio.
				j = -1;
			}
		}
	}

}
