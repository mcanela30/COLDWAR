//Marti Canela, Gabriel Gómez
public class planeta {
	
	//Creamos las variables
	private int vidas=25;
	private String nombre=null;
	private int misiles_ronda=0;
	private int numero_equipos=0;
	private boolean ataquedefansa=true;
	private int misilesDefensa=0;
	
	
	//Creamos Getters y Setters para poder coger las variables, al ser private, en los otros ficheros.
	public int getMisilesDefensa() {
		return misilesDefensa;
	}

	public void setMisilesDefensa(int misilesDefensa) {
		this.misilesDefensa = misilesDefensa;
	}

	public planeta(String nombre, int numero_equipos) {
		this.nombre = nombre;
		this.vidas = 25;
		this.misiles_ronda = 50;
		this.numero_equipos = numero_equipos;
	}
	
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vida, int vidas) {
		this.vidas = vidas-vida;
	}
	public void setVidasDefensa(int defensa) {
		if (ataquedefansa==false) {
		this.vidas = vidas+defensa;
		}		
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
	
	public void quitarVida() {
		vidas=vidas+misilesDefensa;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo "+numero_equipos+": "+nombre+" --> "+vidas); 
        return sb.toString();
    }
	
	
	
	




		
	}



