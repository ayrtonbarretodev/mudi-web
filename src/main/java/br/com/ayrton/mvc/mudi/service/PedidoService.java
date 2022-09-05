package br.com.ayrton.mvc.mudi.service;

import br.com.ayrton.mvc.mudi.repositories.PedidoRepository;
import br.com.ayrton.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getAll(){
        return pedidoRepository.findAll();
    }

    public void cadastrar(Pedido pedido){
        pedidoRepository.save(pedido);
    }
}
