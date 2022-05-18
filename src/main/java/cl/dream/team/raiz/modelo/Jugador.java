package cl.dream.team.raiz.modelo;

public class Jugador {
	
	
	//Atributes
	private int id;
	private String nombre;
	private String posicion;
	
	
	//Constructors
	public Jugador() {
	}

	public Jugador(int id, String nombre, String posicion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posicion = posicion;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	
	
	
}
