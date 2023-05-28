package cheetah.controlador;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cheetah.modelo.Documento;
import cheetah.servicioInterfaz.IDocumentoServicio;

@Controller
@RequestMapping
public class ControladorDocumento {

	private static final String RUTA = "E:\\dev\\Facturas\\";

	@Autowired
	private IDocumentoServicio servicio;

	@GetMapping("/listarDocumentos")
	public String listar(Model model) {
		List<Documento> listaDocumentos = servicio.listar();
		model.addAttribute("listaDocumentos", listaDocumentos);
		return "admin/documentos";
	}

	@GetMapping("/descarga/{nombre}")
	@ResponseBody
	public void descargarDocumento(@PathVariable String nombre, HttpServletResponse response) {

		response.setHeader("Content-Disposition", "attachment; filename=" + nombre);
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(RUTA + nombre);
			int len;
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) > 0) {
				bos.write(buf, 0, len);
			}
			fis.close();
			bos.close();
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
