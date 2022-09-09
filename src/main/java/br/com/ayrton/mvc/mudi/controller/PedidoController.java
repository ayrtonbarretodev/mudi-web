package br.com.ayrton.mvc.mudi.controller;

import br.com.ayrton.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.ayrton.mvc.mudi.model.Pedido;
import br.com.ayrton.mvc.mudi.model.User;
import br.com.ayrton.mvc.mudi.service.PedidoService;
import br.com.ayrton.mvc.mudi.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final UserService userService;

    public PedidoController(PedidoService pedidoService, UserService userService) {
        this.pedidoService = pedidoService;
        this.userService = userService;
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

        //Pegando o usuário que está logado p/ atribuí-lo ao pedido
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();

        //Buscando o usuário no banco
        User user = userService.buscarPorNome(username);


        Pedido pedido = requisicao.toPedido();
        //Setando o usuário no pedido
        pedido.setUser(user);
        pedidoService.cadastrar(pedido);
        return "redirect:/home";
    }
}
