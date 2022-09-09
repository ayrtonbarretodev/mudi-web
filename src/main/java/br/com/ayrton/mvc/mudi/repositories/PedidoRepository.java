package br.com.ayrton.mvc.mudi.repositories;

import br.com.ayrton.mvc.mudi.model.Pedido;
import br.com.ayrton.mvc.mudi.model.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    List<Pedido> findByStatus(StatusPedido status);

    @Query("select p from Pedido p join p.user u where u.username = :username")
    List<Pedido> findAllByUser(@Param("username") String nome);

    @Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
    List<Pedido> findByStatusAndUser(@Param("status") StatusPedido status, @Param("username") String user);
}
