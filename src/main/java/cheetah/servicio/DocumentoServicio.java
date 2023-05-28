package cheetah.servicio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cheetah.modelo.Documento;
import cheetah.servicioInterfaz.IDocumentoServicio;

@Service
public class DocumentoServicio implements IDocumentoServicio{
	
	private static final String RUTA = "E:\\dev\\Facturas";
	
	@Override
	public List<Documento> listar() {
		List<Documento> documentos = new ArrayList<Documento>();
        File directorio = new File(RUTA);
        File[] ficheros = directorio.listFiles();
        if (ficheros != null) {
            for (File fichero : ficheros) {
                if (fichero.isFile()) {
                    Documento documento = new Documento();
                    documento.setNombre(fichero.getName());
                    documento.setRuta(fichero.getAbsolutePath());
                    documentos.add(documento);
                }
            }
        }
        return documentos;
	}

	@Override
	public Documento listarNombre(String nombre) {
		File directorio = new File(RUTA);
        File[] ficheros = directorio.listFiles();
        if (ficheros != null) {
            for (File fichero : ficheros) {
                if (fichero.isFile() && fichero.getName().equals(nombre)) {
                    Documento documento = new Documento();
                    documento.setNombre(fichero.getName());
                    documento.setRuta(fichero.getAbsolutePath());
                    return documento;
                }
            }
        }
        return null;
	}
	
}
