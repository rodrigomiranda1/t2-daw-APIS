package pe.cibertec.edu.pe.dawit2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.edu.pe.dawit2.dto.PedidoDto;
import pe.cibertec.edu.pe.dawit2.model.Clientes;
import pe.cibertec.edu.pe.dawit2.model.Pedidos;
import pe.cibertec.edu.pe.dawit2.repository.PedidosRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidosService {

    private final PedidosRepository pedidosRepository;

    public List<Pedidos> listarPedidos(){
        return pedidosRepository.findAll();
    }

    public void registrarPedidos(PedidoDto dto){
        Clientes clientes = new Clientes();
        clientes.setClienteid(dto.getClienteid());
        Pedidos pedidos = new Pedidos();
        pedidos.setFechapedido(dto.getFechapedido());
        pedidos.setMonto(dto.getMonto());
        pedidos.setEstado(dto.getEstado());
        pedidos.setClientes(clientes);
        pedidosRepository.save(pedidos);
    }

    public void actualizarPedido(PedidoDto dto){
        pedidosRepository.actualizarPedidos(dto.getFechapedido(), dto.getMonto(), dto.getEstado(), dto.getClienteid(), dto.getPedidoid());
    }

    public PedidoDto buscarPedidoPorId(Integer id){
        Pedidos pedidos = pedidosRepository.findById(id).orElse(null);

        if (pedidos==null){
            return null;
        }else {
            PedidoDto dto = new PedidoDto();
            dto.setPedidoid(pedidos.getPedidoid());
            dto.setFechapedido(pedidos.getFechapedido());
            dto.setMonto(pedidos.getMonto());
            dto.setEstado(pedidos.getEstado());
            dto.setClienteid(pedidos.getClientes().getClienteid());
            return dto;
        }
    }

}
