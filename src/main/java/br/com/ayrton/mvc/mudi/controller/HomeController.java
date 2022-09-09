package br.com.ayrton.mvc.mudi.controller;

import br.com.ayrton.mvc.mudi.model.Pedido;
import br.com.ayrton.mvc.mudi.model.enums.StatusPedido;
import br.com.ayrton.mvc.mudi.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final PedidoService pedidoService;

    public HomeController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public String home(Model model){
        List<Pedido> pedidos = pedidoService.getAll();
        model.addAttribute("pedidos",pedidos);
        return "home";
    }

//    @GetMapping("pedido/{status}")
//    public String porStatus(@PathVariable("status")String status, Model model, Principal principal){
//        List<Pedido> pedidos = pedidoService.buscarPorStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
//        model.addAttribute("pedidos",pedidos);
//        model.addAttribute("status",status);
//        return "usuario/home";
//    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
}
