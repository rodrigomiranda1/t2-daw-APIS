package pe.cibertec.edu.pe.dawit2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.cibertec.edu.pe.dawit2.model.Clientes;
import pe.cibertec.edu.pe.dawit2.service.ClientesService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/t2/clientes")
public class ClientesController {

    private final ClientesService clientesService;

    @GetMapping
    public ResponseEntity<List<Clientes>> getAllClientes(){
        return new ResponseEntity<List<Clientes>>(clientesService.listarClientes(), HttpStatus.OK);
    }
}
