package pe.cibertec.edu.pe.dawit2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.edu.pe.dawit2.dto.PedidoDto;
import pe.cibertec.edu.pe.dawit2.model.Pedidos;
import pe.cibertec.edu.pe.dawit2.service.PedidosService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/t2/pedidos")
public class PedidosController {

    private final PedidosService pedidosService;

    @GetMapping
    public ResponseEntity<List<Pedidos>> getAllPedidos(){
        return new ResponseEntity<List<Pedidos>>(pedidosService.listarPedidos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> buscarPedidoPorId(@PathVariable Integer id){
        return new ResponseEntity<PedidoDto>(pedidosService.buscarPedidoPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createPedido(@RequestBody PedidoDto dto){
        Map<String, String> response = new HashMap<>();

        try {
            pedidosService.registrarPedidos(dto);
            response.put("mensaje", "Pedido registrado correctamente");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            response.put("mensaje", "Ocurrio un error al registar pedido");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> actualizarPedido(@PathVariable Integer id, @RequestBody PedidoDto dto){
        Map<String, String> response = new HashMap<>();

        try {
            dto.setPedidoid(id);
            pedidosService.actualizarPedido(dto);
            response.put("mensaje", "Pedido actualizado correctamente");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            response.put("mensaje", "Ocurrio un error al actualizar");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
