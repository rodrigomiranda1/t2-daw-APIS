package pe.cibertec.edu.pe.dawit2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "pedidos")
@Entity
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pedidoid;

    private LocalDate fechapedido;
    private Double monto;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "clienteid")
    private Clientes clientes;
}
