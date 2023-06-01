package cheetah.modelo;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Noticia {
	
	@JsonProperty("source")
	private HashMap<String, String> fuente = new HashMap<>();
	
	@JsonProperty("author")
	private String autor;
	
	@JsonProperty("title")
	private String titulo;
	
	@JsonProperty("description")
	private String descripcion;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("urlTOImage")
	private String imagenUrl;
	
	@JsonProperty("publishedAt")
	private String fechaPublicacion;
	
	@JsonProperty("content")
	private String contenido;

	public HashMap<String, String> getFuente() {
		return fuente;
	}

	public void setFuente(HashMap<String, String> fuente) {
		this.fuente = fuente;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Noticia [fuente=" + fuente + ", autor=" + autor + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", url=" + url + ", imagenUrl=" + imagenUrl + ", fechaPublicacion=" + fechaPublicacion
				+ ", contenido=" + contenido + "]";
	} 
}
