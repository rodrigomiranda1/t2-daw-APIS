package pe.cibertec.edu.pe.dawit2.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PedidoDto {

    private Integer pedidoid;
    private LocalDate fechapedido;
    private Double monto;
    private String estado;
    private Integer clienteid;
}
