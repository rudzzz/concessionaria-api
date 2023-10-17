package dev.rudzzz.concessionaria.controllers;


import dev.rudzzz.concessionaria.entities.Modelo;
import dev.rudzzz.concessionaria.repositories.MarcaRepository;
import dev.rudzzz.concessionaria.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {
    @Autowired
    private ModeloService modeloService;

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping()
    public ResponseEntity<List<Modelo>> listarTodosOsModelos() {
        List<Modelo> modelos = modeloService.listarTodosOsModelos();
        return ResponseEntity.ok(modelos);
    }

    @PostMapping
    public ResponseEntity<String> criarModelo(@RequestBody Modelo modelo) {
        if (modelo.getMarcaId() != null && marcaRepository.existsById(modelo.getMarcaId())) {
            Modelo novoModelo = modeloService.criarModelo(modelo);
            return ResponseEntity.status(HttpStatus.OK).body("Modelo cadastrado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Marca não encontrada. Por favor, cadastre a marca primeiro.");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Modelo> obterModelo(@PathVariable Long id) {
        Modelo modelo = modeloService.obterModeloPorId(id);
        if (modelo != null) {
            return ResponseEntity.ok(modelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> atualizarModelo(@PathVariable Long id, @RequestBody Modelo modelo) {
        Modelo modeloAtualizado = modeloService.atualizarModelo(id, modelo);
        if (modeloAtualizado != null) {
            return ResponseEntity.ok(modeloAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarModelo(@PathVariable Long id) {
        try {
            modeloService.deletarModelo(id);
            return ResponseEntity.status(HttpStatus.OK).body("Modelo excluído com sucesso.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não é possível excluir o modelo. Existem carros associados a ele.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao excluir o modelo.");
        }
    }
}
