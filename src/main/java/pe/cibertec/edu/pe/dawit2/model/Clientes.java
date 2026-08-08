package pe.cibertec.edu.pe.dawit2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "clientes")
@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clienteid;

    private String nombre;
    private String correoelectronico;
}
