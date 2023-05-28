package cheetah.interfaz;

import org.springframework.data.repository.CrudRepository;

import cheetah.modelo.Empleado;

public interface IEmpleado extends CrudRepository<Empleado, Integer> {

}
