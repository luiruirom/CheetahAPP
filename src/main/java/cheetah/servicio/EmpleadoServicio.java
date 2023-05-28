package cheetah.servicio;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cheetah.interfaz.IEmpleado;
import cheetah.modelo.Empleado;
import cheetah.servicioInterfaz.IEmpleadoServicio;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{
	
	private static Logger logger = LoggerFactory.getLogger(EmpleadoServicio.class);
	
	@Autowired
	private IEmpleado data;

	@Override
	public List<Empleado> listar() {
		return (List<Empleado>) data.findAll();
	}

	@Override
	public Optional<Empleado> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public void save(Empleado e) {
		if (e.isValid(e)) {
			data.save(e);
		} else {
			logger.error("Intento fallido");
		}
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
	
	
}
