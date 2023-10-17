package dev.rudzzz.concessionaria.repositories;

import dev.rudzzz.concessionaria.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
