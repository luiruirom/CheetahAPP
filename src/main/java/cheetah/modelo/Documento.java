package cheetah.modelo;

public class Documento {
	
	private String nombre;
	
	private String ruta;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Documento [nombre=" + nombre + ", ruta=" + ruta + "]";
	}

}
