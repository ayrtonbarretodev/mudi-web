package br.com.ayrton.mvc.mudi.service;

import br.com.ayrton.mvc.mudi.model.Pedido;
import br.com.ayrton.mvc.mudi.model.User;
import br.com.ayrton.mvc.mudi.model.enums.StatusPedido;
import br.com.ayrton.mvc.mudi.repositories.PedidoRepository;
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

    public List<Pedido> buscarPedidosPorUsuario(String nome){
        return pedidoRepository.findAllByUser(nome);
    }

    public void cadastrar(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    public List<Pedido> buscarPorStatusEUsuario(StatusPedido status, String user){
        return pedidoRepository.findByStatusAndUser(status,user);
    }

    public List<Pedido> buscarPorStatus(StatusPedido status){
        return pedidoRepository.findByStatus(status);
    }

}
