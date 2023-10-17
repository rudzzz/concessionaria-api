package dev.rudzzz.concessionaria.services;

import dev.rudzzz.concessionaria.entities.Modelo;
import dev.rudzzz.concessionaria.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    public Modelo criarModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public List<Modelo> listarTodosOsModelos() {
        return modeloRepository.findAll();
    }

    public Modelo obterModeloPorId(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    public Modelo atualizarModelo(Long id, Modelo novoModelo) {
        Modelo modeloExistente = modeloRepository.findById(id).orElse(null);
        if (modeloExistente != null) {
            modeloExistente.setNome(novoModelo.getNome());
            modeloExistente.setValorFipe(novoModelo.getValorFipe());

            return modeloRepository.save(modeloExistente);
        } else {
            return null;
        }
    }

    public void deletarModelo(Long id) {
        modeloRepository.deleteById(id);
    }

    public List<Modelo> listarModelos() {
        return modeloRepository.findAll();
    }
}
