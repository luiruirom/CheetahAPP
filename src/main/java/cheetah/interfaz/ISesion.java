package cheetah.interfaz;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cheetah.modelo.Sesion;

public interface ISesion extends CrudRepository<Sesion, Integer>{
	
	@Query("SELECT inicio_Sesion FROM Sesion where id = :id")
	String findHoraInicio(@Param(value = "id") int id);
	
	@Query("SELECT fin_Sesion FROM Sesion where id = :id")
	LocalDateTime findHoraFin(@Param(value = "id") int id);
	
	@Query("SELECT id FROM Sesion s where s.num_Serie = :num_Serie AND s.fin_Sesion = NULL")
	int findOrdenadorSesionActiva(@Param(value = "num_Serie") String numSerie);
	
	@Query("SELECT usuario_Reserva FROM Sesion where id = :id")
	String findUser(@Param(value = "id") int id);
		
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO Sesion s (s.id, s.inicio_Sesion, s.num_Serie, s.coste_Total, s.usuario_Reserva) VALUES (:id, :inicio_Sesion, :num_Serie, '0', :usuario_Reserva)", nativeQuery = true)
	void iniciarSesion(@Param(value = "id") int id, @Param(value = "inicio_Sesion") LocalDateTime horaActual, @Param(value = "num_Serie") String numSerie, @Param(value = "usuario_Reserva") String usuarioReserva);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO Sesion s (s.id, s.inicio_Sesion, s.num_Serie, s.usuario_Reserva, s.coste_Total) VALUES (:id, :inicio_Sesion, :num_Serie, :usuario_Reserva, '0')", nativeQuery = true)
	void reservarSesion(@Param(value = "id") int id, @Param(value = "inicio_Sesion") LocalDateTime horaActual, @Param(value = "num_Serie") String numSerie, @Param(value = "usuario_Reserva") String usuario_Reserva);
	
	@Transactional
	@Modifying
	@Query("UPDATE Sesion s SET s.fin_Sesion = :fin_Sesion, s.coste_Total = :coste_Total WHERE s.num_Serie = :num_Serie AND s.fin_Sesion = NULL")
	void cerrarSesion(@Param(value = "fin_Sesion") LocalDateTime finSesion, @Param(value = "coste_Total") double costeTotal,  @Param(value = "num_Serie") String numSerie);
	
	@Query("SELECT coste_Total FROM Sesion where id = :id")
	double findCosteSesion(@Param(value = "id") int id);
	
	//Lista de dinero recaudado por ordenador
	@Query("SELECT num_Serie, SUM(coste_Total) FROM Sesion GROUP BY num_Serie")
	List<String> listarSesiones(); 
	
	//Dinero total en caja
	@Query("SELECT SUM(coste_Total) FROM Sesion")
	Double dineroTotal();
	
	@Query("SELECT COUNT(*) FROM Sesion")
	int nextId();
}
