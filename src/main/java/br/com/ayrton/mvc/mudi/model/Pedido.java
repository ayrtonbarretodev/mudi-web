package br.com.ayrton.mvc.mudi.model;

import br.com.ayrton.mvc.mudi.model.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Oferta> ofertas;
}
