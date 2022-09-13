package br.com.ayrton.mvc.mudi.api;

import br.com.ayrton.mvc.mudi.model.Pedido;
import br.com.ayrton.mvc.mudi.model.enums.StatusPedido;
import br.com.ayrton.mvc.mudi.service.PedidoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    private final PedidoService pedidoService;

    public PedidosRest(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("aguardando")
    public List<Pedido> getPedidosAguardandoOfertas(){
        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);
        return pedidoService.buscarPorStatus(StatusPedido.AGUARDANDO,paginacao);
    }
}
