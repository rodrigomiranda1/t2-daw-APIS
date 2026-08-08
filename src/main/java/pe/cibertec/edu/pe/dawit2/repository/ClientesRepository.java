package pe.cibertec.edu.pe.dawit2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.pe.dawit2.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
}
