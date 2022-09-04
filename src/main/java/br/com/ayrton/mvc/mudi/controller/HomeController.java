package br.com.ayrton.mvc.mudi.controller;

import br.com.ayrton.mvc.mudi.model.Pedido;
import br.com.ayrton.mvc.mudi.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final PedidoService pedidoService;

    public HomeController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/home")
    public String home(Model model){
        List<Pedido> pedidos = pedidoService.getAll();
        model.addAttribute("pedidos",pedidos);
        return "home";
    }
}
