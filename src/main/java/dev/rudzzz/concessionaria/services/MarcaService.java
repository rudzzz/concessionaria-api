package dev.rudzzz.concessionaria.services;

import dev.rudzzz.concessionaria.entities.Marca;
import dev.rudzzz.concessionaria.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca criarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca obterMarcaPorId(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca atualizarMarca(Long id, Marca novaMarca) {
        Marca marcaExistente = marcaRepository.findById(id).orElse(null);
        if (marcaExistente != null) {
            marcaExistente.setNomeMarca(novaMarca.getNomeMarca());

            return marcaRepository.save(marcaExistente);
        } else {
            return null;
        }
    }

    public void deletarMarca(Long id) {
        marcaRepository.deleteById(id);
    }

    public List<Marca> listarTodasAsMarcas() {
        return marcaRepository.findAll();
    }
}
