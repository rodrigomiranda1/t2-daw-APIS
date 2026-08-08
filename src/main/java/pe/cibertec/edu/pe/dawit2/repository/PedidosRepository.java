package pe.cibertec.edu.pe.dawit2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.cibertec.edu.pe.dawit2.model.Pedidos;

import java.time.LocalDate;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {

    @Transactional
    @Modifying
    @Query(value = """
        update pedidos set fechapedido=:fechapedido, monto=:monto, estado=:estado,
                clienteid=:clienteid where pedidoid=:pedidoid
                """, nativeQuery = true)
    public void actualizarPedidos(@Param("fechapedido")LocalDate fechapedido,
                                  @Param("monto") Double monto,
                                  @Param("estado") String estado,
                                  @Param("clienteid") Integer clienteid,
                                  @Param("pedidoid")Integer pedidoid);
}
