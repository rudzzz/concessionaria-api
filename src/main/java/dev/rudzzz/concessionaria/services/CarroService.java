package dev.rudzzz.concessionaria.services;

import dev.rudzzz.concessionaria.dtos.CarroDTO;
import dev.rudzzz.concessionaria.entities.Carro;
import dev.rudzzz.concessionaria.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarTodosOsCarros() {
        return carroRepository.findAll();
    }

    public List<CarroDTO> listarModelosDeCarros() {
        List<Carro> carros = carroRepository.findAll();

        List<CarroDTO> carrosFormatados = carros.stream()
                .map(carro -> {
                    CarroDTO carroDTO = new CarroDTO();
                    carroDTO.setId(carro.getId());
                    carroDTO.setTimestampCadastro(carro.getTimestampCadastro());
                    carroDTO.setModeloId(carro.getModelo().getId());
                    carroDTO.setAno(carro.getAno());
                    carroDTO.setCombustivel(carro.getCombustivel());
                    carroDTO.setNumPortas(carro.getNumPortas());
                    carroDTO.setNomeModelo(carro.getModelo().getNome());
                    carroDTO.setCor(carro.getCor());
                    carroDTO.setValor(carro.getModelo().getValorFipe());
                    return carroDTO;
                })
                .collect(Collectors.toList());

        return carrosFormatados;
    }

    public Carro criarCarro(Carro carro) {
        Long unixTimestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        carro.setTimestampCadastro(unixTimestamp);

        return carroRepository.save(carro);
    }

    public Carro obterCarroPorId(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    public Carro atualizarCarro(Long id, Carro novoCarro) {
        if (carroRepository.existsById(id)) {
            novoCarro.setId(id);
            return carroRepository.save(novoCarro);
        }
        return null;
    }

    public void deletarCarro(Long id) {
        carroRepository.deleteById(id);
    }
}

