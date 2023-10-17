package dev.rudzzz.concessionaria.controllers;

import dev.rudzzz.concessionaria.entities.Marca;
import dev.rudzzz.concessionaria.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping()
    public ResponseEntity<List<Marca>> listarTodasAsMarcas() {
        List<Marca> marcas = marcaService.listarTodasAsMarcas();
        return ResponseEntity.ok(marcas);
    }

    @PostMapping
    public ResponseEntity<Marca> criarMarca(@RequestBody Marca marca) {
        Marca novaMarca = marcaService.criarMarca(marca);
        return ResponseEntity.ok(novaMarca);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> obterMarca(@PathVariable Long id) {
        Marca marca = marcaService.obterMarcaPorId(id);
        if (marca != null) {
            return ResponseEntity.ok(marca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizarMarca(@PathVariable Long id, @RequestBody Marca marca) {
        Marca marcaAtualizada = marcaService.atualizarMarca(id, marca);
        if (marcaAtualizada != null) {
            return ResponseEntity.ok(marcaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMarca(@PathVariable Long id) {
        try {
            marcaService.deletarMarca(id);
            return ResponseEntity.status(HttpStatus.OK).body("Marca excluído com sucesso.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não é possível excluir a marca. Existem modelos associados a ela.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao excluir o modelo.");
        }
    }
}
