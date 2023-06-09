package cheetah.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cheetah.utils.*;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	private static Logger logger = LoggerFactory.getLogger(Cliente.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(unique = true)
	private String dni;

	@Column(unique = true)
	private String username;

	private String nombre;
	private String apellido1;
	private String apellido2;
	private int telefono;
	private String correo;

	private double saldo;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Validador de los distintos campos del cliente
	public boolean isValid(Cliente c) {

		boolean res = false;
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher mat = pattern.matcher(c.getCorreo());

		// Se valida el dni
		for (int i = 0; i < c.getDni().length() - 2; i++) {
			if (!Utiles.LISTA_NUMEROS.contains(Character.getNumericValue(c.getDni().charAt(i)))) {
				logger.error("Error dni");
				return res;
			}
		}

		if (!Character.isLetter(c.getDni().charAt(c.getDni().length() - 1))) {
			logger.error("Error letra dni");
			return res;
		}

		// Se valida el nombre de usuario
		for (int i = 0; i < c.getUsername().length() - 1; i++) {
			if (!Character.isLetter(c.getUsername().charAt(i))) {
				logger.error("Error nombre usuario");
				return res;
			}
		}

		// Se valida el nombre
		for (int i = 0; i < c.getNombre().length() - 1; i++) {
			if (!Character.isLetter(c.getNombre().charAt(i)) && !Character.isWhitespace(c.getNombre().charAt(i))) {
				logger.error("Error nombre");
				return res;
			}
		}

		// Se valida el primer apellido
		for (int i = 0; i < c.getApellido1().length() - 1; i++) {
			if (!Character.isLetter(c.getApellido1().charAt(i)) && !Character.isWhitespace(c.getNombre().charAt(i))) {
				logger.error("Error apellido1");
				return res;
			}
		}

		// Se valida el segundo apellido
		for (int i = 0; i < c.getApellido2().length() - 1; i++) {
			if (!Character.isLetter(c.getApellido2().charAt(i)) && !Character.isWhitespace(c.getNombre().charAt(i))) {
				logger.error("Error apellido2");
				return res;
			}
		}

		// Se valida el telefono
		if (c.getTelefono() != (int) c.getTelefono() || c.getTelefono() >= 1000000000 || c.getTelefono() < 600000000) {
			logger.error("Error telefono");
			return res;
		}

		// Se valida el correo
		if (!mat.matches()) {
			logger.error("Error correo");
			return res;
		}

		res = true;
		return res;
	}

}
