package cheetah.modelo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoticiaJson {
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("articles")
	private ArrayList<Noticia> articulos;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<Noticia> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Noticia> articulos) {
		this.articulos = articulos;
	}

	@Override
	public String toString() {
		return "NoticiaJson [status=" + status + ", url=" + url + ", articulos=" + articulos + "]";
	}
	
	
}
