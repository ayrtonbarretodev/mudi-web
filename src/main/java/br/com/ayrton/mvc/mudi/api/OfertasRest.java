package br.com.ayrton.mvc.mudi.api;

import br.com.ayrton.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.ayrton.mvc.mudi.model.Oferta;
import br.com.ayrton.mvc.mudi.model.Pedido;
import br.com.ayrton.mvc.mudi.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/ofertas")
public class OfertasRest {

    private PedidoService pedidoService;

    public OfertasRest(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Oferta> criarOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao){
        Optional<Pedido> pedidoBuscado = pedidoService.buscarPorId(requisicao.getPedidoId());
        if (!pedidoBuscado.isPresent()){
            return null;
        }

        Pedido pedido = pedidoBuscado.get();

        Oferta nova = requisicao.toOferta();
        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);
        pedidoService.cadastrar(pedido);

        return ResponseEntity.ok().body(nova);
    }
}
