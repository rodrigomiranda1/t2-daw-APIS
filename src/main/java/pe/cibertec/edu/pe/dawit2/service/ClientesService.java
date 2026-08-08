package pe.cibertec.edu.pe.dawit2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.edu.pe.dawit2.model.Clientes;
import pe.cibertec.edu.pe.dawit2.repository.ClientesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientesService {

    private final ClientesRepository clientesRepository;

    public List<Clientes> listarClientes(){
        return clientesRepository.findAll();
    }

}
