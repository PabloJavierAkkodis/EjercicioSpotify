package pojos;

public class Artista {
	
	String nombre, genero;
	int canciones, reproducciones, suscripciones;
	
	double gananciaTotal;
	
	public Artista(String nombre, String genero, int canciones, int reproducciones, int suscripciones) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.canciones = canciones;
		this.reproducciones = reproducciones;
		this.suscripciones = suscripciones;
		this.gananciaTotal = calcularGanancia();
		
	}
	private double calcularGanancia() {
		
		return this.reproducciones * 0.02;
	}
	public Artista() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getCanciones() {
		return canciones;
	}
	public void setCanciones(int canciones) {
		this.canciones = canciones;
	}
	public int getReproducciones() {
		return reproducciones;
	}
	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
		this.gananciaTotal = calcularGanancia();
	}
	public int getSuscripciones() {
		return suscripciones;
	}
	public void setSuscripciones(int suscripciones) {
		this.suscripciones = suscripciones;
	}
	@Override
	public String toString() {
		return nombre + "\t" + genero + "\t" + canciones + "\t"
				+ reproducciones + "\t" + suscripciones + "\t" + gananciaTotal + "$\n";
	}
	
	
	
}
