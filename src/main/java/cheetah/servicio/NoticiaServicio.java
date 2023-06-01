package cheetah.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cheetah.modelo.Noticia;
import cheetah.modelo.NoticiaJson;
import cheetah.servicioInterfaz.INoticiaServicio;

@Service
public class NoticiaServicio implements INoticiaServicio{
	
	@Value("${url.noticias}")
	private String urlNoticias;
	
	private RestTemplate restTemplate;
	
	public NoticiaServicio() {
		this.restTemplate = new RestTemplate();
	}
	
	@Override
	public List<Noticia> listar() {
		List<Noticia> listaAMostrar = new ArrayList<>();
		List<Noticia> noticiasDeApi = restTemplate.getForObject(urlNoticias, NoticiaJson.class).getArticulos();
		
		for (int i = 0; i < 3; i++) {
			if(noticiasDeApi.get(i).getImagenUrl() == null) {
				noticiasDeApi.get(i).setImagenUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Imagen_no_disponible.svg/2048px-Imagen_no_disponible.svg.png");
			}
			listaAMostrar.add(noticiasDeApi.get(i));
		}
		
		return listaAMostrar;
		
	}
	
}
