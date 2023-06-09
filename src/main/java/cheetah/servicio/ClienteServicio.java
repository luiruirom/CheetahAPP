package cheetah.servicio;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cheetah.interfaz.ICliente;
import cheetah.modelo.Cliente;
import cheetah.servicioInterfaz.IClienteServicio;

@Service
public class ClienteServicio implements IClienteServicio {
	
	private static Logger logger = LoggerFactory.getLogger(ClienteServicio.class);
	
	@Autowired
	private ICliente data;

	@Override
	public List<Cliente> listar() {
		return (List<Cliente>) data.findAll();
	}

	@Override
	public Optional<Cliente> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public void save(Cliente c) {
		if (c.isValid(c)) {
			data.save(c);
		} else {
			logger.error("Alguno de los valores del cliente es erróneo, por favor, vuelve a intentarlo.");
		}	
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

	@Override
	public double getSaldo(int id) {
		return data.getSaldo(id);
	}

	@Override
	public void addSaldo(int id, double saldo) {
		data.addSaldo(id, saldo);		
	}

}
