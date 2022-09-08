package br.com.ayrton.mvc.mudi.controller;

import br.com.ayrton.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.ayrton.mvc.mudi.model.Pedido;
import br.com.ayrton.mvc.mudi.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result){
        if (result.hasErrors()){
            return "pedido/formulario";
        }
        Pedido pedido = requisicao.toPedido();
        pedidoService.cadastrar(pedido);
        return "redirect:/home";
    }
}
