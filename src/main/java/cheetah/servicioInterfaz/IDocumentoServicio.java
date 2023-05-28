package cheetah.servicioInterfaz;

import java.util.List;

import cheetah.modelo.Documento;

public interface IDocumentoServicio {
	
	public List<Documento>listar();
	public Documento listarNombre(String nombre);
}
