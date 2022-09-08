package br.com.ayrton.mvc.mudi.repositories;

import br.com.ayrton.mvc.mudi.model.Pedido;
import br.com.ayrton.mvc.mudi.model.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    List<Pedido> findByStatus(StatusPedido status);
}
