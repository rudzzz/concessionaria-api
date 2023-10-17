package dev.rudzzz.concessionaria.controllers;

import dev.rudzzz.concessionaria.dtos.CarroDTO;
import dev.rudzzz.concessionaria.entities.Carro;
import dev.rudzzz.concessionaria.repositories.ModeloRepository;
import dev.rudzzz.concessionaria.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @Autowired
    private ModeloRepository modeloRepository;

    @GetMapping()
    public ResponseEntity<List<Carro>> listarTodosOsCarros() {
        List<Carro> carros = carroService.listarTodosOsCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/modelos")
    public ResponseEntity<Map<String, List<CarroDTO>>> listarModelosDeCarros() {
        List<CarroDTO> carrosFormatados = carroService.listarModelosDeCarros();

        Map<String, List<CarroDTO>> response = new HashMap<>();
        response.put("cars", carrosFormatados);

        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<String> criarCarro(@RequestBody Carro carro) {
        if (carro.getModeloId() != null && modeloRepository.existsById(carro.getModeloId())) {
            carroService.criarCarro(carro);
            return ResponseEntity.status(HttpStatus.OK).body("Carro cadastrado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Modelo não encontrado. Por favor, cadastre o modelo primeiro.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obterCarro(@PathVariable Long id) {
        Carro carro = carroService.obterCarroPorId(id);
        if (carro != null) {
            return ResponseEntity.ok(carro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody Carro carro) {
        Carro carroAtualizado = carroService.atualizarCarro(id, carro);
        if (carroAtualizado != null) {
            return ResponseEntity.ok(carroAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        carroService.deletarCarro(id);
        return ResponseEntity.noContent().build();
    }
}
