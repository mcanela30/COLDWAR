//Marti Canela, Gabriel Gómez
public class planeta {
	
	//Creamos las variables
	private static int vidas=0;
	private String nombre=null;
	private static int misiles_ronda=0;
	private int numero_equipos=0;
	
	
	//Creamos Getters y Setters
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getMisiles_ronda() {
		return misiles_ronda;
	}
	public void setMisiles_ronda(int misiles_ronda) {
		this.misiles_ronda = misiles_ronda;
	}
	public int getNumero_equipos() {
		return numero_equipos;
	}
	public void setNumero_equipos(int numero_equipos) {
		this.numero_equipos = numero_equipos;
	}
	
	public planeta(String nombre, int numero_equipos) {
		this.nombre = nombre;
		this.vidas = 200;
		this.misiles_ronda = 50;
		this.numero_equipos = numero_equipos;
	}
	
	public static void atacarEquipo(int ataque) {
		misiles_ronda=misiles_ronda-ataque;
	}
	
	public static void quitarVida(int ataque, int equipo) {
		misiles_ronda=misiles_ronda-ataque;
		vidas=vidas-ataque;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo "+numero_equipos+": "+nombre+" --> "+vidas); 
        return sb.toString();
    }
	




		
	}



